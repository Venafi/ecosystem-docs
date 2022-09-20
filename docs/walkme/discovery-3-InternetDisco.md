---
template: walkme.html
---

[Go back](discovery.md)

# Use the built-in Internet Discovery service

To discover and protect external certificates, use the default *Internet Discovery* 
service, created for you automatically. 

Add domains, external FQDNs, and external IP addresses or 
CIDR ranges as targets for your Internet discovery service.

1. Click the default **Internet Discovery service**, and then click the **Targets** tab.
1. In the **Targets** field, do one of the following:
    - Type one or more FQDNs and/or IP addresses, or ranges of IP addresses that reside outside of your private network, separated by commas, and then press **Enter**.

        *Example FQDN*: `mail.example.com`

        *Example IP Address and address range (CIDR block)*: `192.168.1.0/32`

        When you're finished, click **Add**.

    - Click **Import** and select a .csv file containing a list of FQDNs or IP addresses.

1. Click **Add**.

    [Learn more ![Weblink](../img/ico-weblink.gif)](../vaas/discovery/t-Cloud-domain-external.md){:target="_blank"}

## Next steps

After you perform a discovery, it's a good idea to then [assign certificates to applications ![Weblink](../img/ico-weblink.gif)](../vaas/application/assign-or-reassign-certificate-to-application.md){:target="_blank"}.

[Go back](discovery.md)