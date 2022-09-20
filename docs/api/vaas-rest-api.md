# VaaS REST API

The {{vs}} REST API provides programmatic access to functionality that is
available via the VaaS Web user interface (UI). Any task that can be performed
using the UI can also be accomplished using the REST API. This feature allows
you to automate operations that are present in the UI for greater consistency
and scale. 

The REST API follows best practices in API design. For example, it uses JSON for
encapsulating objects returned by the API, proper HTTP request verbs and status
codes, and comprehensive error messages in failed requests to aid developers in
diagnosing issues.

Common use cases for the VaaS API include:

* Auditing your organization’s VaaS account to understand what certificate
  issuance policies are being enforced.

* Requesting certificates from VaaS for use by applications, such as
  HTTPS-enabled web servers.

* Searching VaaS to understand what certificates have been issued by your
  organization. You can also get information about certificates that have been
  discovered by VaaS both internally and externally.

* Extracting data for custom reports, based on certificate data and summary
  information, to help track key and certificate management policy compliance.

The sections that follow describe how to use the {{vs}} REST API. To help you
get started, the following table lists basic tasks. You can use this guide in
conjunction with our {% include 'sn-Cloud-api-LinktoSwagger.md' %}.

The Swagger documentation provides in depth descriptions and samples for all API
calls.

Instructions for getting your API key can be found [here](obtaining-api-key.md).

I want the REST API to help me ... | Visit this topic
---------- | -------
Choose an Issuing Template | [Listing Issuing Templates](listing-issuing-templates.md) |
Create an Application | [Adding an Application](creating-an-application-api.md) |
Choose an existing Application | [Listing Applications](listing-applications.md) |
Get a certificate | [Requesting certificates](get-a-certificate-using-csr.md) |
Renew a certificate | [Renewing a certificate](renewing-a-certificate-api.md) |
Find an existing certificate | [Searching for certificates](searching-for-certificates.md) |
Show certificate information | [Viewing certificate metadata]() |
Download a certificate | [Retrieving a certificate](downloading-a-certificate.md) |