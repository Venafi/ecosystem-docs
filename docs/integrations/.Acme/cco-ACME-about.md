# ACME integration with Venafi as a Service

ACME is a simple client/server protocol based on HTTP. The client represents the
applicant for a certificate (e.g., a web server operator), and {{ vs }}
represents the CA. ACME enables {{ vs }}  to verify that the applicant owns some
number of domains, and then enables the applicant to request certificates for
those domains.

The ACME client that is used by {{ vs }}  is *certbot*. 

To learn more about certbot, visit 
[Certbot](https://certbot.eff.org/about/).

![Roadmap](HelpDiagramACME.png)


??? optional-css-class "About the ACME protocol"

    The Automatic Certificate Management Environment (ACME) protocol is a
    communications protocol for automating interactions between certificate
    authorities and their users' web servers, allowing the automated deployment of
    public key infrastructure at very low cost. It was designed by the Internet
    Security Research Group (ISRG). 
    
    To learn more, visit 
    [ACME](https://datatracker.ietf.org/wg/acme/about/).

??? optional-css-class "About the {{vs}} ACME Server"

    The {{ vs }} ACME server is implemented as a service which is associated with
    Zones that are created in {{ vs }} . The ACME server URL is constructed based on
    the Zone ID that is associated with each Zone. The Zone configuration screen
    displays the URL of the ACME server associated with each zone. When certificate
    requests are submitted by ACME clients to the {{ vs }} ACME server, the requests
    are processed based on the [Issuing
    Template](certificate-issuing-templates.md) associated with the Zone.

    [Show me](t-ACME-request-certificate.md)

