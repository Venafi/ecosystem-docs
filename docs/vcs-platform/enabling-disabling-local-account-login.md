---
uid: enabling-disabling-user-login
---

# Enabling or disabling a user's local account login

{{vs}} administrators can selectively control which users are allowed to use 
local accounts for logging in. If you're a {{vs}} administrator, you can 
enable or disable local user account login functionality for any user.

!!! Tip
    The primary purpose for allowing local accounts is for situations when your SSO goes offline—either intentionally or due to an outage of your SSO service—and an alternate authentication method is required.
    As a matter of tightening security, using a local account to sign in to {{vs}} should be reserved for use by authorized administrators only in cases where SSO isn't available.

## To enable or disable local account login

1. Sign in to {{vs}}.

1. Click **Settings** > **User Management,** and then click **Users**.

1. On the User Management page, find and click the user name you want to edit.

1. Select or clear **Enable local login**, and then click **Save**.

!!! tip "Did you know?"     
    To complete the process, owners of accounts where you've enabled local account logins
    will need to set up their local login account passwords. Once set, then the next 
    time they sign in to {{vs}}, they'll have the option of signing in using 
    either SSO or by entering their local user account credentials. See Setting 
    my local {{vs}} account password .
