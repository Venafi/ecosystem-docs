# Create an Entrust certificate authority

Entrust features a tool that helps streamline the procurement and administration
of SSL certificates. Venafi has partnered with Entrust to give you the ability
to quickly and easily request and renew certificates.

1. {% include 'ca/settings-ca.md' %}
1. Click **New** > **Entrust**.
1. Type in an **Name** for your Entrust account.
1. Upload an API SSL (client) certificate.

    !!! note "Note" 

        The client certificate must have the Client Authentication EKU. 

    ??? question "How do I create a client certificate?"

         1. Log in to the Entrust Certificate Services web console.

         2. In the top menu, navigate to **Administration > Advanced Settings**.

         3. Click **API**.
            
            ![Image of Entrust Advanced Settings
            screen](DevOps-Entrust-advanced-settings.png)

         4. Click the highlighted link to download the **REST API for ECS Enterprise User
            Guide and Method Reference**.

         5. Follow the steps in the Authentication section that includes instructions on
            how to create a public/private key pair, SSL certificate,   and an API user
            and key.

1. After you've uploaded the certificate, enter its **Passphrase**.
1. Type your Entrust **Username** and provide the associated **API Key**.
    
    To learn how to retrieve your Entrust API key, see [Entrust's Help
    document](https://managed.entrust.net/documentation/cms/WebHelp/index.htm#t=CMS_User_Guide%2FManaging_users%2FAdding_an_API_administrator.htm).

1.  Click **Validate**.
1.  After successful authentication, click **Add Account.**.

## What's Next

{% include 'ca/ca-whats-next.md' %}