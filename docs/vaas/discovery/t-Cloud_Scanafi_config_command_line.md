# Configure and copy Scanafi command line

Scanafi is a command-line based utility. Options that dictate the operating mode, network segments where certificate discovery is performed, and scan parameters are specified in a configuration JSON file when the program is called from the command line. The configuration JSON file parameters are the same regardless of the version (Windows, Linux, MacOS) being run.

!!! note "NOTE"  
    
    If you are using our {{vs}} product, you don't need to build a configuration file. Just download the file provided.

## To configure the Scanafi Command Line

1. In the menu bar, click **Discovery > Internal Discovery** tab.

1. Enter a list of internal IP addresses and ranges.

    OR

1. (Recommended) Associate your TLS certificates with the [application](creating-an-application.md) it supports.
    
1. Click Copy Scanafi Command Line.

    Command line code is generated for your specific environment: Linux, Windows or Mac OS.

1. Copy the Scanafi command line and then run it.
    
    ![Insert alt text here](img/OutagePREDICT_Scanafi_copy_command_line.png)

    !!! note "NOTE"
        We recommend running Scanafi as a service using a Cron job for Linux or MacOS and Windows Scheduled Task for Windows. At a minimum, run a scan every 7 days or more frequently if desired. Using sophisticated reconciliation processes and to eliminate duplicates, VaaS will reconcile multiple discoveries of the same certificate instances so that you don’t have to.

Next step: [Create a discovery service](c-Cloud-discovery-service.md)
