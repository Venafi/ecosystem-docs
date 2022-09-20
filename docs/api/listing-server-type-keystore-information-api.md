# Listing server type keystore information via API

The `applicationservertypes` function shows keystore formats for various application server categories or types.  Several of these types are created by default but users may also create custom types to help identify their most appropriate keystore format.

**To list application server types**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md). For additional help, use the parameter descriptions from {% include 'sn-Cloud-api-LinktoSwagger.md' %}.For example:
   ```
   GET https://api.venafi.cloud/outagedetection/v1/applicationservertypes
   tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
   ```

1. Use the `applicationservertypes` function as part of the URL and set the header.  

1. In the JSON response, save the `id`, that represents the application server type that you want. For example: 
  
**Example response**

```json
HTTP 1.1 OK
{
   "applicationServerTypes":[
      {
         "id": "784938d1-ef0d-11eb-9461-7bb533ba575b",
         "companyId": "85d375a0-8038-11e5-bf87-317fe88bb23a",
         "creationDate": "2021-07-27T19:04:29.661+0000",
         "keyStoreType": "PEM",
         "applicationServerType": "APACHE",
         "platformName": "Apache"
      },
      {
         "id": "784a9861-ef0d-11eb-b9e4-49df27378808",
         "companyId": "85d375a0-8038-11e5-bf87-317fe88bb23a",
         "creationDate": "2021-07-27T19:04:29.670+0000",
         "keyStoreType": "PKCS12",
         "applicationServerType": "CITRIX",
         "platformName": "Citrix"
      }
      ...
   ]
}
```