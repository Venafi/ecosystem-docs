# Using Microsoft Azure with Venafi as a Service

Azure Key Vault and Web App Azure Key Vault is Azure’s central secure repository
for certificates, keys, and other secrets consumed by cloud applications. {{vs}}
can automate the full certificate lifecycle by provisioning certificates issued
by any CA into an Azure Key Vault. Consumers of Azure Key Vault certificates and
keys like Azure Web App Services are designed to automatically self-update
whenever a new version of a certificate they’re using is provisioned to the Key
Vault. This means that {{vs}} doesn’t need to worry about what is using
the certificate. 
