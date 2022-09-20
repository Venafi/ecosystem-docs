# Setting Microsoft AD CS permissions

The information below walks you through how to set up your {{ms}} {{adcs}}
account so that it can integrate with {{vs}}. Go through these steps prior
to setting up the {{adcs}} certificate authority in {{vs}}.

## Set {{adcs}} permissions

Following these steps will allow {{vs}} to enroll certificates for any template
that does not require a signature and to which its group has been given Enroll
permissions. 

1. Create an Active Directory group.

2. Create an Active Directory user account to use when enrolling with {{ms}}
   {{adcs}}.

3. Add this user to the group you created.

4. Using the Certification Authority MMC snap-in, right-click on the CA name and
   select **Properties**. On the **Security** tab, add the group and grant it
   `Issue and Manage Certificates` and `Request Certificates` permissions. 

    !!! info "Adding MMC snap-ins"
        If you're not familiar with using MMC snap-ins, see [Adding an MMC Snap-in](#addSnapin)
        below.

5. Using the Certificate Templates MMC snap-in, right-click on a template that
   {{vs}} will enroll and select **Properties**. On the **Security** tab, grant
   the group `Read` and `Enroll` permissions. Repeat this step for all templates
   that this group will enroll.

6. [Create a {{ms}} {{adcs}} Certificate Authority in {{vs}}](issuing-certificates-with-microsoft-adcs.md). 
   {{vs}} will automatically test that the used group can enroll certificates for the
   specified templates. 

## What's Next

You're now ready to [set up an {{adcs}} certificate authority in {{vs}}](issuing-certificates-with-microsoft-adcs.md).
Have the following {{adcs}} information ready before you begin:

- IP or hostname of your {{ms}} {{adcs}} server
- Username and password for the {{adcs}} account you set up in these steps
- {{ms}} {{adcs}} Issuing Certificate Common Name 

    ??? question "Where can I find the Common Name?" 
        There are two ways to obtain the Common Name of the Issuing Certificate:
          
          - Open the Issuing Certificate, go to the **Details** Tab and check the CN value for Issuer.
        
          - From the Certification Authority MMC snap-in, expand the root node, and the name of the CA 
            itself is the CN of the Issuing Certificate. In the example below, the CN is `VaasQATestCA`.

            ![Screenshot showing where to find the CN in the MMC](mmc-cn.png)

## <a name="addSnapin"></a>Adding an MMC Snap-in

If you're unfamiliar with how view the MMC snap-ins referenced in the steps
above, follow these steps.

1. On your Windows server, select **Run** from the **Start** menu, and then
   enter `mmc`. The MMC opens.

1. From the **File** menu, select **Add/Remove Snap-in**. The **Add or Remove
   Snap-ins** window opens.

1. From the **Available snap-ins** list on the left, select the snap-in that you
   want to add, and then click **Add**.

1. For the Certificate Authority MMC snap-in, select the computer you want the
   snap-in to manage. If you're performing these steps from your {{adcs}}
   server, click **Local Computer**. Otherwise, select **Another Computer** and
   specify your {{adcs}} server.

1. Click **Finish**, and then click **OK**.
