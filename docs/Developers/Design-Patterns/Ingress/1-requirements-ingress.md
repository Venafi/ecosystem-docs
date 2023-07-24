# Requirements and Considerations

When developing **Ingress** solutions for the {{midcp}}, you should always build with the goal of certification in mind.

{% include '.admonitions/tlspk_certification-admonition.md' %}

## Minimum Requirements 

- The solution must automate the delivery/consumption of *any* {{mid}} required to enforce the security of workloads protected by the Ingress Controller.
- The solution must cope with both the creation and renewal of {{mids}}.
- The solution must perform any necessary updates or reconfigurations to bindings/associations attached to the {{mid}}.
- The solution must source its {{mids}} from Kubernetes secrets.

Some clarifying remarks on the final point.
The use of TLS secrets is commonplace for persisting X.509 certificates but organizations have been known to restrict or even prohibit their use.
The Ingress specification mandates the use of secrets when you wish to entrust your Ingress Controller with the task of TLS termination.
If this conflicts with your internal policies then the use of Ingress **for TLS termination** is not an option and you should consider something like the [cert-manager csi-driver](https://cert-manager.io/docs/projects/csi-driver/){: target="_blank" }.
The csi-driver solution, which is commonly used to enforce [mTLS](https://en.wikipedia.org/wiki/Mutual_authentication#mTLS){: target="_blank" } between workloads, eliminates the use of secrets and necessitates TLS termination closer to your workloads.

!!! tip "Focus on UX"

    **The best solutions will require little, if any, human interaction after initial configuration.**

## Security Considerations

The Kubernetes Ingress specification provides for TLS enforcement on a per routing rule basis, but this security feature is **optional**.
This is somewhat regrettable in light of the modern browser security requirements and your pursuit of zero-trust by default.
Security should be uppermost among your concerns.

As the developer of a Ingress Controller solution, you will need to:

- support only Ingress rules with explicit provision for TLS (by default).
- provide full support for modern OpenID Connect Identity Providers (e.g. Auth0, GitHub, Google, Okta, etc.)

These considerations are in addition to any policy enforcement (e.g. minimum cipher strength) applied by [TLSPK's approver-policy-enterprise](https://platform.jetstack.io/documentation/configuration/approver-policy-enterprise){: target="_blank" }, the [Venafi TLS Protect](https://venafi.com/tls-protect/){: target="_blank" } products or upstream Certificate Authorities.

## Building a Better User Experience

The user experience should be as painless as possible and the expectation is that your target product should:

- Be easy to install, preferably via [Helm](https://helm.sh/){: target="_blank" }
- Be [highly available](https://en.wikipedia.org/wiki/High_availability){: target="_blank" } 
- Enable the user to deploy an MVP into your cluster with little or no configuration requirements
- Provide comprehensive [logs](https://kubernetes.io/docs/concepts/cluster-administration/logging/){: target="_blank" } for diagnostic purposes
- Export metrics in the common [Prometheus](https://prometheus.io/){: target="_blank" } format (e.g. network traffic, latency, error rates, utilization, request counts)
- Provide complete/appropriate documentation, both online and within [CRDs](https://kubernetes.io/docs/concepts/extend-kubernetes/api-extension/custom-resources/){: target="_blank" } when applicable

Conforming to the these requirements will **greatly** enhance the user experience, providing additional value to teams and organizations.

<!-- Primers section was moved to Getting Started in the next chapter-->

## Success Stories

Existing solutions that fit within this pattern:

=== "Venafi Marketplace"
    - [NGINX Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d){: target="_blank" }
    - [Pomerium Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/628cf590220a43b0c9a48842){: target="_blank" }

=== "Elsewhere"
    - [Kubernetes community](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/){: target="_blank" }

<!-- ##### Questions to guide us:

- What are the absolute **required capabilities**? (MVP)
    1. Ability to use a {{mid}}, an X.509 Certificate in this case, to secure traffic
    1. Ability to install/deploy/upload a {{mid}} to a 
    1. Ability to **validate** that a specific {{mid}} is where we think it is (data either proactively requested by Venafi or periodically reported on by the target consumer of the {{mid}})

- What sets the best solutions apart?
    {% include 'best-solutions-common.md' %}
    - Renewal of a {{mid}} should not cause downtime -->
