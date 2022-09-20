# Creating an Application

You can use the `applications` function to create new business applications. 

**To create an application**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

2. Use the `useraccounts` function to obtain your user ID.

    ```
    GET https://api.venafi.cloud/v1/useraccounts
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```

3. Save the `id`, which is your user ID, for specifying the owner of your new
   application. 

    **Example response**

    ```json
    HTTP 200 OK
    {
        "user": {
            "username": "dirk@example.com",
            "id": "66778cf0-ef26-40aa-94ef-b105909cccd7",
            "companyId": "3e290d9e-cf8b-4472-8100-ec76a3ed9a1b",
            "firstname": "Dirk",
            "lastname": "Persona",
            "emailAddress": "dirk@example.com",
            //...
        },
        "company": {
            //...
        },
        "apiKey": {
            //...
        }
    }
    ```

4. Use the `applications` function. For additional help, use the parameter
   descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}. For example:

    ```
    POST https://api.venafi.cloud/outagedetection/v1/applications
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```

5. In the JSON body, insert your user ID for the `ownerId` value. To assign an
   [issuing template](listing-issuing-templates.md) to the application,
   include the template ID and a desired alias (short name) in the
   `certificateIssuingTemplateAliasIdMap` section.  For example:
    ```json
    {
        "name": "My Business App",
        "ownerIdsAndTypes": [
            {
                "ownerId": "66778cf0-ef26-40aa-94ef-b105909cccd7",
                "ownerType": "USER"
            }
        ],
        "certificateIssuingTemplateAliasIdMap": {
            "Example CIT": "7f3ff940-bcdf-11eb-9af9-c947417e28d0"
        }
    }
    ```  

8. In the JSON response, review the Applications details. For example: 
    ```json  
    {
        "applications": [
            {
                "id": "c46413a0-c7f5-11eb-a1eb-eb343710e11f",
                "companyId": "3e290d9e-cf8b-4472-8100-ec76a3ed9a1b",
                "name": "My Business App",
                "ownerIdsAndTypes": [
                    {
                        "ownerId": "66778cf0-ef26-40aa-94ef-b105909cccd7",
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
                    "Example CIT": "7f3ff940-bcdf-11eb-9af9-c947417e28d0"
                }
            }
        ]
    }
    ```