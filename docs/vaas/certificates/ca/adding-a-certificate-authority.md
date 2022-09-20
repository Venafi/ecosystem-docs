# Adding a certificate authority

When you add a certificate authority (CA) to {{vs}}, you create a connection
between {{vs}} and that CA. That connection enables {{vs}} to manage certificate life-cycles.

{{vs}} can connect to both external and internal CAs, in addition to its own built-in CA.

You'll just need your CA authentication credentials before you can configure and test issuance. Each CA provider has its own authentication methodology.

!!! important "Important"
    You must be a {{rolesSA}} or {{rolesPKI}} to add a new CA.

## Getting started

Select your CA below for a detailed how-to.

<div class="mini-card-container" markdown="1">
## Venafi as a Service Built-in CA

[Built-in CA](working-with-built-in-ca-account.md){.mini-card .mini-card-2 #logo-venafi}

## External certificate authorities

[DigiCert](adding-digicert-ca.md){.mini-card .mini-card-2 #logo-digicert}
[Entrust](adding-entrust-ca.md){.mini-card .mini-card-2 #logo-entrust}
[GlobalSign Atlas](adding-globalsign-ca.md){.mini-card .mini-card-2 #logo-globalsign}
[GlobalSign MSSL](adding-globalsign-mssl-ca.md){.mini-card .mini-card-2 #logo-globalsign}
[Let's Encrypt (ACMEv2)](adding-letsencrypt-ca.md){.mini-card .mini-card-2 #logo-letsencrypt}

## Internal certificate authorities

[Venafi Zero Touch PKI](adding-ztpki-ca.md){.mini-card .mini-card-2 #logo-venafi}
[Microsoft AD CS](adcs-introduction.md){.mini-card .mini-card-2 #logo-microsoft}

## Custom CA

[ACMEv2](adding-acme-ca.md){.mini-card .mini-card-2 #logo-acme}

</div>

    
