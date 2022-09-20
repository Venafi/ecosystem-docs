**DNS provider details**

The {{caname}} CA in {{vs}} uses DNS Certificate Authority Authorization (CAA).
{{vs}} supports the following DNS providers. Click your DNS provider of choice
to see what information {{vs}} needs.

=== "AWS Route 53"
    The account you use must have read, create, update, delete, and save permission.

    - Access Key ID
    - Secret Access Key
    - Hosted Zone ID
        
=== "Azure"
    The account you use must have read, create, update, delete, and save permission.

    - Subscription ID
    - Resource Group
    - Client Secret
    - Client ID
    - Tenant ID

=== "Cloudflare"
    - For email and global API Key authentication type
        - Account email
        - Global API Key
    - For DNS and zone tokens authentication type
        - Edit zone API token
        - Read zone API token

=== "Google Cloud"
    The account you use must have read, create, update, delete, and save permission.

    - Service account JSON file