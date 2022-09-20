# Set up Microsoft AD CS for issuing and importing certificates

The steps below will take you through everything you need to do
to get your {{adcs}} service integrated with {{vs}}. After completing
these steps, you'll be able to import existing certificates and issue
new certificates.

<div markdown="1" class="prereqs">

## <a name="adcsPrereqs"></a>Before you begin

Have the following ready before you start:

- Linux server to run {{vsat}}. See [Pre-requisites for installing {{vsat}}s](t-VSatellite-deployNew.md)
  for a list of system and network requirements. 
- Windows server to run {{vsatw}}. The server must meet the following minimum
  requirements:
    - Separate server from the server running {{adcs}}
    - {% include 'vsat/sn-vsatw-supported-windows.md' %}
    - {% include 'vsat/sn-vsatw-req-net.md' %}
    - Access to ports 135 and 49152 - 65535 on {{adcs}} Service
    - {{vsat}} connectivity to the {{vsatw}} - port 8085 (default) or the custom
      port specified during {{vsatw}} installation
    - {% include 'vsat/sn-vsatw-req-ram.md' %}
    - {% include 'vsat/sn-vsatw-req-cpu.md' %}
    - {% include 'vsat/sn-vsatw-req-disk.md' %}
- [Completed {{adcs}} configuration](setting-up-adcs.md)
- IP or hostname of your {{ms}} {{adcs}} server
- Username and password used to authenticate to {{ms}} {{adcs}} 
- {{ms}} {{adcs}} Issuing Certificate Common Name

</div>

## Step 1: Connect your {{adcs}} server to {{vs}}
<p class="stepIntro">First, we'll set up the connection between your {{ms}} 
{{adcs}} server and {{vs}}. If you don't already have a {{vsat}} or {{vsatw}}, 
these steps will walk you through those installations. If you do, then you 
can just select them during setup.</p>

1. Sign to {{vs}} at https://ui.venafi.cloud.
1. Click **Settings** > **Certificate Authorities**.
1. Click **New** > **{{ms}} {{adcs}}**.
1. Enter a **Name** for the Certificate Authority. 
    
    !!! tip
        This is the name that will be used throughout {{vs}} for this CA.
        
1. From the **{{vsatw}}** drop-down, select the {{vsatw}} to use
in this configuration.

    If you don't have a {{vsatw}} yet, click the box below for instructions on setting one up.

    ??? extrabox "Don't have a {{vsatw}} yet? Follow these steps to set one up."

        !!! important
            The {{vsatw}} must not be installed on the same server running {{adcs}}.


        1. Click **Deploy {{vsatw}}**.
        
            If you're installing the {{vsatw}} on a Windows server that has internet access, select "Online Installation." If the Server does not have internet access, select "Offline Installation."

            === "Online Installation"

                Copy the **{{vsatw}} installation command**, and then run the script in a PowerShell prompt on the Windows server where you're setting up your {{vsatw}}. 

                To use a port other than the default port 8085, replace the port number
                following the `--port` flag before running the installation command.

            === "Offline Installation"
               
                  1. Copy the **{{vsatw}} download command**, and run it in a PowerShell prompt from a machine with internet connectivity.

                    This downloads the {{vsatw}} installer (`VSatelliteWorkerInstaller.msi`) and {{vsatw}} (`vsatworkectl.exe`).
                       
                  2. Move both files to the same directory on the Windows server you want to install {{vsatw}} on.

                  3. After moving the files, copy the **{{vsatw}} installation command**, and then run the script in a PowerShell prompt on the Windows server you're setting up as your {{vsatw}}. 

                    To use a port other than the default port 8085, replace the port number
                    following the `--port` flag before running the installation command.


        1. Follow the on-screen prompts to complete the installation.

        1. Check if the {{vsatw}} service is running on the Windows server by going to the **Start menu** and typing `Services`. 
           From there, open the **Services** app, and in the **Name** column, look for **VSatWorkerService**.

        2. After the {{vsatw}} is up and running, return to the {{vs}} screen, and click **Continue**. 

        3. In the **{{vsatw}} server address**, enter the FQDN or IP address of the Windows server
        where you installed the {{vsatw}}. Include the port number. The default port is `8085`, but
        if you set a different port during installation, enter that port instead.
        
        1. Click **Set**.

        2. To complete the setup, the {{vsatw}} needs to be paired with a {{vsat}}. If you already have a {{vsat}} in place, you can select it from the **{{vsat}}** drop-down.

            If you need to set up a {{vsat}}, see the section below.


    ??? extrabox "Do you also need to set up a {{vsat}}? Follow these steps"

        A {{vsatw}} needs to be paired with a {{vsat}} in order to communicate with {{vs}}.

        1. Click **Deploy {{vsat}}**. The Deploy a {{vsat}} page opens.

        2. From the **{{vsat}} deployment script**, click **Copy Code** to copy the entire command.

        3. Run the command on the Linux server you've set up to be your {{vsat}}. Follow the on-screen instructions to complete the installation.

            !!! note "Note"
                The installation may take up to 10 minutes.

        4. After installation, return to the **Deploy a {{vsat}}** screen in {{vs}}, and click **Test Connection**.
            
            !!! note "Note"
                Activating the {{vsat}} takes a few seconds. If **Test Connection** fails initially, click the button
                again to re-test the connection until it succeeds, and the **Done** button at the bottom of the screen is enabled. 
   
        5. Click **Done**. You are returned to the **Deploy {{vsatw}}** page.

        6. The **{{vsat}}** drop-down should now show the {{vsat}} you just deployed. Click **Pair** to connect the {{vsatw}} to the {{vsat}}.

        7. Click **Done**. You are returned to the **Connection** page, and the **{{vsatw}}** drop-down is populated with the {{vsatw}} you just set up.

