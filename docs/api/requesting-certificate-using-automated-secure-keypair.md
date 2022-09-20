# Requesting a certificate using Automated Secure Keypair

The `certificaterequests` function may use Automated Secure Keypair (ASK) to generate the public and private key during a certificate request. The ASK feature requires you to have at least one {{vsat}} deployed and registered with {{vs}}.

This function requires:

* The identifier of a [Business Application](listing-applications.md). The value is also known as the Application ID.
* The identifier of a certificate [Issuing Template](listing-issuing-templates.md). 
* The identifier of an [Application Server Type](listing-server-type-keystore-information-api.md).

**To get a certificate using ASK**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificatesearch` function as part of the URL and set the header. For example:
   ```
   POST https://api.venafi.cloud/outagedetection/v1/certificaterequests
   tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
   ```

1. In the JSON body, insert the `applicationId`, `certificateIssuingTemplateId` and the `applicationServerTypeId` values. For additional help, use the parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}.  For example: 
   ```json
   {
      "isVaaSGenerated": true,
      "applicationId": "785a6260-28f5-11eb-804b-6769144073a1",
      "certificateIssuingTemplateId": "11a0c6e2-28f5-11eb-999a-4d91b3bd6de9",
      "applicationServerTypeId": "784938d1-ef0d-11eb-9461-7bb533ba575b",
      "validityPeriod": "P7D",
      "csrAttributes": {
         "commonName": "ask.venafi.example",
         "organization": "Venafi, Inc.",
         "organizationalUnits": [
            "Quality Assurance"
         ],
         "locality": "Salt Lake City",
         "state": "Utah",
         "country": "US",
         "subjectAlternativeNamesByType": {
            "dnsNames": [
               "ask.venafi.example"
            ]
         }
      }
   }
   ```

1. To manage other tasks, save the `certificateIds` from the JSON response.  The first `certificateId` is that of the issued certificate and it is followed by the applicable chain certificates.

**Example response**

```json
HTTP 201 Created
{
  "certificateRequests":[
	 {
		"id": "3e191f90-4737-11ec-a491-150fc62378e9",
		"companyId": "11447611-28f5-11eb-b879-87373a818312",
		"applicationId": "785a6260-28f5-11eb-804b-6769144073a1",
		"creationDate": "2021-11-16T23:45:13.285+0000",
		"modificationDate": "2021-11-16T23:45:13.392+0000",
		"status": "ISSUED",
		"certificateOwnerUserId": "1f3873e0-2b55-11eb-9d73-73dd1c3fc270",
		"certificateIssuingTemplateId": "11a0c6e2-28f5-11eb-999a-4d91b3bd6de9",
		"certificateIds": [
		   "3e2b4800-4737-11ec-83c8-2b83ec46e96b",
		   "15840750-3434-11eb-a78e-ffa12262ebbc",
		   "15798000-3434-11eb-a78e-ffa12262ebbc"
		],
		"certificateSigningRequest": "-----BEGIN CERTIFICATE REQUEST-----\nMIIC+...",
		"subjectDN": "cn=ask.venafi.example,ou=Quality Assurance,o=Venafi, Inc.,c=US,st=Utah,l=Salt Lake City",
		"keyLength": 2048,
		"keyType": "RSA",
		"subjectAlternativeNamesByType": {
		   "otherName": [],
		   "rfc822Name": [],
		   "dNSName": [
			  "ask.venafi.example"
		   ],
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
