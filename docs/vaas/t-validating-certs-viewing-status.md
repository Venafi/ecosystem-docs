# Viewing certificate validation status

The certificate installation page in {{ vs }} shows the validation status for each certificate.

1. Sign in to {{ vs }}.

1. In the toolbar, click **Inventory** > **Certificate Installations**.
    
    The certificate installations table has a **TLS Validation** column and a **Chain Validation** column that shows the validation status for each certificate.
    - To search for a specific certificate, enter the certificate details in the search bar at the top.

    - To filter the list table, click Filter next to the search bar. In the TLS Validation and Chain Validation boxes, select the states that you want to include in the filter, the click Apply.

!!! note "Machine Identity Digest email"
    Enabling the [Machine Identity Digest](./set-up-email-notifications.md) email will send you a periodic email where you can view if validation has failed on any certificates. This is a quick and easy way to see if anything needs your attention. If so, then you can sign in to {{ vs }} to further troubleshoot and take corrective action.

## What's next?

- Learn more about [certificate validation concepts](c-validating-certificates.md).
- Learn more about [using Validate Now to find additional certificate installations](t-validating-certs-using-ValidateNow-to-discover-installations.md).
- Learn more about [finding certificates in your inventory](finding-certificates.md).
- Learn more about [downloading certificates](requesting-downloading-installing-certificates.md).