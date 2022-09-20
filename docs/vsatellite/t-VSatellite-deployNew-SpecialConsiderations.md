# Installing VSatellites on RHEL

If you plan to install {{vsat}}s on Red Hat Enterprise Linux (RHEL), carefully review the following information.

## Special considerations

If you plan to install {{vsat}} on RHEL using the <code>--venafi-registry</code> flag, please install Rancher's Security-Enhanced Linux (SELinux) RPM. 

For more information about Rancher SELinux, visit https://rancher.com/docs/rancher/v2.5/en/security/selinux/.

### Set up the yum repo

To install k3s-selinux directly on all hosts in the cluster, set up the yum repo.

But first, verify the following:

- You have a valid RedHat subscription 
- RHEL has the container-selinux package installed (i.e. yum list container-selinux)
- Check <code>yum repolist all</code>
- container-selinux is available on RHEL through a separate repo (which must be enabled)
- <code>subscription-manager repos --enable=rhel-7-server-extras-rpms</code> 
    - Assumes that RHEL distro is registered through subscription-manager - https://access.redhat.com/solutions/253273
    - in case you don' have RedHat subscription details and still like to manually install container-selinux (not recommended)
        - sudo yum install -y http://mirror.centos.org/centos/7/extras/x86_64/Packages/container-selinux-2.119.2-1.911c772.el7_8.noarch.rpm

### RHEL 7.x

For RHEL 7.x, run the following scripts:

```
# cat << EOF > /etc/yum.repos.d/rancher-k3s-common.repo
[rancher-k3s-common-stable]
name=Rancher K3s Common (stable)
baseurl=https://rpm.rancher.io/k3s/stable/common/centos/7/noarch
enabled=1
gpgcheck=1
gpgkey=https://rpm.rancher.io/public.key
EOF
```

### RHEL 8.x

For RHEL 8.x, run the following scripts:

```
# cat << EOF > /etc/yum.repos.d/rancher-k3s-common.repo
[rancher-k3s-common-stable]
name=Rancher K3s Common (stable)
baseurl=https://rpm.rancher.io/k3s/stable/common/centos/8/noarch
enabled=1
gpgcheck=1
gpgkey=https://rpm.rancher.io/public.key
EOF
```

### Installing the RPM

To install the RPM, run the following:

<code>yum -y install k3s-selinux container-selinux</code>

## Proxy server considerations

If you plan to use a proxy, you must set the following environment variables:

    http_proxy / HTTP_PROXY
    https_proxy / HTTPS_PROXY
    no_proxy / NO_PROXY

!!! tip "Tip" 
    We suggest you use lowercase *http_proxy* rather than uppercase (*HTTP_PROXY*).

So before you install {{vsat}}, set these environment variables:

- <code>export http_proxy=*IP_OF_ PROXY_SERVER*:*PROXY_SERVER_PORT*</code>
- <code>export https_proxy=*IP_OF_ PROXY_SERVER*:*PROXY_SERVER_PORT*</code>
- (Optional) <code>export no_proxy=*localhost,127.0.0.0/8,0.0.0.0,10.0.0.0/8,192.168.0.0/16,172.16.0.0/12*</code>
    - Modify IP ranges, as needed.
    - *no_proxy* is a comma- or space-separated list of computer
or domain names, with an optional *:port*.  If you don't include *:port*, then it applies to all ports on that domain.

!!! tip "TIP"
    If you see a *refused connection* error while downloading {{vsat}} artifacts, make sure that you've not used mixed cases, such as specifying uppercase HTTP_PROXY (or HTTP_PROXY) with a lowercase http_proxy (or https_proxy).

## Next steps

- [Learn how to manage your installed {{vsat}}s](t-VSatellite-managing.md)
- [Rename a {{vsat}}](renaming-a-vsatellite.md)
- [View your current list of {{vsat}}s](t-VSatellite-monitoring.md)
- [Troubleshooting {{vsat}} connection issues](../_FAQ-Troubleshooting/Troubleshooting.md)
- [Delete a {{vsat}}](t-VSatellite-delete.md)
