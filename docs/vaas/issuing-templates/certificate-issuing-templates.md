# Overview: certificate issuing templates

*Certificate issuing templates* are used to configure security policies that are enforced whenever new certificates are issued.

An issuing template combines the selection of a CA account with rules that enforce certificate policies, all in a single location. And when you create your issuing template, you define the rules that reflect your company's certificate security policies for requesting or renewing certificates.

!!! note "NOTE"
  Issuing templates can be created or modified only by a {{rolesSA}} or {{rolesPKI}}.

Here are some of the benefits of certificate issuing templates:

- Facilitates self-service by letting other machine owners more easily request certificates without having to depend on a PKI team, or even understand crypto. Because the template includes your organization's security policies, they can simply use the template with your pre-defined settings already in place.

- Issuing templates also help to speed up certificate issuance by delivering only *required* information; everything else is set up by default, or controlled by policy.

You can create as many issuing templates as you need, and then edit or delete them at any time.

Most certificate issuing templates contain at least these basic settings:

- Template Name
- CA Account
- Issuing Rules
- Additional fields that are linked to a specific CA account
  
Depending on the CA, some might include additional settings. For example, an issuing template for DigiCert includes an additional field called *Product Option*.

## What's next

- Learn how to [set up a new certificate issuing template](/vaas/issuing-templates/certificate-issuing-templates.md)

<!-- Setting up an issuing template is simple. From the Settings > Issuing Templates page, you provide settings for the certificate attributes you want to enforce. Only a few fields are required because our default settings allow for any value to be specified. 

Remember - if a setting is enforced, Venafi as a Service will reject certificate requests that don't comply with these settings.

TIP: Use the Recommended Settings option to specify default settings, which are recommended but not enforced, to help your certificate requestors if they are unsure of what values to enter. -->