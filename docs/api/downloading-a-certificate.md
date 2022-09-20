# Downloading a certificate

The `certificates/{id}/contents` function allows you to download a certificate.
You can control:

* The download format as a Base64 PEM encoded certificate or as a binary DER
  file. 
* Whether to download just the end-entity certificate or the complete
  certificate chain.
* The order of the certificate chain (for complete certificate chain downloads).

**To download a certificate**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Obtain a certificate ID from the initial certificate request. If necessary,
   you can use [Search](searching-for-certificates.md) results to get the certificate
   ID.

1. Use the `certificates/{id}/contents` function. For additional help, use the
   parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}. 

1. (Optional) For the chain of trust, specify a `chainOrder`: 

    | Chain Order | Description |
    | ----------- | ----------- |
    | EE_FIRST | Download the certificate with the end-entity portion of the chain first. |
    | EE_ONLY | Download only the end-entity certificate. |
    | ROOT_FIRST | Default. Download the certificate with root portion of the chain first. |

    **Example request**
    ```
    GET https://api.venafi.cloud/outagedetection/v1/certificates/df7a8100-64c3-11eb-bcda-99e9056552b51/contents?format=PEM&chainOrder=EE_ONLY
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    accept: text/plain
    ```
    **Example response**
    ```text
    -----BEGIN CERTIFICATE-----
    MIIFFjCCA/6gAwIBAgIUHZcxmPlKcB82xzPr1xeIyGlOBBgwDQYJKoZIhvcNAQEL
    BQAweDELMAkGA1UEBhMCVVMxFTATBgNVBAoTDFZlbmFmaSwgSW5jLjERMA8GA1UE
    CxMIQnVpbHQtaW4xPzA9BgNVBAMTNkRlZGljYXRlZCAtIFZlbmFmaSBDbG91ZCBC
    dWlsdC1JbiBJbnRlcm1lZGlhdGUgQ0EgLSBHMTAeFw0yMTA1MjQyMjQ0NDJaFw0y
    MTA1MzEyMjQ1MTJaMIGBMQswCQYDVQQGEwJVUzENMAsGA1UECBMEVXRhaDEXMBUG
    A1UEBxMOU2FsdCBMYWtlIENpdHkxFTATBgNVBAoTDFZlbmFmaSwgSW5jLjEWMBQG
    A1UECxMNRG9jdW1lbnRhdGlvbjEbMBkGA1UEAxMSZXhhbXBsZS52ZmlkZXYuY29t
    MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxpbjQCUzc2RSAcPMV7Sw
    +k0J9jC49KzjIkNafMTUYfMkTCXXaN61vxYPpDW5+f0LlGFQdJF6goSH6IkvsnDX
    PILF9oZ88C3AoNsC0j5bXW6uNfXAxG7j8luheXOjWviukbfNjh/HycSPrpx+GcBc
    eyx7+T2IvmXSs31XUNaVVqz7JRpyzD7FEI+pE34NxeURuC4oF+1mHJzkXZ+vjWXN
    s5LoPfGnIoAFRbw2EPX3z82PTXF3i46fCDAj2z/u6YoqTP39qKASKBrjsxQQvEaP
    hkNKMmn0zvsz/rSqg/BVPek+R/S/znDfs53TgYDvzOheT/l+7KMNACzv160FcyZd
    XQIDAQABo4IBjDCCAYgwDgYDVR0PAQH/BAQDAgOoMB0GA1UdJQQWMBQGCCsGAQUF
    BwMBBggrBgEFBQcDAjAdBgNVHQ4EFgQUGZq7RcvY57Q25qU2ta0rdFX7KmIwHwYD
    VR0jBBgwFoAUWkO976xjEKMMahQGeZI1CN94x3owgYIGCCsGAQUFBwEBBHYwdDBy
    BggrBgEFBQcwAoZmaHR0cDovL2J1aWx0aW5jYS52ZW5hZmkuY2xvdWQvdjEvYnVp
    bHRpbmNhL2NhY2hhaW4vMTE0NDc2MTEtMjhmNS0xMWViLWI4NzktODczNzNhODE4
    MzEyLUludGVybWVkaWF0ZUNBMHMGA1UdHwRsMGowaKBmoGSGYmh0dHA6Ly9idWls
    dGluY2EudmVuYWZpLmNsb3VkL3YxL2J1aWx0aW5jYS9jcmwvMTE0NDc2MTEtMjhm
    NS0xMWViLWI4NzktODczNzNhODE4MzEyLUludGVybWVkaWF0ZUNBMB0GA1UdEQQW
    MBSCEmV4YW1wbGUudmZpZGV2LmNvbTANBgkqhkiG9w0BAQsFAAOCAQEAT6RAYz6L
    1beN/sgT7z63rL78PKeG39p0TXiEFmsE7hqNqcUN+PeZx3t96a90lMhw78lBVaB3
    Cxx83itrvskMw1bodJGXpFB8URWRTqlLKl6Eto5E4sMdWZwxZliuJx8h89VtVaL+
    tzasfr1mSWNdh7/2UZycP/VoBJy6yecsc4TYouHaE+xS4Jlc64HC7ihIttTjdajV
    CHlg7fqL1G6g/3gQBkPWOkgTo6/o8lDHjmUBkqWVPoIB9qiEhp6LUSWzRxC+cOJp
    pBDI7AyqLq/RyBtOq5IiVRgcTXEzIM9iry1U5hhWwjuw5kFJY0s7TV7eUDadX5yJ
    i9nyHDZtHy44Qg==
    -----END CERTIFICATE-----
    ```
