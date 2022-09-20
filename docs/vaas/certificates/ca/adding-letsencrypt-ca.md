---
article: a
caname: Let's Encrypt
---

# Adding a Let's Encrypt (ACMEv2) certificate authority

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete the CA configuration.

{% include 'ca/dns-provider-details.md' %}

{% include 'ca/vsat-prereq.md' %}

</div>

## To set up the CA

### Step 1: Set up the connection

1. {% include 'ca/settings-ca.md' %}
1. Click **New** > **Let's Encrypt (ACMEv2)**.
1. Enter a **Name** that this CA should be called in {{vs}}.
1. From the **Server URL** drop-down, select either the production or the
   staging URL.
   
    !!! note
        These URLs are provided by Let's Encrypt and can't be changed. 
        The [Custom ACMEv2](adding-acme-ca.md) CA in {{vs}} allows you to 
        enter custom server URLs if needed.

1. Select a **VSatellite**. If you don't yet have a VSatellite deployed, click
   **Deploy a VSatellite**, and [follow the steps to deploy a new
   VSatellite](t-VSatellite-deployNew.md).
1. Click **Test Connection**. 
1. After the connection is successful, click **Next**.

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