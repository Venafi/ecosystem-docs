# Checking a certificate status
You can use the `certificaterequests` function to show the CA Account approval
status. VaaS reports one of the following statuses: 

* `NEW`: The request was received and saved from the end user.
* `PENDING`: The request was successfully submitted to the CA account.
* `REQUESTED`: The CA account acknowledged the receipt of the certificate request.
* `ISSUED`: The CA account successfully issued the certificate.
* `REJECTED`: The CA account rejected the certificate request.
* `CANCELLED`: The certificate request was canceled.

**To check the status of a certificate request**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificaterequests` function and the certificate request ID. For
   additional help, use the parameter descriptions from {% include
   'sn-Cloud-api-LinktoSwagger.md' %}. For example:

    ```
    GET https://api.venafi.cloud/outagedetection/v1/certificaterequests/b30736b0-bce1-11eb-9af9-c947417e28d0
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```

2. In the JSON response, review the Status field. For example: 
    ```json  
    HTTP 200 OK
    {
        "id": "b30736b0-bce1-11eb-9af9-c947417e28d0",
        "companyId": "11447611-28f5-11eb-b879-87373a818312",
        "applicationId": "15927220-bcdf-11eb-aef6-d3dfbf271ceb",
        "creationDate": "2021-05-24T22:45:12.276+0000",
        "modificationDate": "2021-05-24T22:45:12.374+0000",
        "status": "ISSUED",
        "certificateOwnerUserId": "11ae3460-28f5-11eb-b879-87373a818312",
        "certificateIssuingTemplateId": "7f3ff940-bcdf-11eb-9af9-c947417e28d0",
        "certificateIds": [
            "b3184db0-bce1-11eb-8ea7-472b6688a8bb",
            "15840750-3434-11eb-a78e-ffa12262ebbc",
            "15798000-3434-11eb-a78e-ffa12262ebbc"
        ],
        "certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIIDA.....+pv7l\n-----END CERTIFICATE REQUEST-----\n",
        "subjectDN": "cn=example.vfidev.com,ou=Documentation,o=Venafi, Inc.,c=US,st=Utah,l=Salt Lake City",
        "keyLength": 2048,
        "keyType": "RSA",
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
        "apiClientInformation": {
            "type": "My API Client",
            "identifier": "10.20.30.40"
        },
        "validityPeriod": "PT168H"
    }
    ```
    
