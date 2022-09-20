# Obtaining an API Key

The API key, which generates during account registration, provides data access
via the REST API. Except for the `useraccounts` function, all other REST API
calls require the VaaS API key. 

**To obtain an API key**

1. Log in to {{vs}}.

1. In the banner, click your account name.

1. Click **Preferences**.

2. Select **API Keys**. Click the copy icon next to your API key.

![API Key](vaas-api-key.jpg)

!!! tip "Best Practice"
     Save the API key. For every REST API call, you pass the `Content-type` and 
     the API key value. For example: 

    ```
    Content-Type: application/json
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
    ```
