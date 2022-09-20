# Listing Applications
You can use the `applications` function to get details about business applications. 

**To list applications**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

2. Use the `applications` function as part of the URL and set the header.  For additional help, use the parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}. For example:

    ```
    GET https://api.venafi.cloud/outagedetection/v1/applications
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```

3. In the JSON response, save the `id`, which identifies the application object. For example: 
    ```json  
    {
        "applications": [
                {
                "id":"785a6260-28f5-11eb-804b-6769144073a1",
                "companyId":"11447611-28f5-11eb-b879-87373a818312",
                "name":"App Alfa",
                "description":"Ansible",
                "ownerIdsAndTypes":[
                    {
                        "ownerId":"cef746f0-28f6-11eb-b879-87373a818312",
                        "ownerType":"USER"
                    },
                    {
                        "ownerId":"1f3873e0-2b55-11eb-9d73-73dd1c3fc270",
                        "ownerType":"USER"
                    }
                ],
                "fullyQualifiedDomainNames":[
                    
                ],
                "ipRanges":[
                    
                ],
                "ports":[
                    
                ],
                "certificateIssuingTemplateAliasIdMap":{
                    "Dev":"b91604a0-342e-11eb-9349-e75abdd3fd72",
                    "Production":"11a0c6e2-28f5-11eb-999a-4d91b3bd6de9",
                    "Staging":"4d8e1600-431e-11ec-8e39-e52356f0792a"
                }
            }
        ]
    }
    ```
