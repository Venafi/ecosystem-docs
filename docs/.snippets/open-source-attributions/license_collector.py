#!/usr/bin/python

#  Copyright 2022 Venafi, Inc.
#  All Rights Reserved.
#
#  This program is unpublished proprietary source code of Venafi, Inc.
#  Your use of this code is limited to those rights granted in the license between you and Venafi.


# This application aids in the generation of third party attribution for dependencies
# used by VSat services.
# go-licenses is used to download the licenses from each project found in the configuration.
# Once the licenses are downloaded the projects are formatted in to markdown files.

import argparse
import csv
from datetime import date
import io
import os
import requests
import subprocess
import yaml
import zipfile

LICENSES_DIR = "go-licenses"
LICENSE_CSV = "license.csv"

# Project name, Project name, date generated
PROJECT_HEADER_TEMPLATE = """
---

##  [{}]()



The following 3rd-party software packages may be used by or distributed with **{}**.  Any information relevant to third-party vendors listed below are collected using common, reasonable means.


Date generated: {}

---




### Dependencies
"""
# Dependency name, license url, license name, license content
DEPENDENCY_TEMPLATE = """
#### [{}]({})


##### Declared License
{}


```
{}

```
"""

class Project:
    def __init__(self, name, project_root, md_name):
        self.name = name
        self.path = project_root
        self.md_name = md_name


def read_config(config_path):
    config = {}
    with open(config_path, "r") as yamlfile:
        config = yaml.load(yamlfile, Loader=yaml.FullLoader)
    
    if "repos" not in config:
        raise Exception(f'Missing repos in configuration file {config_path}')

    if "md-files" not in config:
        raise Exception(f'Missing md-files in configuration file {config_path}')

    return config


def download_license_data(config, bb_access_key):
    downloaded_projects = []

    print("--- Dependency Download ---")

    for repo in config["repos"]:

        repo_root = f'{LICENSES_DIR}/{repo["name"]}'

        print("Downloading Repo:", repo["name"])

        if not os.path.exists(repo_root):
            os.makedirs(repo_root)

        r = requests.get(repo["repo-url"], headers={"Authorization": f'Bearer {bb_access_key}'})
        if not r.ok:
            raise Exception(f'Failed to download archive for {repo["name"]} {repo["repo-url"]}, error: {r.status_code}, {r.text}')

        repo_source_root = f'{repo_root}/source'
        z = zipfile.ZipFile(io.BytesIO(r.content))
        z.extractall(repo_source_root)
        z.close()

        for project in repo["projects"]:

            project_root = f'{repo_root}/{project["name"]}'

            print("\t", project["name"])

            if not os.path.exists(project_root):
                os.makedirs(project_root)

            # go-licenses expect proto files to be generated. We avoid this issue by removing the proto dependency.
            if "protos" in project:
                protos = project["protos"]
                for proto in protos:
                    if proto["ignore"]:
                        file_contents = ""
                        proto_path = f'{repo_source_root}/{proto["path"]}'
                        with open(proto_path, "r") as file_with_proto:
                            file_contents = file_with_proto.readlines()

                        file_contents = list(filter(lambda line: (proto["package"] not in line), file_contents))

                        with open(proto_path, "w") as file:
                            file.write("".join(file_contents))

            license_csv = subprocess.run(["go-licenses", "csv", "./..."], capture_output=True, cwd=f'{repo_source_root}/{project["root-dir"]}')

            if license_csv.returncode != 0:
                raise Exception(f'Failed to execute go-licenses csv for project {project["name"]}, error: {license_csv.stderr}')

            with open(f'{project_root}/{LICENSE_CSV}', "wb") as license_csv_file:
                license_csv_file.write(license_csv.stdout)

            # We don't check this return code because it is always non-zero due to un-retrievable licenses (bb.eng.venafi.com for example)
            subprocess.run(["go-licenses", "save", "--save_path", f'{os.getcwd()}/{project_root}/licenses', "./..."],
                capture_output=True, cwd=f'{repo_source_root}/{project["root-dir"]}')

            new_project = Project(project["name"], project_root, project["md-name"])
            downloaded_projects.append(new_project)
        
    return downloaded_projects


def get_project_header_markdown(project_name, date):
    return PROJECT_HEADER_TEMPLATE.format(project_name, project_name, date)


def get_dependency_markdown(dependency_name, license_url, license_name, license_content):
    return DEPENDENCY_TEMPLATE.format(dependency_name, license_url, license_name, license_content)


def read_license(project_path, dependency_path, license_url):
    license_name = license_url.split("/")[-1]
    license_path = f'{project_path}/licenses/{dependency_path}/{license_name}'

    if not os.path.exists(license_path):
        license_path = f'{project_path}/licenses/{dependency_path}/LICENSE'

    with open(license_path) as license:
         return license.read()

def create_markdown_header(md_config):
    sb = []
    
    date_today = date.today().strftime("%m/%d/%Y")
    sb.append(get_project_header_markdown(md_config["project-title"], date_today))

    return "".join(sb)

def create_markdown_content(project):
    sb = []
    
    with open(f'{project.path}/{LICENSE_CSV}') as license_file:
        reader = csv.reader(license_file)

        for row in reader:
            try:
                full_dependency_name = row[0]
                license_url = row[1]
                license_name = row[2]

                if license_url == "Unknown" or license_name == "Unknown":
                    # We couldn't get information about this dependency so we won't be able to report it.
                    continue

                license_content = read_license(project.path, full_dependency_name, license_url)

                sb.append(get_dependency_markdown(full_dependency_name, license_url, license_name, license_content))
            except Exception as ex:
                print("Failed to build dependency markdown, error:", ex)

    return "".join(sb)


def main():

    parser = argparse.ArgumentParser(description='Generate markdown files containing third party dependency information for golang VSat Dependencies')
    parser.add_argument('--bb-api-key', type=str, default=os.getenv('BB_API_KEY'),
                        help="API key for authentication with bb.eng.venafi.com. Or use environment variable 'BB_API_KEY'")
    parser.add_argument('--config', type=str, help="Configuration file path", default="license_collector_config.yaml")

    args = parser.parse_args()

    if args.bb_api_key == None:
        print("arg \"--bb-api-key <API-KEY>\" must be provided")
        exit(1)

    config = read_config(args.config)
    projects = download_license_data(config, args.bb_api_key)

    print("\n-- Markdown Generation ---")

    md_configs = {}
    for entry in  config["md-files"]:
        md_configs[entry["name"]] = entry


    md_contents = {}

    for project in projects:
        print("Generating markdown file for project:", project.name)

        if project.md_name not in md_configs:
            raise Exception(f'Missing md configuration related to project {project.md_name}')

        md_config = md_configs[project.md_name]
        
        # Add the header first if it has not already been added
        if md_config["file-name"] not in md_contents:
            md_contents[md_config["file-name"]] = create_markdown_header(md_config)

        md_contents[md_config["file-name"]] += (create_markdown_content(project))

    for key, value in md_contents.items():
        with open(key, "w") as md_file:
            md_file.write(value)    
        

if __name__ == "__main__":
    main()