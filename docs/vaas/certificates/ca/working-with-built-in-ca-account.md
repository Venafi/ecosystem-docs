# Working with the Built-in CA account

In addition to integrations with various public certificate authorities (CA),
{{vs}} provides a Built-in CA. The primary use case for the Built-in CA is to
rapidly issue certificates that are generally short-lived. 

This is especially useful in development or DevOps environments where internal
machines, virtual machines, and applications need to trust each other, yet the
environment must remain flexible and responsive.

The Built-in CA certificate chain can be signed either by Venafi or by an
external CA.

!!! tip "Learn more about certificate chains"    
    If the concept of _certificate chains_ is new to you, read through [this Venafi
    blog article](https://www.venafi.com/blog/how-do-certificate-chains-work) to get
    some background. It will help you with the "what" and the "why" behind the steps
    below.


## View details about the Built-in CA account

1. In the menu bar, click **Settings** > **Certificate Authorities**.
1. Click **Built-in CA** to see details.
    <div class="vaas-img" markdown=1>
    ![Screenshot of details about the Built-in CA account](Condor_built_in_CA_details.png)
    </div>

## Issue new Venafi root and intermediate certificates
{% include 'performed-by/pkiadmin.md' %}

<p class="stepIntro" markdown="1">
This option generates both a root and an intermediate certificate. The root
certificate is self-signed, and the intermediate certificate is then signed 
by the root certificate.
</p>

1. In the menu bar, click **Settings** > **Certificate Authorities**.
2. Click **Built-in CA**.
3. In the **Certificate Authorities** local menu bar, click **Change issuer** >
   **Venafi**.
4. Complete the fields for **Root certificate** based on your organization's
   requirements. Click **Next**. 

    The values you entered for the Root certificate are copied to the
    Intermediate certificate form.

5. Modify fields for **Intermediate certificate** as necessary.
6. Click **Done**.

    After a few moments, the new root and intermediate CA certificates appear on the **Built-In CA** page.

**What's Next**

Your Built-in CA is now ready to issue certificates. See [What's Next](#whatsnext) below for next steps.

## Issue a new CA-signed intermediate certificate
{% include 'performed-by/pkiadmin.md' %}

<p class="stepIntro" markdown="1">
This option creates a new Certificate Singing Request (CSR), which you'll then
submit to a CA. After the CA returns the certificate, you can upload the
certificate to {{vs}}.
</p>

### Generate CSR

1. In the menu bar, click **Settings** > **Certificate Authorities**.
1. Click **Built-in CA**.
1. In the **Certificate Authorities** local menu bar, click **Change issuer** >
   **Custom**.
1. Complete the fields based on your organization's requirements. These values
   become part of the CSR. Click **Next**. The **Sign & Upload** section of the
   wizard opens.

### Sign & Upload

The **Sign & Upload** screen contains a CSR. Copy this CSR, and submit it to
your CA. After your CA returns a certificate, you can upload it.

At this point, you have several certificate upload options: 

| Upload Option | Description |
|---|---|
| Paste Base64 encoded text | If you have the base 64 encoded text certificate, click this option and then paste the certificate in the text box.  |
| Upload file | If you have a file containing your certificate, click this option and then select the file. |
| Upload later | If you don't have either of the above available, select this option. {{vs}} saves your state, and you can upload your certificate when you have it. See [Uploading a certificate](#upload) below. |

After you make your selection, click **Done**.

#### <a name="upload"></a>Uploading a certificate

If you selected **Upload later** in the previous step and now have your
certificate, follow these steps:

1. In the menu bar, click **Settings** > **Certificate Authorities**. 
1. Click **Built-in CA**.
1. Scroll to the bottom. Your previously-saved CSR shows, followed by the
   **Paste Base64 encoded text** and **Upload file** radio buttons. Select one,
   provided the necessary data, and then click **Done**.

??? question "Why do I see only one certificate in the Built-in CA summary?"    
    The certificate that your CA provided is an intermediate certificate. It is
    chained to the signing CA's own root certificate, even though the entire chain
    isn't shown in {{vs}}.

**What's Next**

Your built-in CA is now ready to issue certificates. See [What's Next](#whatsnext) below for next steps.

#### Canceling a CSR

If you created a CSR and selected the **Upload later** option, that CSR is saved
in {{vs}}. If you no longer need the CSR, and you don't plan to upload a
certificate based on the CSR, you can delete it.

1. In the menu bar, click **Settings** > **Certificate Authorities**. 
1. Click **Built-in CA**.
1. In the local menu bar, click **Discard changes**. Confirm your selection by
   clicking **Discard** on the confirmation modal.

## <a name="download"></a>Download the certificate chain

<p class="stepIntro" markdown="1">
After the certificate chain certificates have been issued, you can download them
from {{vs}}. You can then install the chain in OS or application certificate
stores as necessary so that certificates issued by the Built-in CA are trusted.
</p>

1. In the menu bar, click **Settings** > **Certificate Authorities**. 
1. Click **Built-in CA**.
1. In the local menu bar, click **Download chain**. Select whether you want the
   intermediate or the root listed first in the chain. The chain downloads in a
   `.cer` file.

## <a name="whatsnext"></a>What's next

**Issue new certificates**

{% include 'ca/ca-whats-next.md' %}

**Download and install the certificate chain**

The Built-in CA certificate chain will need to be installed on each machine or
application that must trust the certificates issued by the Built-in CA. You'll
first need to [download the chain](#download) from {{vs}}. 

Installing the certificate chain varies by OS and application, so check your OS
or application vendor's documentation on how to install certificate chains.