# Using your DevOps toolkit with Venafi as a Service

The **API Tools** tab on Application pages show all the details you need to work
with our integration partners. From this tab, you can obtain an API key and copy
code snippets.

## Supported integrations

* [Kubernetes](cco-Kubernetes-integration-about.md)
* [Red Hat Ansible](cco-RedHat-about.md)
* [Terraform](c-DevOps-Terraform-integration-about.md)
* [Vault Venafi Monitor Engine](cco-Vault-Monitor-Engine-about.md)
* [Vault Venafi Secrets Engine](cco_Vault-integration-about.md)
* [vCert](c-vCert-integration.md)

## To view details and copy code snippets

1. In the menu bar, click **Organization** > **Applications**.

1. Click the the application you want to add an integration to.

1. Click the **API Tools** tab. 

1. Select a **Certificate Issuing Template**.

    If there aren't any certificate issuing templates assigned to this
    application, [go to the **Summary** tab to add one](assign-an-issuing-template-to-application.md).

2. Click the name of an integration partner and follow the on-screen instructions.

    ![Screenshot of API Tool tab on Applications page](applications-api-tools.png)

??? optional-css-class "What's the timing for processing CSRs?" 
    The system submits the CSR and checks for certificate issuance for 5 seconds. If the
    certificate is not issued by the CA within 5 seconds, we present an error
    notification stating that information. We will continue to try to download
    the certificate for the next 30 minutes. If after 30 minutes, an error is
    still returned by the CA, we will notify the user and stop processing.