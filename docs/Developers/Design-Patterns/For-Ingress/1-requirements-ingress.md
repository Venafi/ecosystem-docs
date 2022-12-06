# Requirements and Considerations

When developing Ingress solutions for the {{midcp}}, you should always build with the goal of certification in mind.

<!-- Cannot include the following adminition as it relates to TLS Protect Cloud alone -->
<!-- {% include '.admonitions/tlspc_certification-admonition.md' %} -->

## Minimum Requirements 

- The solution must automate the delivery of *any* necessary {{mid}} required to enforce the security of applications protected by the Ingress Controller.
- The system must always stay alert to both the creation and renewal of {{mids}}.
- The solution must perform any necessary updates or reconfigurations to bindings/associations attached to the {{mid}}.
<!-- - The solution must report all installed location(s) of the {{mids}} involved in the automation. -->
<!-- ^^^ this one's odd because it's really a feature of JSS rather than the ingress controller -->

!!! tip "Focus on UX"

    **The best solutions will require little, if any, human interaction after initial configuration.**

## Security Considerations

The Kubernetes Ingress specification provides for per-rule TLS directives but they are optional.
That's great for flexibility but, in light of the {{midcp}} and the modern browser's attitude towards security, security should be uppermost among your concerns.

As the developer on a Ingress Controller solution, you should:

- by default, only support Ingress rules with explicit provision for TLS.
- provide full support for modern OpenID Connect Identity Providers (e.g. Auth0, GitHub, Google, Okta, etc.)
    
## Building a Better User Experience

TODO


<!-- Key to a good user experience -->
