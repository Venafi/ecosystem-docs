# Downloading a keystore 

You can only download a keystore if the certificate was previously issued using
Automated Secure Keypair (ASK). Downloading a keystore involves the exchange of
passphrases and private keys with a {{vsat}}.  For greater security, {{vs}} has
been designed to prevent exposure of that sensitive data in the cloud by
leveraging the NaCl libsodium library and its SealedBox component. 

Since there are multiple steps and a third party library involved in requesting
a certificate using ASK and downloading a keystore, it is easiest to illustrate
using a code sample.  You can also greatly simplify this task by using one of
the VCert SDKs.

The flow in the code samples is: 

* Create a certificate using ASK. 

* Use the `id` in the response to call the 'certificates{id}' function and get
  the data encryption key (DEK) hash.

* Call the `edgeencryptionkeys/{DEK}` function to get the public `key` hash.

* Use the DEK hash, password, and a nonce to encrypt the passphrase. Encryption
  is via a NaCl/libsodium library.

* Call the `keystore` function to download the keystore as a zip.

**To run the sample**

Make these preliminary function calls to get the data that seeds the sample. 

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).
   ```
   GET https://api.venafi.cloud/v1/certificateissuingtemplates
   tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
   ```

1. Get and save the application identifier of a [Business
   Application](listing-applications.md). The value is also known as
   the Application `id`. For example: 
   ```json  
   {
      "applications": [
         {
            "id": "785a6260-28f5-11eb-804b-6769144073a1",
            ...
   ```

1. Get and save the identifier of a certificate [Issuing
   Template](listing-issuing-templates.md). The value is also known as
   the Certificate Issuing Template (CIT) `id`. For example: 
   ```json  
   {
      "certificateIssuingTemplates": [
         {
            "id": "7f3ff940-bcdf-11eb-9af9-c947417e28d0",
            ...
   ```
	
1. Get and save the keystore type for an [Application Server
   Type](listing-server-type-keystore-information-api.md). The value you need is the `id`.
   For example: 
   ```json
   {
   "applicationServerTypes":[
      {
         "id": "784938d1-ef0d-11eb-9461-7bb533ba575b",
         "companyId": "85d375a0-8038-11e5-bf87-317fe88bb23a",
         "creationDate": "2021-07-27T19:04:29.661+0000",
         "keyStoreType": "PEM",
         "applicationServerType": "APACHE",
         ...
   ```

1. Click a language tab (below). In an IDE, open the sample. Paste the values
   from previous steps, and run it.

    === "Python"
         To install NaCl, open a command prompt and type `pip install pynacl`.

         1. Type, `pip install six`.

         1. If you're using Python 3.x, replace `import six.moves.urllib.parse as urlparse` and use `import urllib.parse` instead.
         
         1. <a href="../../assets/codesamples/vaasKeystoreDownload.py">Download the Python sample</a>.       
         
         1. Set your environment variables based on parameters in the `# VaaS credentials` section. 
         
         1. Run the sample.

    === "Go"

        The NaCl library is already present in the Go environment. No installation is necessary. 

        1. <a href="../../assets/codesamples/vaasKeystoreDownload.go" download>Download the Go language sample</a>.
        
        1. Use a line editor. If necessary, set constants in the 'Const' declaration.

        1. Run the sample.

    === "Java"

         To run the Java sample: 

         1. <a href="../../assets/codesamples/vaasKeystoreDownload.java" download>Download the Java sample</a>.
        
         1. Use a line editor to customize the script:

            * Follow the script instructions about installing import libraries. 
            * If necessary, set the `private static final string` values.     
        
         1. Run the sample.    
