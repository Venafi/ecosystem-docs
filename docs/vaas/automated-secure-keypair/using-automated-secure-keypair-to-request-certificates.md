# Using Automated Secure Keypair to request certificates

Before {{ask}} can be used to request certificates, you need to do the following:

- Install and start a {{vsat}} in your environment
- Configure a certificate issuing template that allows Venafi-generated keys
- Configure an application to use the same certificate issuing template

As long as these criteria are met, any certificate request submitted for the
application can take advantage of {{ask}}.

The steps below walk you through that setup.

## Step 1: Deploy a {{vsat}}
{% include 'performed-by/pkiadmin.md' %}

<p class="stepIntro" markdown="1">When you deploy {{vsat}} in your network, the {{ask}} service automatically
activates. All key generation activity takes place on a {{vsat}} in your environment so
that private keys remain secure.</p>

!!! question "Do you already have a {{vsat}} deployed?"
    To see if you already have a {{vsat}} deployed, sign in to {{vs}} and click **Settings** > **{{vsat}}s**. Any {{vsat}}s that you have running in your environment will be listed here. If you don't have a {{vsat}}, follow the steps in [Deploying {{vsat}}s](t-VSatellite-deployNew.md).  

    You can click a {{vsat}} to open its details. In the **Supported Services** section, verify that you see **{{ask}}** in the **Service Type** column.
    
    If the service is active, you're good to go on to Step 2 below.

To deploy a {{vsat}}, follow the steps in [Deploying {{vsat}}s](t-VSatellite-deployNew.md). 

After the {{vsat}} is up and running, you can verify that {{ask}} is active by
following the steps in the note above.

!!! tip "Multiple {{vsat}}s for {{ask}} redundancy"
    Setting up two or more {{vsat}}s provides redundancy for {{ask}}. If the primary {{vsat}} becomes
    unavailable, {{ask}} automatically fails over to a healthy {{vsat}}. 

## Step 2: Create a certificate issuing template
{% include 'performed-by/pkiadmin.md' %}

<p class="stepIntro" markdown="1">With one or more {{vsat}}s deployed, {{ask}} is now active. The next step is to 
create a Certificate Issuing Template that uses {{ask}}.</p>

When [creating the Certificate Issuing
Template](creating-a-certificate-issuing-template.md), be sure to select either
**Venafi or user generated key pair** or **Venafi generated key pair** from the
**Key Pair Generation** options. These options allow {{rolesRO}}s to submit
certificate requests that use {{ask}}.

<div class="vaas-img" markdown="1">
![Screenshot of the Key Pair Generation section of the Certificate Issuing Template screen](key-pair-generation.png)
</div>

## Step 3: Create an application
{% include 'performed-by/ro.md' %}

<p class="stepIntro" markdown="1">Now that there is a Certificate Issuing Template with {{ask}} enabled, 
those templates can be assigned to applications.</p>

You can add issuing templates to applications when [creating a new application](creating-an-application.md) or by [editing an existing application](edit-or-delete-application.md). 

To use {{ask}} for certificate requests, you'll need to choose an issuing
template that has either **Venafi or user generated key pair** or **Venafi
generated key pair** as the key generation option.

## Step 4: Create a certificate request
{% include 'performed-by/ro.md' %}

<p class="stepIntro" markdown="1">For the applications that have an {{ask}}-enabled issuing templates assigned,
you can submit certificate requests using the **Venafi generated key pair** option.</p>

Follow the steps in [creating a certificate
request](requesting-viewing-certificate.md) to create the certificate request. 

When creating the request, you will select the application and use-case for the
request. The use-case maps back to the Certificate Issuing Templates assigned to
the application.

## What's Next

You can view your request by clicking **Inventory** > **Certificate Requests**
in the menu bar. Once the certificate is issued, you can view it directly from
the certificate request. It also appears on the **Inventory** > **Certificates**
menu.