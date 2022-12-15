# Requirements and Considerations

When developing Ingress solutions for the {{midcp}}, you should always build with the goal of certification in mind.

{% include '.admonitions/tlspk_certification-admonition.md' %}

## Minimum Requirements 

- The solution must automate the delivery/consumption of *any* {{mid}} required to enforce the security of workloads protected by the Ingress Controller.
- The solution must cope with both the creation and renewal of {{mids}}.
- The solution must source its {{mids}} from Kubernetes secrets to ensure the {{midcp}} can track the location of {{mids}} involved in the automation.
- The solution must perform any necessary updates or reconfigurations to bindings/associations attached to the {{mid}}.

!!! tip "Focus on UX"

    **The best solutions will require little, if any, human interaction after initial configuration.**

## Security Considerations

The Kubernetes Ingress specification provides for per-rule TLS directives but they are optional.
That's great for flexibility but regrettable in light of the {{midcp}} and the modern browser's attitude towards security.
Security should be uppermost among your concerns.

As the developer of a Ingress Controller solution, you will need to:

- support only Ingress rules with explicit provision for TLS (by default).
- provide full support for modern OpenID Connect Identity Providers (e.g. Auth0, GitHub, Google, Okta, etc.)
    
## Building a Better User Experience

The user experience should be as painless as possible and the expectation is that your target product should be:

- Easy to install, preferably via [Helm](https://helm.sh/)
- Able to deploy an MVP into your cluster with little or no configuration requirements
- Provide comprehensive [logs](https://kubernetes.io/docs/concepts/cluster-administration/logging/) and metrics for diagnostic purposes
- Provide complete/appropriate documentation online and via CRDs

Conforming to the these requirements will **greatly** enhance the user experience, providing additional value to teams and organizations.

## Primers

We think you'll find the following references helpful when developing your solution. 

If you've found other articles or tools that you think should be included here, [please let us know](mailto:ecosystem@venafi.com?subject=ecosystem.venafi.com feedback - Cloud WAF Overview)!

- [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)
- [Kubernetes Ingress Explained for Beginners](https://www.youtube.com/watch?v=izWCkcJAzBw)

## Success Stories

Existing solutions that fit within this pattern:

=== "Venafi Marketplace"
    - [NGINX Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d)
    - [Pomerium Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/628cf590220a43b0c9a48842)

=== "Elsewhere"
    - [Kubernetes community](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/)

<!-- ##### Questions to guide us:

- What are the absolute **required capabilities**? (MVP)
    1. Ability to use a {{mid}}, an X.509 Certificate in this case, to secure traffic
    1. Ability to install/deploy/upload a {{mid}} to a 
    1. Ability to **validate** that a specific {{mid}} is where we think it is (data either proactively requested by Venafi or periodically reported on by the target consumer of the {{mid}})

- What sets the best solutions apart?
    {% include 'best-solutions-common.md' %}
    - Renewal of a {{mid}} should not cause downtime -->
