# Listing Issuing Templates
You can use the `certificateissuingtemplates` function to list Certificate
Issuing Templates along with their details. 

**To list Issuing Templates**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificateissuingtemplates` function. For additional help, use the
   parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}.
   For example:

    ```
    GET https://api.venafi.cloud/v1/certificateissuingtemplates
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```

1. In the JSON response, review the Issuing Template details. For example: 
    ```json  
    {
        "certificateIssuingTemplates": [
            {
                "id": "7f3ff940-bcdf-11eb-9af9-c947417e28d0",
                "companyId": "11447611-28f5-11eb-b879-87373a818312",
                "certificateAuthority": "BUILTIN",
                "name": "Example CIT",
                "certificateAuthorityAccountId": "11a0c6e0-28f5-11eb-999a-4d91b3bd6de9",
                "certificateAuthorityProductOptionId": "11a0c6e1-28f5-11eb-999a-4d91b3bd6de9",
                "product": {
                    "certificateAuthority": "BUILTIN",
                    "productName": "Default Product",
                    "validityPeriod": "P90D"
                },
                "systemGenerated": false,
                "creationDate": "2021-05-24T22:29:26.356+0000",
                "modificationDate": "2021-05-24T22:29:52.383+0000",
                "status": "AVAILABLE",
                "reason": "",
                "subjectCNRegexes": [
                    ".*\\.vfidev\\.com",
                    ".*\\.vfidev\\.net"
                ],
                "subjectORegexes": [
                    "Venafi, Inc\\."
                ],
                "subjectOURegexes": [
                    ".*"
                ],
                "subjectSTRegexes": [
                    "Utah",
                    "California"
                ],
                "subjectLRegexes": [
                    "Salt Lake City",
                    "Palo Alto"
                ],
                "subjectCValues": [
                    "US"
                ],
                "sanRegexes": [
                    ".*\\.vfidev\\.com",
                    ".*\\.vfidev\\.net"
                ],
                "sanDnsNameRegexes": [
                    ".*\\.vfidev\\.com",
                    ".*\\.vfidev\\.net"
                ],
                "keyTypes": [
                    {
                        "keyType": "RSA",
                        "keyLengths": [
                            2048,
                            4096
                        ]
                    }
                ],
                "keyReuse": false,
                "recommendedSettings": {
                    "subjectOValue": "Venafi, Inc.",
                    "subjectOUValue": "",
                    "subjectSTValue": "Utah",
                    "subjectLValue": "Salt Lake City",
                    "subjectCValue": "US",
                    "key": {
                        "type": "RSA",
                        "length": 2048
                    },
                    "keyReuse": false
                }
            },
            {
                "id": "11a0c6e2-28f5-11eb-999a-4d91b3bd6de9",
                //...
            },
            //...
            {
                "id": "6b260700-9cb5-11eb-a628-b53bded3467f",
                //...
            }
        ]
    }
    ```
