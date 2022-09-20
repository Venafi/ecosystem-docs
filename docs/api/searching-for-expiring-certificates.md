# Example: Searching for expiring certificates

You can search for certificates that require renewal because they are nearing
expiration or have recently expired. 

**To search for expiring certificates**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificatesearch` function and the appropriate JSON body (next
   step). For example:

      ```
      POST https://api.venafi.cloud/outagedetection/v1/certificatesearch
      tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
      ```

1. Determine the ISO 8601 format for the past and future dates that represent
   the start and end of your renewal window, for example 10 days ago and 60 days
   from today, respectively.

1. In the JSON body, use the GTE (greater than or equal) relational operator
   with the past date value and the LTE (less than or equal) relational operator
   with the future date value to select all certificates that either have
   expired recently or will be expiring soon. For additional help, use the
   parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}.
   For example:

    **Example JSON body**
    ```json
    {
        "expression": {
            "operator": "AND",
            "operands": [
                {
                    "field": "validityEnd",
                    "operator": "GTE",
                    "value": "2021-05-14T00:00:00"
                },
                {
                    "field": "validityEnd",
                    "operator": "LTE",
                    "value": "2021-07-23T23:59:59"
                }
            ]
        },
        "ordering": {
            "orders": [
                {
                    "direction": "ASC",
                    "field": "validityEnd"
                }
            ]
        },
        "paging": {
            "pageNumber": 0,
            "pageSize": 50
        }
    }
    ```
    **Example response**
    ```json
    HTTP 200 OK
    {
        "count": 50,
        "certificates": [
            {
                "id": "b3184db0-bce1-11eb-8ea7-472b6688a8bb",
                "companyId": "11447611-28f5-11eb-b879-87373a818312",
                "managedCertificateId": "b2fd2490-bce1-11eb-b3a1-9f54ccc85904",
                "certificateRequestId": "b30736b0-bce1-11eb-9af9-c947417e28d0",
                "certificateAuthorityAccountId": "11a0c6e0-28f5-11eb-999a-4d91b3bd6de9",
                "fingerprint": "075C43428E70BCF941039F54B8ED78DE4FACA87F",
                "issuerCertificateIds": [
                    "15840750-3434-11eb-a78e-ffa12262ebbc",
                    "15798000-3434-11eb-a78e-ffa12262ebbc"
                ],
                "certificateStatus": "ACTIVE",
                "modificationDate": "2021-05-24T22:45:12.394+0000",
                "validityStart": "2021-05-24T22:44:42.000+0000",
                "validityEnd": "2021-05-31T22:45:12.000+0000",
                "selfSigned": false,
                "signatureAlgorithm": "SHA256_WITH_RSA_ENCRYPTION",
                "signatureHashAlgorithm": "SHA256",
                "encryptionType": "RSA",
                "keyStrength": 2048,
                "subjectKeyIdentifierHash": "D51916E977DB56626F20C34DFF3D96F0BB23171D",
                "authorityKeyIdentifierHash": "68EA758729B4EFB3DC774BCC3664E78AAA53A4DD",
                "serialNumber": "1D973198F94A701F36C733EBD71788C8694E0418",
                "subjectDN": "cn=example.vfidev.com,ou=Documentation,o=Venafi, Inc.,c=US,st=Utah,l=Salt Lake City",
                "subjectCN": [
                    "example.vfidev.com"
                ],
                "subjectOU": [
                    "Documentation"
                ],
                "subjectST": "Utah",
                "subjectL": "Salt Lake City",
                "subjectC": "US",
                "subjectAlternativeNamesByType": {
                    "otherName": [],
                    "rfc822Name": [],
                    "dNSName": [
                        "example.vfidev.com"
                    ],
                    "x400Address": [],
                    "directoryName": [],
                    "ediPartyName": [],
                    "uniformResourceIdentifier": [],
                    "iPAddress": [],
                    "registeredID": []
                },
                "subjectAlternativeNameDns": [
                    "example.vfidev.com"
                ],
                "issuerDN": "cn=Dedicated - Venafi Cloud Built-In Intermediate CA - G1,ou=Built-in,o=Venafi, Inc.,c=US",
                "issuerCN": [
                    "Dedicated - Venafi Cloud Built-In Intermediate CA - G1"
                ],
                "issuerOU": [
                    "Built-in"
                ],
                "issuerC": "US",
                "keyUsage": [
                    "digitalSignature",
                    "keyEncipherment",
                    "keyAgreement"
                ],
                "extendedKeyUsage": [
                    "1.3.6.1.5.5.7.3.1",
                    "1.3.6.1.5.5.7.3.2"
                ],
                "ocspNoCheck": false,
                "versionType": "CURRENT",
                "totalInstanceCount": 1,
                "totalActiveInstanceCount": 0,
                "instances": [
                    {
                        "certificateInstanceId": "b3195f20-bce1-11eb-8ea7-472b6688a8bb",
                        "certificateId": "b3184db0-bce1-11eb-8ea7-472b6688a8bb",
                        "certificateSource": "USER_PROVIDED",
                        "ipAddress": "254.254.254.254",
                        "hostname": " ",
                        "port": -1,
                        "instanceChainValidationStatus": [],
                        "modificationDate": "2021-05-24T22:45:12.394+0000",
                        "applicationIds": [
                            "15927220-bcdf-11eb-aef6-d3dfbf271ceb"
                        ],
                        "deploymentStatus": "SUPERSEDED"
                    }
                ]
            },
            {
                "id": "a5a78090-578f-11eb-9d75-359fbd0eee70",
                //...
            },
            //...
            {
                "id": "e7085e70-578e-11eb-b60e-5776407499cc",
                //...
            }
        ]
    }
    ```