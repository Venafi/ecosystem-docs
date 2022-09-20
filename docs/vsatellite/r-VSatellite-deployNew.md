# Pre-requisites before deploying VSatellites

In order to get a {{vsat}} connected to your {{vs}} account, you'll need to
download and run a binary setup utility on a Linux server within your target
network.

If you plan to install on Red Hat Enterprise Linux (RHEL), carefully [review these special considerations](t-VSatellite-deployNew-SpecialConsiderations.md).

??? optional-css-class "Who can create {{vsat}}s?"
    {{vs}} enables multiple user roles (such as PKI Administrators and System Administrators) to install {{vsat}}s and pair them with your {{vs}} account. This is by design since using {{vsat}}s enables users assigned varying roles the ability to discover and manage certificates found behind your firewall.

## Pre-requisites for installing {{vsat}}s 

Before you install a {{vsat}}, carefully review the following important pre-requisites.

### System requirements

Make sure that the target computer where you plan to install {{vsat}} meets the minimum requirements.

### Operating systems

- Supported:
	- {% include 'vsat/sn-vsat-supported-ubuntu.md' %}
	- {% include 'vsat/sn-vsat-supported-redhat.md' %}

!!! note "RECOMMENDED"
	Make sure that the operating system you use is updated with the latest patches. At a minimum, it must be able to retrieve updates from the operating system's standard software repository (for example, using `apt-get` or `yum`).

### System resources

You can install {{vsat}}s on either virtual computers (most common) or on
physical hardware. In either case, your target computer must meet or exceed the following:

- {% include 'vsat/sn-vsat-req-ram.md' %}
- {% include 'vsat/sn-vsat-req-cpu.md' %}
- {% include 'vsat/sn-vsat-req-disk.md' %}

### Networking connections

{{vsat}} requires connectivity with specific endpoints and ports over HTTPS. Which endpoints are required depends on whether you use the <code>--venafi-registry</code> flag when running the {{vsat}} install.

The <code>--venafi-registry</code> flag better secures and simplifies the installation of {{vsat}} by using only Venafi-hosted {{vsat}} artifacts.

??? optional-css-class "Required endpoints when using the <code>--venafi-registry</code> flag"
    - dl.venafi.cloud:443
    - registry.venafi.cloud:443
    - vsat-gw.venafi.cloud:9443
    - vsat-gw.venafi.cloud:443
    - vsat-login.venafi.cloud:443
    - rpm.rancher.io:443 (this applies ONLY when using RHEL on your target computer; see *special considerations* section below)

??? optional-css-class "Required endpoints when *not* using the <code>--venafi-registry</code> flag"

    - {{vs}} endpoints:
        - dl.venafi.cloud:443
        - vsat-gw.venafi.cloud:9443
        - vsat-gw.venafi.cloud:443
        - vsat-login.venafi.cloud:443

    - Third-party endpoints:
        - auth.docker.io:443
        - cdn02.quay.io:443
        - d2glxqk2uabbnd.cloudfront.net:443
        - github.com:443
        - objects.githubusercontent.com:443
        - production.cloudflare.docker.com:443
        - public.ecr.aws:443
        - quay.io:443
        - quayio-production-s3.s3.amazonaws.com:443
        - registry-1.docker.io:443
        - rpm.rancher.io:443 (applicable only when using RHEL on your target computer)

??? optional-css-class "**TIP:**  Verifying connectivity to required endpoints"
    To quickly verify connectivity to the required endpoints, you could use the cURL utility to request headers from each base URL. For example:

        curl -I https://dl.venafi.cloud        
        curl -I https://vsat-gw.venafi.cloud

    If you don't have cURL, you can install it on Ubuntu using `apt-get install curl` or on RHEL using `yum install curl`.

## Next steps

- [Deploy a new VSatellite](t-VSatellite-deployNew.md)
- If you're deploying to RHEL, carefully [review special considerations here](t-VSatellite-deployNew-SpecialConsiderations.md)
- [Learn how to manage your installed {{vsat}}s](t-VSatellite-managing.md)
- [Rename a {{vsat}}](renaming-a-vsatellite.md)
- [View your current list of {{vsat}}s](t-VSatellite-monitoring.md)
- [Troubleshooting {{vsat}} connection issues](../_FAQ-Troubleshooting/Troubleshooting.md)
- [Delete a {{vsat}}](t-VSatellite-delete.md)
