# Requirements and Considerations

When developing **Issuer** solutions for the {{midcp}}, you should always build with the goal of certification in mind.

<!-- TODO How more adoption vs. just cert-manager? Possibly not here but will need to be answered. -->
{% include '.admonitions/tlspk_certification-admonition.md' %}

## Minimum Requirements 

<!-- TODO What are the requirements of an Issuer? What are the minimal requirements and what are optional/preferred/preferential? What are performance, environment or other requirements? How should the Issuer be packaged? -->
- The solution must automate the production of {{mids}} from the associated provider to enforce the security of workloads.
- The solution will expect cert-manager to hand CertificateRequest objects to it and be able to, directly or indirectly, produce a {{mid}}.

<!-- TODO Is UX ever in consideration? Is it more maintenance? What UX or considerations are for TLS Protect for Kubernetes? -->
!!! tip "Focus on UX"

    **The best solutions will require little, if any, human interaction after initial configuration.**

## Security Considerations

The extent of your security considerations is somewhat governed by the intention of your Issuer.

<!--  TODO How does this relate to the security considerations in developing the Issuer? How is authentication and secrets to be handled with the Issuer? -->
As the developer of an Issuer solution, you will need to determine if your underlying Certificate Authority (CA) could be required to secure internet traffic or not.
Internal traffic could be deemed to be secure when plain-text communication is eliminated, which is easier to ensure.
The requirements for securing internet traffic are likely higher, since your responsibility now extends to cover concerns such as identity and attestation (e.g. "is this domain owner really who they say they are?")

<!-- TODO This is confusing. What addition security requirements and if I'm a developer it's unlikely I'm building new for Let's Encrypt. -->
To clarify, you will discover the additional security requirements mean it's much easier to build a self-signed Issuer than an Issuer for something like [Let's Encrypt](https://letsencrypt.org/).

## Building a Better User Experience

The user experience should be as painless as possible and the expectation is that your solution should be:

<!-- TODO Documentation is important and especially so for certification. What are the Requirements? -->
- Easy to install, preferably via [Helm](https://helm.sh/)
- Able to deploy an MVP into your cluster with little or no configuration requirements
- Provide comprehensive [logs](https://kubernetes.io/docs/concepts/cluster-administration/logging/) and metrics for diagnostic purposes
- Provide complete/appropriate documentation online and via CRDs

Conforming to the these requirements will **greatly** enhance the user experience, providing additional value to teams and organizations.

## Success Stories

Existing solutions that fit within this pattern:

=== "Community"
    - The [cert-manager community](https://cert-manager.io/docs/configuration/external/) provides a collection of open-source External Issuers enabling distribution of {{mids}} from providers including AWS, Google and Cloudflare.

=== "Proprietary"
    - The [venafi-enhanced-issuer](https://platform.jetstack.io/documentation/reference/venafi-enhanced-issuer) is provided with {{tlspk}} to meet the needs of enterprise customer.
