# Discovering certificate installations

In addition to validating certificates, the [Validate Now](t-validating-certs-manually-using-ValidateNow.md) feature can also sniff out any additional installations of certificates in your inventory. It does this by extracting the common name and DNS SANs automatically from your selected certificates and then discovers any additional installations of those certificates.

For the discovery process, Validate Now relies on your existing {{vsat}}s for internal discovery and on Scanafi for external discovery.

It's all automated for you. Simply select one or more certificates and then run Validate Now.

## Using Validate Now to discover certificate installations

1. Sign in to {{ vs }}.

1. In the toolbar, click **Inventory** > **Certificates**.

1. On the **Certificates** page, switch to the Certificate Details view.

1. Find one or more certificates by doing one of the following:

    - To search for a specific certificate, enter the certificate details in the search bar at the top.
    - If you had created and saved a filter for your certificates, click the **Filters** list and select your saved filter.
    - To manually filter the list, click **Filter** next to the search bar to enter the attributes you want to include in the filter, and then click **Apply**.

1. Select one or more certificates, and then click **Validate Now**.

1. Following validation, click the **INSTALLATIONS** tab for each certificate to view all discovered installations. 

    !!! tip ""TIP"
        Note that the Scan Type column displays *Validation*, which indicates that installations were discovered using validation rather than a specific discovery service.

## What's next?

- Learn more about [certificate validation concepts](c-validating-certificates.md).
- Learn more about [finding certificates in your inventory](finding-certificates.md).
- Learn more about [downloading certificates](requesting-downloading-installing-certificates.md).