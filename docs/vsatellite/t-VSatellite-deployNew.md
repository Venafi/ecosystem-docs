# Deploying VSatellites

After you've carefully reviewed and completed [all prerequisite steps](r-VSatellite-deployNew.md), you're ready to deploy a {{vsat}} to your target computer. 

Deploying a {{vsat}} involves three basic steps:

1. Download the {{vsat}} installer (vsatctl) onto your target computer
1. (Recommended) Verify the integrity of the download
1. Run the install (vsatcl)

!!! tip "Tip"
    It's helpful to have both the {{vsat}}s page open in {{vs}} (**Settings** > **VSatellites**) and a command line utility connected to your target computer before you begin, as you'll be making changes to both.

1. Sign in to {{vs}}, and then click **Settings** > **{{vsat}}s**.

1. On the {{vsat}}s page, click **New** to open the {{vsat}} deployment configuration worksheet, and then do the following:

    1. Under {{vsat}} deployment customization, specify the life of the code as well as the number of installations allowed.

        ??? optional-css-class "What's this?"
        
            Each {{vsat}} has a *pairing code* (included within the setup command) that identifies it to {{vs}} and establishes a secure connection between your computer and {{vs}}. Once you configure a pairing code, it then has a fixed lifetime. Once configured, you'll have fixed window of time in which to use the pairing code to connect your {{vsat}} to {{vs}}.

            To facilitate rapid deployment of multiple {{vsat}} to your infrastructure, you can reuse a pairing code across multiple {{vsat}}s.

    1. Under **Download {{vsat}}**, click **Copy Code** to copy the entire command.

    1. At a command prompt to your target computer, run the command you copied.

        This command downloads the {{vsat}} installer (vsatctl).

    1. (Optional) To ensure that the artifact you downloaded is secure, copy the **{{vsat}} archive integrity check** command and run it.

    1. Now copy the final command to install the {{vsat}} by doing one of the following: 
    
        - (Optional) Paste the command, append the <code>--venafi-registry</code> flag, and then run it.
            
            Example: <code>chmod +x ./vsatctl && ./vsatctl install --pairing-code c710f1ae-49f7-4a0c-9bde-e057f5434e57 --venafi-registry</code>

        - Paste and run the command (without appending <code>--venafi-registry</code>).
            
            For more about this, see the *Network connections* section above.

    1. Review and accept the license agreement to continue.

        ![Example install EULA](img/ss-vsatctl-eula.png)

    1. After installation is complete, go back to {{vs}} and click **Test Connection**.

1. When the connection test completes successfully, click **Done**.

## Next steps

- [Backing up and restoring {{vsat}}s](../dek/c-VSatellite-BackupRestore-about.md)
- [Troubleshooting {{vsat}} connection issues](../_FAQ-Troubleshooting/Troubleshooting.md)
- [Learn how to manage your installed {{vsat}}s](t-VSatellite-managing.md)
- [View your current list of {{vsat}}s](t-VSatellite-monitoring.md)
    <!--     - Toggle master vs. detail view -->
- [Rename a {{vsat}}](renaming-a-vsatellite.md)
- [Delete a {{vsat}}](t-VSatellite-delete.md)
    <!-- - [View a {{vsat}}'s available services]() **DW: add link to topic** -->
    <!-- - [Learn more about what gets installed as part of {{vsat}}s](). **DW: add link to new topic?** -->