1. Click **Next**.

## Step 2: Enter your {{adcs}} information

<p class="stepIntro">Next, we'll enter your {{ms}} {{adcs}} server information and credentials so that {{vs}} can authenticate to your {{adcs}} server.</p>

1. In the **{{adcs}} administrative** address field, enter the IP address or
   hostname of your {{ms}} {{adcs}} server.

1. In the **Common Name (CN) of the CA's certificate** box, enter the Common
   Name of the {{ms}} {{adcs}} Issuing (root) Certificate.
    
1. Enter the **Username** and **Password** to authenticate with {{ms}} {{adcs}}.

    !!! note "{{adcs}} Permissions"
        The account you use must have _Read_, _Issue and Manage Certificates_,
        and _Request Certificates_ permissions to the {{ms}} {{adcs}} server.
    
1. Click **Test credentials**.

## Step 3: Select {{adcs}} issuance templates to map to {{vs}}

<p class="stepIntro">Now that the connection is made, we can set up certificate issuance through {{vs}}. 
This step is required only if you want to issue new TLS server authentication certificates through {{vs}}. 
If you just want to import existing certificates, see the import existing certificates steps below.</p>

1. Click in the **Issuance templates** field. After clicking in the field,
   {{vs}} queries your {{adcs}} and returns a list of issuance templates from
   your {{adcs}} server.

1. Select the {{adcs}} issuance templates that you want to map to {{vs}}.

1. Click **Add**.

    {{vs}} tests all the templates you selected. Templates with a **Passed** result are available to map to [Certificate Issuing Templates](certificate-issuing-templates.md) in {{vs}}. Those with a **Failed** result are not.

    ??? question "Why did some templates fail?"
        After adding templates, {{vs}} issues test certificates using each of the {{adcs}} issuance templates.
        {{vs}} supports issuance through templates that:

         - Have Server Authentication set in the Application Policies setting of the Extensions tab on the issuance template
         - Allow issuing certificates using RSA keys
         - Supply the Subject Name in the request (can’t issue certificates with SN build from the AD)
  
        Issuance templates that are incapable of issuing such certificates fail the {{vs}} issuance test. This is expected. Some of the predefined (default) Issuance templates that will fail are:

         - DirectoryEmailReplication
         - DomainController
         - DomainControllerAuthentication
         - KerberosAuthentication 

        Only the certificates that pass the test will be available when mapping {{adcs}} templates to {{vs}} templates.

2. Click **Next**.

{% include 'adcs/sn-adcs-stats.md' %}

**What's Next?**

Now that your {{adcs}} templates are mapped to {{vs}}, you can [create a
Certificate Issuing Template](creating-a-certificate-issuing-template.md) and
associate your {{adcs}} templates with {{vs}} issuing templates. 

Select {{ms}} from the **New Certificate Issuing** template screen. The {{adcs}}
templates that passed validation will show up in the **Product Option**
drop-down.

## <a name="import"></a>Step 4: Import existing certificates from {{adcs}}

<p class="stepIntro">This step is required only if you want to import existing certificates from {{adcs}}.</p>

1. Click in the **Import templates** box. After clicking in the box, {{vs}}
   queries your {{adcs}} and returns a list of templates from your {{adcs}}
   server.

1. Select the {{adcs}} templates that you want to import certificates from. Only
   certificates issued by the templates you select will be imported.

1. Click **Add**.

1. If you want to schedule the import to occur on a regular basis, click the
   **{{adcs}} Import** slider, and then set the import interval. This option is
   available only if one or more {{adcs}} templates were added in the previous
   steps. 

2. Under **Import options**, select whether you want to import revoked or expired certificates.

3. Click **Done**.

{{vs}} imports the certificates. 

{% include 'adcs/sn-adcs-stats.md' %}


## Troubleshooting

If you run into trouble getting the {{adcs}} integration set up, contact [Venafi
Support](https://support.venafi.com/hc/en-us).
