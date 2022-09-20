# Renewing a certificate in Venafi as a Service

{{vs}} streamlines certificate renewals, allowing you to renew certificates
faster and with fewer errors. If the right conditions are met, a certificate can
be renewed with just a couple of clicks.

If {{vs}} doesn't have everything it needs, or if you want to change some of the
data on a certificate renewal request, {{vs}} helps you by pre-populating the
certificate renewal fields with data from the existing certificate. 

## To renew a certificate

1. Open the certificate inventory by clicking **Inventory** > **Certificates**.
2. [Find the certificate](using-filters-to-find-certificates.md) you want to
   renew, and click the checkbox next to it.
3. In the local menu bar, click **Renew**.

    ![Screenshot of renew button](renew-button.png)

    After clicking **Renew**, you'll see either the **Renew Certificate** modal or the 
    **Certificate Request** wizard. Click the section below based on what you see. 

??? question "What controls which renewal option is shown?"
    {{vs}} presents the **Renew Certificate** modal when the certificate meets the following criteria:

    * It was issued using [Automated Secure Keypair](what-is-automated-secure-keypair.md)
    * It is assigned to just one application
    * The certificate data still complies with the [certificate issuing template](certificate-issuing-templates.md)

    If any of these aren't met, then the **Certificate Request** wizard opens instead.

??? "If you see the **Renew Certificate** modal"
    To simply renew a certificate using the same properties, select **No, just renew it**, 
    and then click **Continue**.

    !!! info "Validity period"
        This renewal option renews the certificate using the default (maximum allowed) validity
        period for the selected use case (issuing template). 

        For instance, if the issuing template has a maximum validity period of one year,
        but you overrode that default validity period when you created the original
        certificate and chose a shorter validity period, the renewed certificate will
        use the one-year validity period set by the template. 

    If you want to make changes to the certificate, select **Yes, I want to make changes**, 
    and then click **Continue**. This opens the **Certificate Requests** wizard. 
    Click the drop-down below for more instructions.

??? "If you see the **Certificate Request** wizard"
    The information from the certificate you're renewing will be pre-populated as you walk 
    through these steps.

    1. On the **Installation Settings** screen, select where the certificate will be installed. Click **Next**.
    2. On the **Use-case selection** screen, make any changes to the **Application** or **Certificate Use-case**.

        !!! note "Note"
            The **Certificate Use-case** list shows the [certificate issuing templates](certificate-issuing-templates.md)
            that are assigned to the application from the previous step.

    3. On the **Complete request** screen, you can make any necessary changes:

        === "Venafi automated certificate request"

            Update any fields as necessary, and then click **Submit Request**. 

        === "Generate CSR"
        
            Set the validity period. Copy-and-paste the new CSR, and then click **Submit Request**.
          
## Viewing requests and new certificates

After submitting, you will be able to see your request on the certificate
request list by clicking **Inventory** > **Certificate requests**. If the
request has an **Issued** status, you can click the checkbox next to the
request, and then click **View Certificate** to see the certificate details.

If you renewed the certificate using the **No, just renew it** option, you will
be able to view the previous version of the certificate in the 
**Previous Versions** tab.

<div class="vaas-img" markdown="1">
![screenshot of the previous versions tab](previous-versions.png)
</div>

If you renewed using the wizard, you will see both your new certificate and your
old certificate in the inventory by clicking **Inventory** > **Certificates**.

## What's Next

Your new certificate can now be [downloaded](downloading-certificates-and-keystores.md) and installed.

If your old certificate is no longer needed, you can [retire it](retiring-recovering-certificate.md).