# What is Automated Secure Keypair?

{{ask}} makes your certificate requests fast, secure, and easy by:

- By generating the key pair for new certificate requests
- By creating valid certificate signing requests (CSR)

Using {{ask}}, you no longer have to generate your own key pairs or wonder
whether your CSR is valid. {{ask}} takes care of all of that for you.

## How {{ask}} is enabled

The {{ask}} service is included in {{vs}} premium packages by default. The
service automatically activates once a {{vsat}} is deployed and registered with
{{vs}}. Once active, it can be selected as a key generation option on
certificate issuing templates.

??? question "How can I see if {{ask}} is active?"
    Click **Settings** > **Services**. The **Services** page lists all of the services available to you, and it shows whether they are active.

    By default, the service that runs {{ask}} is called **Key generation service**. It's possible that this has been renamed in your environment. If you don't see it, look for {{ask}} in the service subtext. 

    ![Screenshot showing the Key generation service](automated-secure-keypair-service.png)

## What happens when a certificate request is submitted using {{ask}}

When a certificate request is submitted using the {{ask}} service, the
following sequence of events takes place:

1. {{vs}} receives the request and forwards it to the active {{vsat}} in your
   environment.
2. The {{vsat}} generates a key pair and a CSR.
3. The private key is encrypted with the {{vsat}}'s [Data Encryption Key](what-is-the-data-encryption-key-dek.md), and the
   encrypted private key and CSR are sent to {{vs}}.

    !!! important
            The Data Encryption Key itself is never sent to {{vs}}. Venafi cannot
            decrypt private keys that are stored in {{vs}}.

4. {{vs}} forwards the CSR to the CA specified in the issuing template. 
5. {{vs}} receives the CA-issued certificate and stores it.

Once the certificate is returned to {{vs}}, you can download the certificate
or the Keystore.

## Ready to get started?

Go to [Using {{ask}} to request
certificates](using-automated-secure-keypair-to-request-certificates.md). It
will walk you through all of the steps necessary to start using {{ask}}.
