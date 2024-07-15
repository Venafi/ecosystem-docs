# Managing Your Repo

Venafi provides access to our managed GitLab instance to streamline code and script submissions for ecosystem solutions. GitLab provides better visibility and version control and more consistent documentation.

<!-- ## Automations

A number of default automations are enabled by default to enhance the user experience for both you as a developer, as well as end users of the solution.
Please feel free to adapt to fit your needs.

### Default GitLab Pipeline

| Name | Description | Run Stage |
| --- | --- | --- |
| prepare_description.yml | Reads a `version.txt` file in the root of the repo and stores it as `$version` in `description.env` for future use in the pipeline | **prepare** |
| build_pdf.yml | Generates a PDF file from the README.md | **build** |
| release.yml | Creates a release using the `$version` from the `prepare` stage and publishes the PDF version of the README | **release** | -->

## Documentation

All repositories should include a README file with any information needed to configure the integration.
An example repository with sample documentation is available [here](https://coolsolutions.venafi.com/ecosystem/ecosystem-internal/example-integration-repo){: target="_blank" }.
Feel free to copy and use as a starting point.

{% include '.admonitions/account-required-admonition.md' %}

!!! warning "Docs Required"

    All new projects and merge requests will be required to have accompanying documentation.

## Merge Requests

The main branch is protected in all Ecosystem repositories.
All changes must be committed to a separate branch and a merge request must be opened.
Venafi teams will automatically be notified and will begin code review.
We try to respond as quickly as possible.

### Code Review

Venafi teams will review the committed code and merge to the main branch after passing review.
