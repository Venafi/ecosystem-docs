# Configuring PingOne integration with Venafi as a Service

{{vs}} can be integrated with PingOne to enable SSO for user identities managed
by PingOne (and any on-prem Active Directory forests that are synchronized with
PingOne using AD Connect) by registering {{vs}} as an Application in your
PingOne account. 

To set up this integration, you will need to first create a new Application
within PingOne for {{vs}}, optionally configure PingOne to include user group
information in OIDC tokens, then configure {{vs}} with the URLs and client
ID/secret needed to interface with PingOne.

!!! tip "Tip"  
    Because you'll be making changes to both PingOne and {{vs}}, open both applications side-by-side to help you complete the configuration more quickly.

## To configure PingOne integration with {{vs}}

1. Sign in to both {{vs}} and to your PingOne account.

1. In PingOne, go to **Applications > My Applications**, and then click **Add
   Application**.

1. Select WEB APP as the application type, and then click Next.

1. Type a name for the application, and then click Next.

    !!! best practice "Best Practice"  
        We recommend that you use {{vs}} as the application name, description and category. If you want, you can also upload an image file for the application.

1. Under **Authorization Settings**, do the following:

    1. Leave **Grants** configured with the default *authorization code*.

    1. Under **Credentials**, click **Add Secret**.

    1. Copy the generated Client ID and Client Secret, and then in {{vs}}, click
       **Settings > VaaS Platform > Single Sign On**, and paste the Client ID
       and Client Secret into the associated fields.

1. In PingOne, click **Next** to go to the **SSO Flow and Authentication**
   settings page.

1. In {{vs}}, from the **Single Sign On** configuration page, do the following: 
    
    1. Click ![icon of two pieces of stacked paper](img/CopyRedirectURLButton.jpg) to copy the **SSO Login URL** and paste it into PingOne's **Start SSO URL** field. 
    1. Click ![icon of two pieces of stacked paper](img/CopyRedirectURLButton.jpg) to copy the **Redirect URL** and paste it into PingOne's **Redirect URIs** field.

    ![screenshot](img/ss-SSO-LoginURL-RedirectURL-copying.png)

1. In PingOne, click **Next**.

1. In the **Connect Scopes** field, add the *OpenID Profile, OpenID Email*, and
   *OpenID Connect* scopes from the **List of scopes** to the **Connected
   scopes**.

    !!! important "Important"  
        At a minimum, {{vs}} needs the profile, email and open ID scopes to be connected in order for SSO logins to function.

1. In the **Attribute Mapping** field, select a value for the *sub* mapping (as
   required by PingOne), and then click **Next**.

    !!! best practice "Best Practice"  
        We recommend that you use the mail attribute.

1. In the **Group Access** section, select user groups in PingOne that should be
   allowed to access the {{vs}} service, and then click **Done**.

1. Test your SSO configuration by clicking **Test Connection**.

    If your configuration was completed correctly, you should see the ID token returned in the response.

1. Click **Save**.

    Your users can now sign in to {{vs}} using SSO through PingOne.

## What's Next

Consider configuring PingOne to include a groups claim, which allows group
membership information to be sent to {{vs}}. While group membership information
is not currently used by {{vs}}, future releases will add more functionality
that will depend upon group claims in useful ways.

All you need to do is update the {{vs}} application you just created in PingOne
by adding a new scope and corresponding claim.

### To configure PingOne to include a groups claim

1. Sign in to your PingOne console and click **Applications > OAuth settings**.

1. Click the **Scopes** tab, click **Add Scope**, and then add a scope Value and
   Name.

    The scope value is the value that will be included in OAuth requests sent by {{vs}} to PingOne. The name you use for the scope is displayed in the PingOne admin console.

    !!! best practice "Best Practice"  
        Consider using a simple naming scheme. For example, you could use groups for the scope and Enterprise user groups for the name.

1. In the **Enter Claim** field, type a name for the claim to be returned in the
   response that is sent back to {{vs}}, and then click **Save**.

    Consider using the same name for the claim as the scope that was provided above (so for example, the name would be groups.

1. Click the **Attribute Mapping** tab, locate the claim that was created in the
   previous step, and then in the **Mapping** column, choose the user attribute
   for the user's PingOne account that contains group information, and then
   click **Save**.

    !!! tip "Tip"  
        In almost all cases this will be the memberOf attribute. You can either select this value, or to display only the group name, you can use the Advanced function and use the GetFirstRelativeDN function to extract only the group name from the memberOf attribute.

1. Go to **My Applications > OIDC**, find the application you created previously
   for {{vs}}, and then click the **Edit** icon.

1. Click **Scopes**, locate and select the scope that you created in the List of
   Scopes and add it to Connected Scopes, and then click Save.

1. Sign in to {{vs}}, and then do the following:

    1. Click **Settings > VaaS Platform > Single Sign On**.

    1. In the **Scopes** field at the bottom of the page, type the scope name you created in PingOne (e.g. *groups*).

        This configures {{vs}} to request that scope from PingOne for all user authentication requests.

    1. Click **Test Connection** and when prompted, type your enterprise credentials into PingOne.

        If the configuration was successful, the claims for your account are displayed.

    1. Verify that there is a new claim that contains your user groups displayed, and then click **Save**.
