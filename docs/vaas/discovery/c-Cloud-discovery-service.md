# Overview: certificate discovery

Where are the machines located that you want to protect? Are they inside 
of your organization's firewall (private), or are they out on the Internet 
(public-facing)?

Because server certificates are used both within private networks and out on 
the Internet, discovering and managing them requires a secure and 
flexible approach called *discovery services*.

There are three types of discovery services: *Basic*, *Enhanced*, and *Internet*.

Which service you choose depends on your needs.

- **Basic Discovery** is a great option if you want to simply perform a quick certificate discovery inside your company's network that doesn't include automated validation.
    
    This discovery service type works together with Venafi's Scanafi utility to let you run manual discoveries. See [Discovering private (internal) certificates](c-Cloud-Discovering-Private-Internal-certificates.md).

- **Enhanced Discovery** searches for certificates inside of your company's network according to a schedule (optional), and validates discovered certificates automatically.
    
    This discovery service uses {{ven}} {{vsat}} to run certificate discoveries according to a fixed schedule (optional) and performs validation for you (after they are added to the certificates inventory). This service is included in {{ vs }} premium packages by default. See [Discover private (internal) certificates](c-Cloud-Discovering-Private-Internal-certificates.md).

- **Internet Discovery** is a great option if you want to discover and protect certificates **external** to your company's private network.

    This service is created for you by default. But of course you can edit its name, add or remove targets, and change its discovery schedule. See [Discover public (external) certificates](t-Cloud-domain-external.md).

Following certificate discovery, {{ vs }} adds all discovered certificates to the 
certificates inventory (**Inventory** > **Certificates**). After the certificates 
are in the inventory, {{ vs }} can run daily validations on them and highlights 
potential issues that could cause outages.

<!-- DW: the following content is an example of something we should NOT document; let users 
discover and use. Commenting out for now...

## Changing what you see on the Services page

You can access the Services page by clicking **Discovery** on the main {{vs}}
menu bar. There are two views available. Use the toggle button in the top-right corner
to switch between grid and master detail views.

![Toggle button set to master detail view](img/ss-Services-Toggle-List-DetailsView.jpg)

### Grid view

This is the default view, and it provides a consolidated list of all the Services you
have configured. At a glance, you can view details about your Services.

### Master detail view

The master detail view opens a pane that provides more information about the service and the
ability to edit the service. With the detail view open, click any service in the 
left pane, and the details about that service open in the right pane. -->


<!-- OLD CONTENT TO BE PILLAGED AND THEN THE REMAINS DESTROYED...

## Setting up External discovery service

Discovery of external certificates is performed automatically when you add **targets** to be scanned. 
You can set the schedule on when the discovery scans should run on the targets. You can also disable
the service entirely if you don't need it.

!!! tip "What is a target?"
    A target represents a specific endpoint or set of endpoints that you want {{ vs }} to run certificate
    discovery on. They can be entered as either domains, FQDNs, IP addresses, or IP address ranges. For
    external discovery, these should be endpoints outside your firewall.

1. In the menu bar, click **Infrastructure** > **Services**.

1. If you're in the grid view, click the master detail view button ![Picture of master detail 
1. view button](../../assets/images/Icons/Icon_cert_list_switcher.png)
near the top right to switch to the master detail view.

1. Click **External discovery service** in the left pane. The service details open on the
right.

### <a name="disco-Schedule"></a>Setting the discovery schedule

In the **Schedule** tab, select whether you want the service enabled or disabled. 
If the service is enabled, you can schedule when you want the service to run.

!!! note
    This schedule also determines when validation on certificates will be run.

### Specifying the targets and ports to scan

In the **Targets** tab, you can specify which external endpoints you want scanned.

**To add new targets**

In the **Targets** field, enter the new targets that you want scanned. The field
accepts the following:

- Domain names
- FQDNs
- IP addresses
- IP address ranges

!!! tip "Tip"
    If you have a large number of targets, you can upload a CSV file using the 
    **Upload / Import** link.

After you've entered the targets, click outside the **Targets** box, and then click **Add**. Your
targets are added to the Target list.

**To remove existing targets**

If you have existing targets in the list that you no longer want scanned, 
click the **Remove target** icon ![Picture of remove target button](../../assets/images/Icons/Icon_remove_target.png) 
on the right side of the target's row.

**To rename the External discovery service**

In the **Administration** tab, enter a new name in the **Service name** field.

After you've updated the External discovery service, click **Save** to save your changes.

-->
