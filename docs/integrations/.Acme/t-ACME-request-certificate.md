# Requesting an ACME certificate using certbot

You can easily request and enroll a certificate using certbot and your ACME
server.

!!! tip "Tip"  
    For a list of basic certbot commands for use when working with users,
    registrations, and certificates see [Basic ACME certbot
    commands](r-ACME-basic-certbot-commands.md).

The following example shows:

* The certbot command for requesting a certificate with two domains
  (chicago-cubs.venafi.example and cubs.venafi.example) from the ACME server to
  an Apache server.

* That webroot is a feature of certbot that automates the HTTP domain validation
  (putting the ACME challenge on the web server so that {{vs}} can check
  it).
    
* That certbot also supports a manual mode in which the user must copy and paste
  the ACME challenge to a file and put it on his or her web server manually.

    >certbot certonly --webroot \
    
    >--server https://api.venafi.cloud/acme/v1/[ZoneID]//directory \
    
    >--cert-name cubs \
    
    >--domains chicago-cubs.venafi.example,cubs.venafi.example \
    
    >--webroot-path /var/www/html

When the certificate request is successful, you will receive a note that
includes details about the new certificate.

![cmd line output showing enrollment success](ACME_enrollment_success_notification.png)