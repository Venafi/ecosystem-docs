# Renewing a certificate via API

The `certificaterequests` function renews and archives the old certificates.
This API call requires:

* An existing Certificate ID. If VaaS is aware of a certificate via discovery or
  enrollment, the certificate is considered 'managed'.

* A Certificate Issuing Template ID that provides policy information for the
  certificate renewal.

* A Certificate Signing Request (CSR). 

**To renew a certificate**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. To find the certificates that require renewal, use the `certificatesearch`
   API call. For additional help, use the parameter descriptions from {% include
   'sn-Cloud-api-LinktoSwagger.md' %}. For example, `certificatesearch` can list
   expiring certificates by `validityEnd`. 
```json
    POST https://api.venafi.cloud/outagedetection/v1/certificatesearch
        tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX

       {
    "expression": {
        "operands": [
            {
                "operands": [
                    {
                        "field": "validityEnd",
                        "operator": "EQ",
                        "value": "2021-05-14T15:46:40.000+0000"
                    }
                ]
            }
        ]
    },
    "ordering": {
        "orders": [
            {
                "direction": "DESC",
                "field": "certificatInstanceModificationDate"
            }
        ]
    },
    "paging": {
        "pageNumber": 0,
        "pageSize": 10
    }
}
```
    
1. From the JSON response, use the certificates ID and application ID to
   retrieve the applications that the certificate is associated with: 
```json
   {
    "count": 1,
    "certificates": [
        {
            "id": "6a4ef6e0-af4b-11eb-bddc-0512c6191a85",
            "companyId": "b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
            "managedCertificateId": "6a3d1c90-af4b-11eb-8424-7bd3c52cc7db",
            "certificateRequestId": "6a4559f0-af4b-11eb-a502-139659b036ff",
            "certificateAuthorityAccountId": "06d705c0-ae81-11e9-bdc4-e3fc25835e95",
            "fingerprint": "783AB1BADC835D542D397943E35B6B34759DF28D",
            "issuerCertificateIds": [
                "07478770-148b-11eb-919f-9f568471c947",
                "0743b6e0-148b-11eb-919f-9f568471c947"
            ],
            "certificateStatus": "ACTIVE",
            "modificationDate": "2021-05-07T15:46:40.697+0000",
            "validityStart": "2021-05-07T15:46:10.000+0000",
            "validityEnd": "2021-05-14T15:46:40.000+0000",
            "selfSigned": false,
            "signatureAlgorithm": "SHA256_WITH_RSA_ENCRYPTION",
            "signatureHashAlgorithm": "SHA256",
            "encryptionType": "RSA",
            "keyStrength": 2048,
            "subjectKeyIdentifierHash": "4C58DAE09FCCE0D3C2DA42623FF1B18127BCB3DD",
            "authorityKeyIdentifierHash": "0E6CBACC0A0349442B404111CDC03C0E0F07E43A",
            "serialNumber": "29DB494CA0C39B95B17FB36D49442CFDFEF4D6DA",
            "subjectDN": "cn=dev.example.com",
            "subjectCN": [
                "dev.example.com"
            ],
            "subjectAlternativeNamesByType": {
                "otherName": [],
                "rfc822Name": [],
                "dNSName": [],
                "x400Address": [],
                "directoryName": [],
                "ediPartyName": [],
                "uniformResourceIdentifier": [],
                "iPAddress": [],
                "registeredID": []
            },
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
                    "certificateInstanceId": "6a4fe140-af4b-11eb-bddc-0512c6191a85",
                    "certificateId": "6a4ef6e0-af4b-11eb-bddc-0512c6191a85",
                    "certificateSource": "USER_PROVIDED",
                    "ipAddress": "254.254.254.254",
                    "hostname": " ",
                    "port": -1,
                    "instanceChainValidationStatus": [],
                    "modificationDate": "2021-05-07T15:46:40.697+0000",
                    "applicationIds": [
                        "6ceb48b0-56cf-11eb-9b74-f168e165837c"
                    ],
                    "deploymentStatus": "SUPERSEDED"
                }
            ]
        }
    ]
}
```
1. From the JSON response, instances -> applicationIds to find the applications
   the certificate is associated with (note a certificate may be associated with
   multiple applications, but for renewal only a single application and one of
   it's associated issuing templates can be used for renewal): 
```json
{
    "id": "45d06980-ae82-11eb-9702-4fa2482840bf",
    "companyId": "b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
    "name": "DevTest",
    "description": "",
    "ownerIdsAndTypes": [
        {
            "ownerId": "b11e2720-2da1-11eb-a549-1b98453c62c9",
            "ownerType": "USER"
        }
    ],
    "fqDns": [],
    "internalFqDns": [],
    "externalIpRanges": [],
    "internalIpRanges": [
        "xxx.xxx.xxx.xxx"
    ],
    "internalPorts": [
        "443"
    ],
    "fullyQualifiedDomainNames": [],
    "ipRanges": [],
    "ports": [],
    "certificateIssuingTemplateAliasIdMap": {
        "test Built-in": "51cb8340-a993-11ea-8a4f-3f9fa45442b2"
    }
}
```


1. To renew, use the `certificaterequests` function and supply the
   `certificateIssuingTemplateId` and `existingCertificateId` from the previous
   step. Make sure the line breaks for the `certificateSigningRequest` are
   escaped with \n. 
```json
        POST https://api.venafi.cloud/v1/certificaterequests
        tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
       {
    "certificateOwnerUserId": "b11e2720-2da1-11eb-a549-1b98453c62c9",
    "certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIICYzCCAUsCAQHIvIGc.......9UDRtBoiNIqtVQxFsfT+\n-----END CERTIFICATE REQUEST-----\n",
    "applicationId": "45d06980-ae82-11eb-9702-4fa2482840bf",
    "certificateIssuingTemplateId": "51cb8340-a993-11ea-8a4f-3f9fa45442b2",
    "validityPeriod": "P7D",
    "existingCertificateId": "96fc5ad0-af4f-11eb-bddc-0512c6191a85"
}
```
 
**Example response**

```json
HTTP 1.1 OK
{
    "certificateRequests": [
        {
            "id": "438379c0-b197-11eb-af70-63816db5dcd6",
            "companyId": "b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
            "applicationId": "45d06980-ae82-11eb-9702-4fa2482840bf",
            "creationDate": "2021-05-10T13:54:39.635+0000",
            "modificationDate": "2021-05-10T13:54:39.709+0000",
            "status": "ISSUED",
            "certificateOwnerUserId": "b11e2720-2da1-11eb-a549-1b98453c62c9",
            "certificateIssuingTemplateId": "51cb8340-a993-11ea-8a4f-3f9fa45442b2",
            "certificateIds": [
                "439246d0-b197-11eb-b9a2-1b148028d7d5",
                "07478770-148b-11eb-919f-9f568471c947",
                "0743b6e0-148b-11eb-919f-9f568471c947"
            ],
            "certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIICYzCCAUsCAQAwHjE.......UDRtBoiNIqtVQxFsfT+\n-----END CERTIFICATE REQUEST-----\n",
            "subjectDN": "cn=dev.example.com",
            "keyLength": 2048,
            "keyType": "RSA",
            "subjectAlternativeNamesByType": {
                "otherName": [],
                "rfc822Name": [],
                "dNSName": [],
                "x400Address": [],
                "directoryName": [],
                "ediPartyName": [],
                "uniformResourceIdentifier": [],
                "iPAddress": [],
                "registeredID": []
            },
            "validityPeriod": "P7D"
        }
    ]
}
```
