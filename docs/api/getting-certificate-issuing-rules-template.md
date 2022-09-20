# Getting certificate issuing rules from Issuing Templates

This endpoint shows you the Issuing Rules included in the template. 

!!! note "Note" 
      An Issuing Template contains Issuing Rules which in turn might
      contain [recommended settings](defining-recommended-settings-for-an-issuing-template.md) as
      provided by your administrator."

**To get Issuing Templates configured on the system**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificateissuingtemplates`  endpoint. For additional help, refer
   to the parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}. 
   For example:

   ```
   GET https://api.venafi.cloud/v1/certificateissuingtemplates
   tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
   ```

   **Example response**
   ```json
   HTTP 200 OK
   {
      "id":"2ecb7c80-4ce9-11ea-a641-338c64866652",
      "companyId":"b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
      "certificateAuthority":"DIGICERT",
      "name":"DigiCertSSL",
      "certificateAuthorityAccountId":"14ae4e40-4ce9-11ea-8d37-97ea50fa472f",
      "certificateAuthorityProductOptionId":"169c89b0-4ce9-11ea-8d37-97ea50fa472f",
      "product":{
         "certificateAuthority":"DIGICERT",
         "productName":"ssl_plus",
         "validityPeriod":"ONE_YEAR",
         "hashAlgorithm":"SHA256",
         "autoRenew":true,
         "organizationId":301672
      },
      "systemGenerated":false,
      "creationDate":"2020-02-11T16:11:38.440+0000",
      "modificationDate":"2020-04-14T13:09:42.515+0000",
      "status":"AVAILABLE",
      "reason":"",
      "subjectCNRegexes":[
         ".*.certdemo22.thehotelcook.com",
         ".*.certdemo21.thehotelcook.com",
         ".*.certdemo20.thehotelcook.com",
         ".*.venafi.io"
      ],
      "subjectORegexes":[
         ".*"
      ],
      "subjectOURegexes":[
         ".*"
      ],
      "subjectSTRegexes":[
         ".*"
      ],
      "subjectLRegexes":[
         ".*"
      ],
      "subjectCValues":[
         ".*"
      ],
      "sanRegexes":[
         ".*.f145a.acme.ft01.qa.venafi.io",
         ".*.c11bd.acme.ft01.qa.venafi.io",
         "73beb.acme.ft01.qa.venafi.io",
         "0c6eb.acme.ft01.qa.venafi.io",
         "8dad3.acme.ft01.qa.venafi.io",
         ".*.fa951.acme.ft01.qa.venafi.io",
         "22c33.acme.ft01.qa.venafi.io",
         ".*.b1646.acme.ft01.qa.venafi.io",
         "6bf16.acme.ft01.qa.venafi.io",
         "83f4e.qa.venafi.io",
         ".*.venafi.io"
      ],
      "keyTypes":[
         {
            "keyType":"RSA",
            "keyLengths":[
               1024,
               2048,
               4096
            ]
         }
      ],
      "keyReuse":false,
      "recommendedSettings":{
         "subjectOValue":"Venafi",
         "subjectOUValue":"Venafi",
         "subjectSTValue":"Utah",
         "subjectLValue":"Salt Lake City",
         "subjectCValue":"US",
         "key":{
            "type":"RSA",
            "length":2048
         },
         "keyReuse":false
      }
   }
   ```