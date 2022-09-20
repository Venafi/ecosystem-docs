# Configuring Microsoft AD FS integration with Venafi as a Service

If AD FS is your SSO solution, this topic shows you how to integrate AD FS with {{vs}}.

You can integrate {{vs}} with AD FS to enable single sign-on (SSO) for user identities with which AD FS can proxy.

!!! tip "TIP"
    Because you'll be making changes in both Microsoft AD FS Management console and {{vs}}, you'll complete the configuration faster if you open both applications side-by-side before proceeding.

To set up this integration, you'll need to

1. Configure Microsoft AD FS and {{vs}} to work together
1. Test the connection between {{vs}} and AD FS

??? optional-css-class "Step 1: Configuring AD FS and {{vs}}"

    1. In AD FS Management, right-click **Application Groups** and click **Add Application Group**.
    1. In the Application Group Wizard, type a name, such as *Venafi*, 
    1. Under **Client-Server applications**, select the **Server application accessing a web API** template, and then click **Next**.
    1. Log in to {{vs}} and click **Settings** > **Platform**.
    1. From the Single Sign On tab, click ![copy button](img/CopyRedirectURLButton.jpg) next to **Redirect URL** to copy the URL, and then back in the AD FS wizard, paste it into the **Redirect URI** field, and then click **Add**. 
    1. Click **Next** and on the Configure Application Credentials page of the wizard, select **Generate a shared secret**, click **Copy to clipboard**.
    1. In {{vs}}, paste it into **Client Secret**, and then click **Save**. 
        This is an application password that is used by {{vs}} to authenticate to your SSO solution.
        !!! note "IMPORTANT! "
               Make sure you remember to click Save in {{vs}} after pasting in the client secret. If you forget, the connection will fail.    
    1. Back in AD FS Management, click **Next**.
    1. On the Configure Web API screen, copy the Client Identifier from where you saved it during an earlier step (or, copy it again from the first step of the wizard [Server Application screen]),  paste it into **Identifier**, and then click **Add**.
    1. Click **Next**.
    1. On the Apply Access Control Policy screen, select your required policy and click **Next**.
    1. On the Configure Application Permissions screen, make sure **openid** is selected and click **Next**.
    1. On the Summary screen, click **Next**, and then on the Complete screen, click **Close**.
    
    Next, you'll need to edit the application group to add a rule. 

    1. In AD FS Management, open your new application group to edit it.
    1. Under Applications, open the properties page of your new Web API, and then click the **Issuance Transform Rules** tab.
    1. Click **Add Rule**.
    1. From the Claim Rule Template list, select **Send LDAP Attributes as Claims**, and then click **Next**.
    1. On the Configure Claim Rule screen, type a name for your rule, and then select **Active Directory** from the Attribute Store list.
    1. Now map LDAP attributes to outgoing claim types:
        - E-Mail Addresses to E-Mail Address
        - Surname to Surname
        - Given-Name to Given Name
    1. Click **Finish**, then click **Apply**, and close the Application Group properties. 

??? optional-css-class "Step 2: Testing the connection between {{vs}} and AD FS"

    1. Log in to {{vs}}. 
    1. From the **{{vs}} SSO Configuration** page, click **Test connection**.
    1. When prompted by AD FS, type your enterprise credentials.
    
        When the authentication succeeds, you're redirected back to the {{vs}} SSO Configuration page. From there, you can view the claims that were returned in the OIDC token issued by AD FS.

    1. Save your SSO configuration.
