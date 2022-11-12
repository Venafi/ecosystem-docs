# Requirements and Considerations

When developing solutions for the {{midcp}}, you should always build with the goal of certification in mind.

{% include '.admonitions/tlspc_certification-admonition.md' %}

## Minimum Requirements 

- The solution must automate the delivery of *any* necessary certificate(s) required for the security of applications managed by the WAF.
- The solution must perform any necessary updates to any bindings/configurations/associations attached to the {{mid}}.
- The solution must report all installed location(s) of the {{mids}} involved in the automation.
- The {{midcp}} must be able to continuously validate any {{mid}} is installed at any previously known location(s).

!!! tip "Focus on UX"

    **The best solutions will require as little, if any, human interaction as possible after initial configuration.**

## Security Considerations

.TODO
    
## Building a Better User Experience

We understand that every target product is different and some functionality may not be supported.
The following additional requirements **greatly** enhance the user experience, provide additional value to teams and organizations and should be implemented if at all possible. 

- Renewal of any existing {{mids}} in use would not cause any downtime.
- Provide the ability to import existing {{mids}} in use by the WAF to Venafi for comprehensive visibility and rapid onboarding.

## Primers
We think you'll find the following references helpful when developing your solution.

If you've found other articles or tools that you think should be included here, [please let us know](mailto:ecosystem@venafi.com?subject=ecosystem.venafi.com Feedback - Cloud WAF: Overview)!

- [WAF](https://en.wikipedia.org/wiki/Web_application_firewall) - Wikipedia
- [What is WAF](https://www.youtube.com/watch?v=p8CQcF_9280) - YouTube

## Success Stories

Existing solutions that fit this use case:

=== "Venafi Marketplace"
    - [Imperva](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/62a34b3e7550f2ee553cf2d1)

=== "Elsewhere"
    - [Radware](https://www.radware.com/products/cloud-waf-service/)