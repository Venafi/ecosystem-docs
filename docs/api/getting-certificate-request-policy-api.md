# Getting certificate request policy via API

Before submitting a certificate signing request, it is helpful to understand the
rules with which it must comply. Rules are defined by [Issuing
Templates](certificate-issuing-templates.md) and the templates available
for the request are defined by the target Application. To get this information,
you can use the `applications/{name}` and
`applications/{name}/certificateissuingtemplates/{alias}` endpoints.

**To get policy details for an Issuing Template assigned to an Application**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `applications/{name}` function to get the ID for an application using
   its name.

    ```
    GET https://api.venafi.cloud/outagedetection/v1/applications/My%20Biz%20App
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```
    **Example response**
    ```json
    HTTP 200 OK
    {
        "id": "15927220-bcdf-11eb-aef6-d3dfbf271ceb",
        "companyId": "11447611-28f5-11eb-b879-87373a818312",
        "name": "My Biz App",
        "description": "",
        "ownerIdsAndTypes": [
            {
                "ownerId": "11ae3460-28f5-11eb-b879-87373a818312",
                "ownerType": "USER"
            }
        ],
        "fqDns": [],
        "internalFqDns": [],
        "externalIpRanges": [],
        "internalIpRanges": [],
        "internalPorts": [],
        "fullyQualifiedDomainNames": [],
        "ipRanges": [],
        "ports": [],
        "certificateIssuingTemplateAliasIdMap": {
            "Test Certs": "7f3ff940-bcdf-11eb-9af9-c947417e28d0"
        }
    }
    ```
    
1. Use the `applications/{name}/certificateissuingtemplates/{alias}` function to retrieve the Issuing Template rules and recommended settings.
   
    ```
    GET https://api.venafi.cloud/outagedetection/v1/applications/My%20Biz%20App/certificateissuingtemplates/Test%20Certs`
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```
    **Example response**
    ```json
    HTTP 200 OK
    {
        "id": "7f3ff940-bcdf-11eb-9af9-c947417e28d0",
        "companyId": "11447611-28f5-11eb-b879-87373a818312",
        "name": "Example CIT",
        "certificateAuthority": "BUILTIN",
        "certificateAuthorityAccountId": "11a0c6e0-28f5-11eb-999a-4d91b3bd6de9",
        "certificateAuthorityProductOptionId": "11a0c6e1-28f5-11eb-999a-4d91b3bd6de9",
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
        },
        "validityPeriod": "P90D"
    }
    ```
