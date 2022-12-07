# Requirements and Considerations

When developing solutions for the {{midcp}}, you should always build with the goal of certification in mind.

{% include '.admonitions/tlspc_certification-admonition.md' %}

## Minimum Requirements 

- The solution must automate the delivery of *any* necessary certificate(s) required for the security of applications managed by the management layer.
- The solution must perform any necessary updates to any bindings/configurations/associations attached to the {{mid}}.
- The solution must report back to the {{midcp}} all installed location(s) of the {{mids}} involved in the automation.
- If possible, the {{midcp}} must be able to continuously validate any {{mid}} is installed at any previously known location(s).

!!! tip "Focus on UX"

    **The best solutions will require as little, if any, human interaction as possible after initial configuration.**

## Security Considerations

- The solution should be developed with standard security best practices in mind.
- The solution should make no attempts to harvest user data.
- Effective data validation should be implemented to catch errors.
    - Values should be checked before being passed to functions in code.
    - Values should be checked before being passed to Venafi or target product/platform/service.
    
## Building a Better User Experience

We understand that every target product is different and some functionality may not be supported.
The following additional requirements **greatly** enhance the user experience, provide additional value to teams and organizations and should be implemented if at all possible. 

- Renewal of any existing {{mids}} in use would be transparent to end users and not cause any downtime.
- Provide the ability to import existing {{mids}} in use by the WAF to Venafi for comprehensive visibility and rapid onboarding.

## Primers
We think you'll find the following references helpful when developing your solution.

If you've found other articles or tools that you think should be included here, [please let us know](mailto:ecosystem@venafi.com?subject=ecosystem.venafi.com Feedback - Cloud WAF: Overview)!

**TO-DO**

## Success Stories

Existing solutions that fit this use case:

=== "Venafi Marketplace"
    - [F5 BIG-IQ](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/620d4f3fd419fb06a5c5bd48)
    - [Citrix ADM](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6297c40d7550f2ee553cf27e)
    - [Device Authority KeyScaler](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/629430e57550f2ee553cf23a)
    - [IBM Guardium](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/629961657550f2ee553cf28c)

=== "Elsewhere"
    - [Fortinet FortiManager](https://www.fortinet.com/products/management/fortimanager)
    - [Palo Alto Panorama](https://www.paloaltonetworks.com/network-security/panorama)
    - [Juniper MCM](https://www.juniper.net/documentation/us/en/software/jatp/jatp-quickstart/topics/concept/jatp-manager-of-central-managers-mcm.html)