# Running a validation manually

You can run a quick validation on any installed certificates using the Validate Now feature.

!!! tip "TIP"
    In addition to the normal validation criteria, Validate Now can also be used to [sniff out any additional installations of certificates](t-validating-certs-using-ValidateNow-to-discover-installations.md) in your inventory.

## To run a validation manually

1. Sign in to {{ vs }}.

1. In the toolbar, click **Inventory** > **Certificate Installations**.

1. On the **Certificates Installations** page, do one of the following:

    - To search for a specific certificate, enter the certificate details in the search bar at the top.
    - If you had created and saved a filter for your certificates, click the **Filters** list and select your saved filter.
    - To manually filter the list, click **Filter** next to the search bar to enter the attributes you want to include in the filter, and then click **Apply**.

1. In the **Certificate Name** column, find and click the name of the certificate you want to validate.

1. In the Certificate Details view, click the **INSTALLATIONS** tab.

1. Click **Validate Now**.
    
    A *Validation in progress* message appears at the top of the page. If the validation is successful, the TLS Validation and Chain Validation columns display *Success*. Otherwise, a *Validation Failed* message appears.
    
    !!! tip "TIP"
        You can also verify when the last validation of your installed certificates ocurred by looking at the **Last Seen** column. Shortly after running Validate Now, Last Seen should update to *a minute ago* from it's previous state. Refresh the page manually if you don't see a change to the status.

## What's next?

- Learn more about [certificate validation concepts](c-validating-certificates.md).
- Learn more about [using Validate Now to find additional certificate installations](t-validating-certs-using-ValidateNow-to-discover-installations.md).
- Learn more about [finding certificates in your inventory](finding-certificates.md).
- Learn more about [downloading certificates](requesting-downloading-installing-certificates.md).