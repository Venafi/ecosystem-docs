# Discover public (external) certificates

Public (or external) certificates are certificates used outside of your private network. To 
discover and protect external certificates, use the default *Internet Discovery* 
service. You can add domains, external FQDNs, and external IP addresses or 
CIDR ranges as targets for your Internet discovery service.

!!! tip "TIP"
      By default, the Internet Discovery service schedule is enabled so that the discovery of external certificates is performed automatically. However, you can modify or even disable its schedule.

## To discover public certificates

1. Log in to {{vs}}.

1. In the menu bar, click **Discovery**.

1. Click the default **Internet Discovery service**, and then click the **Targets** tab.

1. In the **Targets** field, do one of the following:
    - Type one or more FQDNs and/or IP addresses, or ranges of IP addresses that reside outside of your private network, separated by commas, and then press **Enter**.

        *Example FQDN*: `mail.example.com`

        *Example IP Address and address range (CIDR block)*: `192.168.1.0/32`

        When you're finished, click **Add**.

    - Click **Import** and select a .csv file containing a list of FQDNs or IP addresses.

1. Click **Add**.

## What's next?

After you perform a discovery, it's a good idea to then [assign certificates to applications](assign-or-reassign-certificate-to-application.md).
