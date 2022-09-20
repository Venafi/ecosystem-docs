---
uid: configuring-okta
---

# Configuring Okta integration with Venafi as a Service

If Okta is your SSO solution, this topic shows you how to configure Okta to integrate with {{vs}}.

!!! tip
    Because you'll be making changes in both the Okta Admin portal and {{vs}}, you'll complete the configuration faster if you open both user interfaces side-by-side.

You'll perform three basic tasks:

1. Configuring Okta and {{vs}} to work together
1. Testing the connection between {{vs}} and Okta
1. Adding a Groups claim (Optional)

??? optional-css-class "Configuring Okta and {{vs}} to work together"

    1. Open the Okta Admin portal and create a new application. Select **Web** as the platform and choose OpenID Connect as the sign-on method.

    2. In **General Settings**, type *{{vs}}* as the application name.

    3. (Optional) Upload this logo file if you plan on making the application visible to users on the Okta portal page: 

    ![{{vs}} logo](/assets/images/Venafi_LOGO_VAAS_Black_f.png)

    1. Under **Configure OpenID Connect**, fill in the **Login redirect URIs** field with the log in URL from the {{vs}} SSO configuration page.
    1. Save the new application.
    1. (Optional) If you want to publish the {{vs}} application on the Okta portal, do the following:
    * Set **Login initiated by** to **Either Okta or App**.
    * Under **Application visibility**, select **Display application icon to users**.
    * Leave **Login flow** as **OIDC Compliant**. 
    * Set **Initiate login URI** to the **SSO Login URL**.
    
    1. In **Client Credentials**, copy the **Client ID** and **Client Secret** values and paste them into the **{{vs}} SSO Configuration** page.
    1. Click the **Sign On** tab of the {{vs}} application.
    1. Under **OpenID Connect ID Token**, copy the **Issuer** value and paste it into the **Issuer** field of the **{{vs}} SSO Configuration** page.

    You are now done configuring the {{vs}} application in Okta.

    The next step is to test your connection.


??? optional-css-class "Testing the connection between {{vs}} and Okta"
    
    1. From the **{{vs}} SSO Configuration** page, click **Test connection**.

    1. Type your enterprise credentials into Okta.

        When the authentication succeeds, you're redirected back to the {{vs}} SSO Configuration page. From there, you can view the claims that were returned in the OIDC token issued by Okta.
    1. Save your SSO configuration.

    Your users can now sign in using their SSO credentials.


??? optional-css-class "Adding a Groups claim (Optional)"
   

    Adding a Groups claim in Okta allows group membership information to be sent to {{vs}}. While {{vs}} doesn't yet utilize group membership information, upcoming releases of {{vs}} include new features and functionality that will improve the way you define and manage users and groups. Of course, it's up to you!

    ## To configure a Groups claim for sending group information to {{vs}}

    1. In the Okta Admin portal, click the **Sign On** tab for the {{vs}} application you created earlier.

    2. Configure **Groups claim type** with either **Filter** or **Expression**, depending on how you have your user groups configured in Okta.

        !!! tip  
        It's a good idea to consult your Okta documentation and configure the Groups claim to return all groups to which a user is a member (both locally in Okta, as well as any Active Directory mastered groups, when applicable). Refer to this Okta KB article.
    
    3. In {{vs}}, from the **{{vs}} SSO Configuration** page, under **Scopes**, add the *groups* scope so that {{vs}} will request the Groups claim.

