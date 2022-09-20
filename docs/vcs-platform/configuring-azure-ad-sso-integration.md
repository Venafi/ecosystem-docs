# Configuring Azure AD SSO integration with Venafi as a Service

If Azure AD is your SSO solution, this topic shows you how to integrate Azure with {{vs}}.

{{vs}} can be integrated with Azure AD to enable SSO for users who are managed by Azure AD (and any on-prem active directory forests that are synchronized with Azure AD). You do this by registering {{vs}} as an enterprise application in your AzureAD tenant.

To set up this integration, you'll first create an App registration for {{vs}} within Azure AD.

!!! tip "TIP"
    As an option, you can also configure Azure AD to include user group information in OIDC tokens, and then configure {{vs}} with the URLs and client ID/secret needed to interface with Azure AD.

    Azure AD does not support requesting custom scopes to alter the claims returned in OIDC tokens. So, when using Azure AD, be sure to leave the Scopes field on {{vs}}'s SSO configuration page blank.

!!! tip
    Because you'll be making changes in both the Azure AD portal and {{vs}}, you'll complete the configuration faster if you open both user interfaces side-by-side before proceeding.

To set up this integration, you'll need to

1. Configure Azure AD and {{vs}} to work together
1. Test the connection between {{vs}} and Azure AD
1. (Optional) Add a Groups claim

??? optional-css-class "Step 1: Configuring Azure AD to work with {{vs}}"

    1. Log in to your Azure account as a directory administrator or other user with permissions to create application registrations in your Azure AD tenant.

    1. Go to **App registrations** and click **New registration**.

    1. Type a name for the application (e.g. {{vs}}), and then configure supported account types.

    1. In **{{vs}}**, copy the **Redirect URL** from  the SSO configuration page ({{vs}} > Settings > {{vs}} Platform > Single Sign On > Configuration) and paste it into the **Redirect URI** in Azure.
    
        After the registration is complete, you're directed to the App registration page for the {{vs}} application you just created. 

        The next step then is to create a client secret for {{vs}} to use to authenticate with Azure AD.  

    1. In **Azure**, go to **Certificates & secrets**, click **New client secret**, and then give your secret a description and specify its lifetime.
    
        !!! tip "TIP" 
            Be sure to give the secret a useful description, such as, *Secret used by the {{vs}} application*, which makes it easier to identify later on. 

            Also, if you decide to use expiring client secrets, be sure to renew them and update {{vs}} with the new secrets as soon as possible.

    1. After creating the secret, copy the new secret's _value_ (not the Secret ID), and then in **{{vs}}**, paste it into the **Client Secret** field on the SSO Configuration page.

        ![Screenshot of the _Certificates and secrets_ page in Azure](img/ss-SSO-Azure-clientSecrets.png)
    
        !!! tip "TIP"
            After you leave the App registration blade, the client secret's value won't be visible again. Copy value of the secret ID to a secure password vault if you want to be able to retrieve it later on.

    1. In **Azure**, go to the **Overview** section in the App registration blade.

    1. Copy the **Application (client) ID** and then in **{{vs}}**, paste it into the **Client ID** field on the SSO Configuration page.

    1. In **Azure**, from the **Overview** section of the App registration blade, click **Endpoints**.
    
        This shows you the set of endpoints on which Azure AD provides OAuth/OIDC services.

    1. From the **OpenID Connect metadata document** field, select and copy *only the following portion of the URL*: *https://login.domain.com/XXXXX-XXXXX-XXXX-XXXXXXXXX/v2.0* (excluding */.well-known/openid-configuration*).

        For example, if the full URL were *https://login.microsoftonline.com/XXXXX-XXXXX-XXXX-XXXXXXXXX/v2.0/.well-known/openid-configuration*, then you select and copy *https://login.microsoftonline.com/XXXXX-XXXXX-XXXX-XXXXXXXXX/v2.0* only, and paste it into the **Issuer URL** field on {{vs}}'s SSO Configuration page.
    
    1. Back in {{vs}}, paste the URL portion you copied into the **Issuer URL** field on SSO Configuration page.

    You're now done configuring the {{vs}} application in Azure AD. The next step is to test your connection.

??? optional-css-class "Step 2: Testing the connection between {{vs}} and Azure AD"

    1. From the **{{vs}} SSO Configuration** page, click **Test connection**.

    1. When prompted, type your enterprise credentials into Azure AD.

        When the authentication succeeds, you're redirected back to the {{vs}} SSO Configuration page. From there, you can view the claims that were returned in the OIDC token issued by Azure AD.

    1. Save your SSO configuration.

    Your users can now sign in using their SSO credentials.

??? optional-css-class "Step 3: Adding a Groups claim (Optional)"

    Adding a groups claim in Azure AD allows group membership information to be sent to {{vs}}. Including group membership information in OIDC tokens allows you to leverage the Teams feature in {{vs}} to automatically add users to Teams and automatically assign a role to them based on your organization's requirements.

    1. In **Azure AD**, from the {{vs}} App registration blade, click **Token configuration**, and then click **Add groups claim**.

    1. Select the group types to include in the claim.
    
        !!! tip
            In most cases, *All groups* is the correct choice. But if you have a large number of groups in Azure AD, you might want to send only those groups that have been assigned to the application specifically. This approach lets you specify the set of groups that are relevant for {{vs}} at the App registration level so that the set of groups returned in a user's group claims are limited to just those groups that are explicitly assigned to the application.

    1. Select **ID** from the **Customize token properties by type** section, and then select one of the options to indicate the format of the group name to be returned.
    
        For simple Azure AD deployments, *sAMAccountName* is sufficient.

    1. Click **Add**.

    1. In **{{vs}}**, from the **SSO Configuration** page, under **Scopes**, click **Test Connection** to verify that you now have a new claim called *groups* that returns the user groups to which the user is assigned in Azure AD.
