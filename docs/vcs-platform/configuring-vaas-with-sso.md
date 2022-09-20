# Configuring Venafi as a Service to work with your SSO

Configuration is simple and all done from a single screen. You just need to know a few things before you get started.

A good place to start gathering this information is with your SSO administrator.

* Have OAuth2.0 with OpenID Connect set up with your SSO identity provider (IdP). These are the protocols supported by {{vs}} Services.

* Know your SSO solution's information, which is required during configuration, so make sure you have this information handy before you begin:

  * Client ID: used by your SSO IdP to uniquely identify your {{vs}} account.

    It's a longer string and might look something like this:

    `85623942900-a2g97bisb3fqrtlink8ci5es1ik91v3r.apps.google`

  * Client Secret: an application password used by {{vs}} to authenticate to your SSO IdP

  * Issuer URL: tells {{vs}} which endpoints to use to communicate with your SSO IdP

  * (Optional) Scopes: used for requesting additional attributes (called claims) for users

        `85623942900-a2g97bisb3fqrtlink8ci5es1ik91v3r.apps.google`

* Share the Redirect URL, which is the {{vs}} URL, with your SSO administrator.

    SSO admins need that URL so they can configure the SSO IdP to redirect users' web browsers 
    back to {{vs}} after they've successfully authenticated with the IdP. During the 
    following procedure, you'll copy the redirect URL and send it to your SSO admin.

Before you continue, make sure you've gathered all of the prerequisite information described above.

## To configure SSO on {{vs}} Services

1. Sign in to **{{vs}}**.

1. Click **Settings** > **{{vs}} Platform**.
1. Click **Single Sign On**.
1. Under **Configuration**, do the following:

    1. In **Client ID**, type the client ID, which uniquely identifies your {{vs}} account to your SSO solution.

        If you don't know your client ID, ask your SSO administrator.

    1. In **Client Secret**, type the required password to your SSO.

        This is an application password used by {{vs}} to authenticate with your SSO. Your SSO administrator can give it to you if you don't know it.

    1. In **Issuer URL**, type the URL of the endpoint used to communicate with your SSO.

        Your SSO administrator can give this information to you.

    1. Under **Redirect URL**, click ![CopyURL](img/CopyRedirectURLButton.jpg) to copy the {{vs}} URL and send it to your SSO admin.

        Your SSO administrator needs the redirect URL so he or she can configure the SSO IdP to redirect users back to {{vs}} following successful authentication with the IdP.

    1. Under **SSO Login URL**, click ![CopyURL](img/CopyRedirectURLButton.jpg) to copy the SSO Login URL and send it to your SSO admin.

        Your SSO administrator needs the redirect URL so he or she can configure the SSO IdP to redirect users back to {{vs}} following successful authentication with the IdP.

    1. (Optional) In **Scopes**, if you want any additional user attributes to be requested during authentication, type them here.

        Your SSO administrator can provide the list of claims that you should provide, such as claims that provide group membership information about your users.

1. To verify that your configuration is accurate and works as expected, do the following:

    1. Click **Test Connection**.

        This option should display your SSO's sign-in page so you can verify that your settings are correct. If your SSO sign-in page doesn't appear, verify your configuration and try again.

    1. (Optional) If you specified claims, and if your test is successful, click **Show Claims** to see the list of returned claims you specified.

## What's next?

After your SSO configuration is complete, consider working with your SSO administrator to publish {{vs}} in your SSO provider's portal, such as the Okta My Applications page. This can make it much easier for users in your organization to learn about {{vs}}.
