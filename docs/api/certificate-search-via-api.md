# Certificate search via the API

This section shows you basic information about how to programmatically search
for certificates. You can uses these APIs to get specific information:

* `certificatesearch`: Finds basic information about discovered certificates,
  for example, expired certificates.
* `certificateinstancesearch`: Finds additional information about certificate
  instances, such as cipher suites, protocols, IP address, host, port data. A
  certificate instance is a webserver or device that is using a certificate to
  offer Secure Socket Layer (SSL) or Transport Layer Security (TLS)
  connectivity.
* `managedcertificatesearch`: Finds certificate information such as the location
  where a certificate is installed or provisioned.