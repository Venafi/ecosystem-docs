# Create a new machine

Creating a _machine_ allows {{vs}} to connect directly to keystores where applications keep their certificates. {{vs}} can then install certificates into application keystores. When the certificates are used by an application, a _machine identity_ is created. 

From {{vs}}, you can manage the entire machine identity lifecycle—from key generation to certificate issuance to certificate installation.

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete this procedure. Click the type of machine you're creating below, and then gather the information before starting.

=== "F5 BIG-IP LTM"
  
    - IP address or hostname of the F5 BIG-IP LTM
    - Port number
    - User credentials. The account you use must have admin permission.

        
=== "Microsoft IIS"
    - Basic authentication

        - Microsoft IIS hostname
        - Windows Remote Management (WinRM) port
        - User credentials

    - Kerberos authentication

        - Microsoft IIS hostname
        - Port
        - Domain name
        - Key distribution center address or hostname
        - Service Principal Name
        - User credentials

=== "Common keystores"
    - SSH Protocol
        - IP Address or hostname
        - Port
        - User credentials

    - Windows remote management
        - IP address or hostname
        - Windows Remote Management (WinRM) port
        - User credentials
        - Domain name (Kerberos authentication only)
        - Key distribution center address or hostname (Kerberos authentication only)
        - Service Principal Name (Kerberos authentication only)

</div>

## To create a new machine

1. Click **Machines**.
2. Click **New**.
3. Enter a **Name** for the new machine. This name will help {{vs}} users to identify this machine.
4. Select a {{vsat}}. If you don't currently have a {{vsat}}, [deploy a {{vsat}}](t-VSatellite-deployNew.md) first, and then return to this page.
5. Select the **Machine type** you want to create, and then click **Next**.

Depending on the type of machine you are creating, follow the instructions below.

### F5 BIG-IP LTM

1. In the **F5 BIG-IP LTM Address/Hostname** field, enter the hostname or IP address of your F5.

1. If your F5 uses a port other than 443, enter the port number in the **Port** field.

1. Enter your F5 admin credentials in the **Username** and **Password** fields.

1. Click **Test Access**, then click **Create**.

### Microsoft IIS

From the **Authentication Type** drop-down, select either **Basic Authentication** or **Kerberos Authentication**, then follow the steps below.

=== "Basic Authentication"

    1. Enter the **Microsoft IIS Hostname** and the **Windows Remove Management (WinRM Port) port**. 
    2. Enable **Use TLS for WinRM** to secure the username and password when {{vs}} communicates with the IIS server.

        !!! warning
            Disabling this option will send the username and password in plaintext over the network.

        !!! warning
            Enabling the **Do not validate WinRM certificate** option will allow connections to untrusted servers.

    3. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    4. Click **Test Access**, and then click **Create**.

=== "Kerberos Authentication"

    1. Enter the **Microsoft IIS Hostname** and the **WinRM Port**. 
    2. Enable **Use TLS for WinRM** if you want TLS to be used when {{vs}} communicates with the IIS server.

        !!! tip
            Since kerberos already has built-in encryption, this option isn't necessary to secure data sent over the network.

    3. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    4. Enter the **Domain Name**, **Key Distribution Center Address/Hostname**, and **Service Principal Name**.
    5. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    6. Click **Test Access**, the click **Create**.

### Common KeyStore

From the **Protocol** drop-down, select either **SSH** or **Windows Remote Management**. 

=== "SSH"

    1. Enter the **IP Address/Hostname** and **Port** number.
    2. Enter the **Username** and **Password** to authenticate to the keystore.
    3. Click **Test Access**, and then click **Create**.

=== "Windows Remote Management"

    From the **Authentication Type**, select either **Basic Authentication** or **Kerberos Authentication**, the follow the steps below.

    **Basic Authentication**

    1. Enter the **IP Address/Hostname** and the **Port**. 
    2. Enable **Use TLS for WinRM** to secure the username and password when {{vs}} communicates with the IIS server.

        !!! warning
            Disabling this option will send the username and password in plaintext over the network.

        !!! warning
            Enabling the **Do not validate WinRM certificate** option will allow connections to untrusted servers.

    3. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    4. Click **Test Access**, the click **Create**.

    **Kerberos Authentication**

    1. Enter the **IP Address/Hostname** and the **WinRM Port**. 
    2. Enable **Use TLS for WinRM** if you want TLS to be used when {{vs}} communicates with the IIS server.

        !!! tip
            Since kerberos already has built-in encryption, this option isn't necessary to secure data sent over the network.

    3. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    4. Enter the **Domain Name**, **Key Distribution Center Address/Hostname**, and **Service Principal Name**. You can get these from your Active Directory administrator.
    3. Enter the **Username** and **Password** to authenticate to the Microsoft IIS server.
    4. Click **Test Access**, the click **Create**.

## What's next?

Now that you have one or more machines created, you can [provision certificates to those machines](provision-certificates.md).
