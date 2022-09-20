# Generating a CSR using VCert

If you changed the settings of a certificate that you want to renew, you need to
generate a new Certificate Signing Request (CSR) that contains the new settings.
If you are already familiar and comfortable with generating CSRs, then generate
a new one and paste it into the Certificate Signing Request box that you'll see
during the renewal process.

If you're new to generating CSRs, we can walk you through it.

**There are three easy steps:**

??? optional-css-class "Download the {{vcert}} utility from {{vs}}" 
    The Venafi {{vcert}} utility and library is hosted on Venafi's Github page
    [here](https://github.com/Venafi/vcert/releases/tag/v4.11.0).

    1. Run the executable file from the command line:
            
            c:\Users\[username]\downloads>vcert-win-x64.exe

    1. Accept the End User License Agreement to continue.

??? optional-css-class "Use a command line entry to request a CSR"
    Get the certificate settings.

    ![upload a certificate signing request window](../img/Condor_upload_CSR.png)

    1. Enter the certificate's CSR requirements on the command line.

        Example: This Windows example uses the CSR requirements as shown in the screenshot above:

            vcert_win_x64 gencsr -cn "www.MyCompany.com" -o "My Company" -key-type rsa -key-size 2048 -ou "Mein Company" -l "Oakland" -st "California" -c US  

        ??? optional-css-class "CSR Options"
        
            | Option  |  Description     |  
            |:----------|:-------------|
            | -o| Use to specify the organization name (O). | 
            | -ou|  Use to specify the organizational unit. (OU).| 
            | -c|  Use to specify the country (C).| 
            | -st| 	Use to specify the state/province (ST) | 
            | -l|  Use to specify the locality (L). | 
            | -no prompt|  Use to indicate that the utility will not prompt you for input. This is useful for scripting.  **Important** If this option is specified, {{vcert}} will not prompt you for a private key passphrase and your private key will not be encrypted. |
            |-san-email| Used to specify one or more email Subject Alternative Names. Example: -san-email abc@abc.xyz  | 
            | -san-ip|  Use to specify one or more IP Address Subject Alternative Names. Example: -san-ip 1.1.1.1| 
            | -verbose|  Use to increase the level of logging detail, which is helpful when troubleshooting issues.| 
            | -key-size|  Use to specify the key size. {{vcert}} can generate 1024, 2048, or 4096-bit RSA keys. Example: -key-size 2048 | 
            | -key-type|  Use to specify the key type. Example: key-type rsa| 
            | -key-password|  Use to specify a password for encrypting the private key. For a non-encrypted private key, specify -no-prompt without specifying this option. You can specify the password using one of three methods: at the command line, when prompted, or by using a password file. Example: -key-password file:/Temp/mypasswords.txt |
            | -key-file| Use to specify a file name and a locaiton where the resulting key file should be written. Example: /tmp/newkey.pem  | 
            | -csr-file|  Use to specify a file name and a location where the resulting CSR file should be written. Example: /tmp/newcsr.pem | 
            |-h |  Use to show help text. |

    1. When asked to enter a key pass phrase, enter something that you'll remember. The pass phrase will be used to encrypt the private key.
        The result will look something like this:
        ![example of encrypted private key](../img/Condor_CSR_result.png)

??? optional-css-class "Copy and paste the new CSR"
    

    1. Copy everything starting with `– - - - -Begin Certificate Request– - - - -` through `– - - - -End Certificate Request– - - - -`.

    1. Paste it in the **Certificate Signing Request** field. 
    
        ![Upload a certificate signing request window](../img/Condor_paste_CSR.png).

    1. Click **Next**.

