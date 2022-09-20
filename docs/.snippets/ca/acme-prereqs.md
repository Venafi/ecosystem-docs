<!-- Author Note: the {{article}} and {{caname}} variables are defined in the meta
section at the top of each markdown file this snippet is used in. -->

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete the CA configuration.

**DNS provider details**

All ACMEv2 CAs in {{vs}} use DNS Certificate Authority Authorization (CAA).
{{vs}} supports the following DNS providers. Click your DNS provider of choice
to see what information {{vs}} needs.

=== "AWS Route 53"
    - Access Key ID
    - Secret Access Key
    - Hosted Zone ID

=== "Azure"
    - Subscription ID
    - Resource Group
    - Client Secret
    - Client ID
    - Tenant ID

=== "Cloudflare"
    - For email and global API Key authentication type
        - Account email
        - Global API Key
    - For DNS and zone tokens authentication type
        - Edit zone API token
        - Read zone API token

=== "Google Cloud"
    - Service account file

**{{vsat}}**

All ACMEv2 certificate authorities also require a
[{{vsat}}](../../../vsatellite/c-VSatellite-Management-about.md). If you already
have a {{vsat}} installed, it will be available for you to select during
configuration. 

If not, you'll be able to set up a {{vsat}} during configuration. Just be sure
to have a machine ready that meets the [system
requirements](../../../vsatellite/t-VSatellite-deployNew.md) before you start.

</div>