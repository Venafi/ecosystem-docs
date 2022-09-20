# Get a certificate using CSR

The `certificaterequests` function enrolls a certificate using a Certificate Signing Request (CSR). This function requires:

* An application ID
* A CSR
* An Issuing Template

When submitting a certificate request to {{vs}}, you must choose an [Issuing Template](certificate-issuing-templates.md) 
to use to evaluate the request. 

**To request a certificate**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

2. Obtain an Application ID for the certificate request. The Application to
   associate your certificate with should be based on which business purpose or
   systems the certificate will be used on. Applications are configured with a
   set of Certificate Issuing Templates that the Application Owner decided are
   permissible for requesting certificates.

3. Use a tool, such as
   [VCert](https://github.com/Venafi/vcert/blob/master/README-CLI-CLOUD.md#generating-a-new-key-pair-and-csr)
   or OpenSSL, to generate a CSR in the PKCS#10 format. The CSR field data must
   conform to the rules of the Issuing Template. 

4. Use the `certificaterequests` function and supply the CSR. For additional
   help, use the parameter descriptions from {% include
   'sn-Cloud-api-LinktoSwagger.md' %}. For example:
    ```
    POST https://api.venafi.cloud/outagedetection/v1/certificaterequests
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```
5. In the JSON body, insert the `applicationId` and the
   `certificateIssuingTemplateId` values. Where necessary, make sure the CSR
   line breaks are escaped with \n. For example:
    ```json
    {
        "certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIICYzCCAUsCAQAwHj....BoiNIqtVQxFsfT+\n-----END CERTIFICATE REQUEST-----\n",
        "applicationId": "45d06980-ae82-11eb-9702-4fa2482840bf",
        "certificateIssuingTemplateId": "51cb8340-a993-11ea-8a4f-3f9fa45442b2",
        "validityPeriod": "P7D"
    }
    ```    
6. Save the `id`, which is the Certificate Request ID, for other tasks, such as
   checking the status of a certificate. 

    **Example response**

```json
    HTTP 201 Created
    {
        "certificateRequests": [
            {
                "id": "ee8ae040-b19e-11eb-a502-139659b036ff",
                "companyId": "b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
                "applicationId": "45d06980-ae82-11eb-9702-4fa2482840bf",
                "creationDate": "2021-05-10T14:49:33.047+0000",
                "modificationDate": "2021-05-10T14:49:33.119+0000",
                "status": "ISSUED",
                "certificateOwnerUserId": "b11e2720-2da1-11eb-a549-1b98453c62c9",
                "certificateIssuingTemplateId": "51cb8340-a993-11ea-8a4f-3f9fa45442b2",
                "certificateIds": [
                    "ee995f30-b19e-11eb-90c3-b33418a6820c",
                    "07478770-148b-11eb-919f-9f568471c947",
                    "0743b6e0-148b-11eb-919f-9f568471c947"
                ],
                "certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIICYzCCAUsCA...Gc9UDRtBoiNIqtVQxFsfT+\n-----END CERTIFICATE REQUEST-----\n",
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