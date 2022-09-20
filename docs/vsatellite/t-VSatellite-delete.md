# Deleting VSatellites

When you need to retire an existing {{vsat}}, you can delete one or more of them
from the {{vsat}} page.

To delete a {{vsat}}, you'll delete it within {{vsl}} and then [delete the binary](#remove-linux) from the
file system where it's installed.

!!! warning "Warning!"
    Deleting the *very last {{ vsat }}* results in also permanently deleting 
    any associated services, as well as the {{vsat}}'s data encryption key (DEK), 
    which contains all related keys and credentials. Learn more about 
    [deleting your last available {{vs}}](c-VSatellite-LastVSat-deleting-implications.md).

!!! important "Important"
    Deleting {{ vsat }}s with existing services running on them
    could cause an outage of those services. Before deleting, we
    recommend [assigning the services to a different {{ vsat }}](#reassign).

    If you don't need the services any longer, you can [delete
    the {{ vsat }}](#delete) without reassigning the services.

## <a name="reassign"></a>Reassign existing services to a different {{ vsat }}

1. Log in to {{vs}}.
1. Click **Settings** > **Services**.
1. In the left pane, click the Service you want to reassign.
1. Click the **Administration** tab.
1. In the **{{vsat}}** section, click in the box and select a different {{vsat}}.
1. Click **Save**.

Repeat these steps for every service running on the {{vsat}} you want to delete.

## <a name="delete"></a>Delete one or more {{ vsat }}s from {{ vs }}

1. Log in to {{vs}}.
1. Click **Settings** > **{{vsat}}s**.
1. Select the {{vsat}}s you want to delete, and then 
click **Delete**.
1. When prompted, click **Delete** to confirm that you want delete it.

## <a name="remove-linux"></a>Remove {{ vsat }} from the Linux server

After deleting your {{vsat}}s in {{vs}}, remember to remove the {{vsat}}
binaries from the Linux servers where they are installed. You can remove the
binaries using the following command:

 ```bash
 ./vsatctl uninstall
 ```
