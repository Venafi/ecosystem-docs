# Importing a certificate via API

The `certificates` function imports a certificate into the {{vs}} inventory,
optionally assigning it to one or more applications (recommended).

**To import a certificate**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Remove the `-----BEGIN CERTIFICATE-----` header, `-----END CERTIFICATE-----`
   footer, and all line breaks from the certificate PEM text.

1. Use the `certificates` function to import one or more certificates. For
   additional help, use the parameter descriptions from {% include
   'sn-Cloud-api-LinktoSwagger.md' %}. For example:
    ```
    POST https://api.venafi.cloud/outagedetection/v1/certificates
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```
1. In the JSON body, insert the modified PEM text and `applicationId` values, as
   appropriate. For example:
    ```json
    {
        "certificates": [
            {
                "certificate": "MIIEKDCCAxCgAwIBAgIUG3HJ035+GV3SOlO5IcbFtmggl/YwDQYJKoZIhvcNAQEL...",
                "applicationIds": [
                    "45d06980-ae82-11eb-9702-4fa2482840bf"
                ],
                "apiClientInformation": {
                    "type": "My API Client",
                    "identifier": "10.20.30.40"
                }
            }
        ],
        "overrideBlocklist": true
    }
    ```    

    **Example response**
    ```json
    HTTP 201 Created
    {
        "certificateInformations": [
            {
                "id": "9ce02b90-bd12-11eb-9a4b-8557324bec2b",
                "managedCertificateId": "4b0928f0-bd10-11eb-bb06-01f995b63ae3",
                "companyId": "11447611-28f5-11eb-b879-87373a818312",
                "fingerprint": "E63129B8BA38D4D22FEF303E8AF1A40A33744C8B",
                "base64Certificate": "MIIEKDCCAxCgAwIBAgIUG3HJ035+GV3SOlO5IcbFtmggl/YwDQYJKoZIhvcNAQEL...",
                "issuerCertificateIds": [],
                "certificateSource": "USER_IMPORTED",
                "apiClientInformation": {
                    "type": "My API Client",
                    "identifier": "10.20.30.40"
                }
            }
        ],
        "statistics": {
            "ignored": 0,
            "imported": 1,
            "failed": 0,
            "existed": 0
        }
    }
    ```
