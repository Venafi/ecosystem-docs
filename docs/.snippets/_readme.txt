To use a snippet in a topic, create the snippet in this folder
as a .md file. Then, in the topics where you want to include the
snippet, you can reference it with the following:

{% include 'snippet-name.md' %}

To include a snippet in a subfolder, use

{% include 'folder-name/snippet-name.md' %}

---------------------------------

The docs/_snippets folder is defined as an included directory in the
mkdocs.yml file with the following:

plugins:
  - macros:                   # https://mkdocs-macros-plugin.readthedocs.io/en/latest/
      include_dir: docs/_snippets