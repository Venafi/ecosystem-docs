# Retiring, recovering, and deleting certificate

{{vs}} lets you retire certificates that are no longer in use. If you retire a
certificate that you didn't mean to retire, there are recovery options
available.

!!! question "What does "retire" mean?"
    "Retire" refers to the act of moving a certificate from inventory to {{vs}}'s
    virtual recycle bin. After being in the recycle bin for a specific amount of
    time determined by the {{rolesSA}}, it will automatically be deleted. 

## Permissions for retiring and recovering certificates

By default, administrators and {{rolesRO}} are allowed to retire certificates
(though {{rolesRO}} have certain constraints). Administrators can change the
permissions to **Admins only** by clicking **Settings** > **Platform** in the
menu bar, and then selecting **Certificate Retirement**. 

{{rolesRO}}s can only retire certificates that are assigned to Applications they
own. In order for {{rolesRO}}s to recover a retired certificate, the certificate
must first be assigned to at least one application they own. These constraints
do not apply to admin users.

[Deleting certificates](#delete) is available only to administrators.

## To retire a certificate

1. From the menu bar, click **Inventory > Certificates**.

2. [Find the certificate](using-filters-to-find-certificates.md) that you want
   to retire. You can retire multiple certificates at the same time, if needed.

3. Select the checkboxes next to the certificates you want to retire, then click
   **Retire**.

    ![screenshot showing the location of the checkbox and Retire button](OutagePREDICT_retire_cert.png)

4. In **Retire certificate**, keep the checkbox selected if you do not want
    discovery to find the certificate again the next time it runs. 
 
5. Click **Retire**.

6. To see your retired certificates, change the Inventory view to **Retired
   certificates**. 

    ![Retired certificate in drop down list](OutagePREDICT_retire_cert_list.png)

## To recover a retired certificate

1. From the menu bar, click **Inventory > Certificates**.

2. Change the view to **Retired certificates**.

    ![Drop-down list below Inventory contains Retired Certificates](OutagePREDICT_retire_cert_list.png)

3. [Find the certificate(s)](using-filters-to-find-certificates.md) you want to recover.

4. Select the certificates to recover.

5. Click **Recover**.

6. (Optional) In **Recover Certificate**, if you want to assign the certificate
   to an application, type in the name of the application..

7. In Recover Certificate, click **Recover**.

    The certificate is returned to inventory.

## <a name="delete"></a>To delete a certificate

Administrators determine whether retired certificates are maintained in {{vs}}
or whether they are automatically deleted after a configurable period of time. This
default behavior is set clicking **Settings** > **Platform**, and then selecting
**Certificate Retirement**.

At any time, Administrator users can open a retired certificate from the inventory
and select **Delete Forever**.