---
article: an
caname: Custom ACMEv2 
---

# Adding a custom ACMEv2 certificate authority

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete the CA configuration.

**ACMEv2 server URL**

During configuration, you'll need to provide the URL to your CA's ACMEv2 server.

{% include 'ca/dns-provider-details.md' %}

{% include 'ca/vsat-prereq.md' %}

</div>

!!! note
    Some CAs might require additional setup in order to enable ACMEv2. See see your
    CAs documentation.
  
## To set up the CA

### Step 1: Set up the connection

1. {% include 'ca/settings-ca.md' %}
1. Click **New** > **Can't find your CA? Add it!**.
1. Enter a **Name** that this CA should be called in {{vs}}.
2. (Optional) Select a **Logo** file to upload. If you don't upload a logo, the
   Venafi logo will be used.
3. In the **Server URL** field, enter the URL to the ACMEv2 server provided
   by your CA.
4. Select a **VSatellite**. If you don't yet have a VSatellite deployed, click
   **Deploy a VSatellite**, and [follow the steps to deploy a new
   VSatellite](t-VSatellite-deployNew.md).
5. Click **Test Connection**. 
6. After the connection is successful, click **Next**.

### Step 2: Enter additional information

1. Enter the **Email** address of the person or group of contact for
   certificates issued by this CA.
1. Review and agree to the Terms and Conditions
1. Click **Next**.

### Step 3: Enter DNS provider details

1. From the **DNS Provider** dropdown, select a DNS provider. 

1. Complete the fields for your DNS provider.

1. Click **Test Connection**, and then click **Done**.

   After completing the configuration, you are taken back to the **Certificate Authorities** page.

## What's Next

{% include 'ca/ca-whats-next.md' %}