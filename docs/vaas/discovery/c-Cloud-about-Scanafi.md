# Downloading and installing Scanafi

??? optional-css-class "What is Scanafi?"
    
    - Scanafi is a lightweight command line tool that enables you to scan hosts on your internal network for SSL/TLS certificates. Scanafi is available as a single executable file for Windows, Linux, and MacOS operating systems.

    - Scanafi performs network discoveries for certificates on port 443 and additional well-known ports via SSL/TLS and STARTTLS handshakes.

    - This utility tests for the presence of known vulnerabilities such as DROWN, Heartbleed, logjam, poodle, and poodle TLS.

    - The primary mode of operation involves sending certificate discovery results to the {{vs}} Platform over REST API. This communication is over HTTPS TCP Port 443.

    - Scanafi can operate in two simple modes: online or offline. 

        ??? optional-css-class "Online mode"

            The online mode involves the automatic transmission of certificate discovery results to the VaaS instance specified in the API call portion of the command line operation.
            
            For online mode with VaaS, communication is over HTTPS and authentication credentials (an API token) for {{vs}} are also required. You can get an API token after successful registration on VaaS.

        ??? optional-css-class "Offline mode"

            Scanafi is capable of operating in a offline mode. In this mode, all certificate discovery results are logged to a standard text file, in JSON format. This file can then be collected for out-of-band import to {{vs}} Platform using the {{vs}} API.



## To download and install the Scanafi utility

1. In the menu bar, click **Discovery > Internal Discovery** tab.
1. Click **Scanafi download page** to learn about and download the Scanafi utility.
1. (Optional) Click How do I install and run the utility? to familiarize yourself with how Scanafi works.

    !!! note "NOTE"  
        The installation location must have access to the IP addresses you want to scan. If it's running in online mode, Scanafi should also have Internet access to upload results to the appropriate instance of VaaS.

1. Click **Download** next to the appropriate operating system.
1. Save the file, then run it.

Next step: [Configure and copy the Scanafi command line](t-Cloud_Scanafi_config_command_line.md)

??? optional-css-class "Deployment strategies"
    
    Scanafi is deployed as an executable file and requires no installation on the target host. It does not receive commands or perform work from a centralized platform. Scans that are performed are simply passed as command arguments to the executable.

    While it is possible to execute scans manually by copying the executable to a host and executing Scanafi, it is assumed that in most enterprise organizations a more automated management process would be desired. A typical strategy is to identify hosts within network segments to host the Scanafi executable and configure scheduled tasks and/or cron jobs to routinely execute the discovery process.

    Another strategy would be to use existing system management frameworks (i.e. BigFix, Tanium, Puppet, Chef, and Microsoft SCCM) already in place to manage, patch, and configure systems in the environment to automatically deploy Scanafi. Discovery would be executed, then Scanafi would automatically be removed after completion.

    ### Automated Result Processing

    The typical approach is for Scanafi to be configured to execute on a host within the target network segment and upon completion of the scan, send the results directly to {{vs}} using the WebSDK API. This approach simplifies any additional work required to process result files in order to gain visibility through {{vs}}.

    ### Standalone Result File Processing

    Another approach is to deploy Scanafi to a host within the targeted network segment and execute it with parameters intended to scan the local subnet then output results to a JSON file. Upon completion, the results file can be sent to a central location for import into {{vs}} using the WebSDK API. The executable and result file can then be removed from the target machine.
