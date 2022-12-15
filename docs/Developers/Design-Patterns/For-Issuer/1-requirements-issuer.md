# Requirements and Considerations

When developing Ingress solutions for the {{midcp}}, you should always build with the goal of certification in mind.

{% include '.admonitions/tlspk_certification-admonition.md' %}

## Minimum Requirements 

- The solution must automate the production of *any* {{mid}} required to enforce the security of workloads.
- The solution will expect cert-manager to hand CertificateRequest objects to it and be able to, directly or indirectly, produce a {{mid}}.

!!! tip "Focus on UX"

    **The best solutions will require little, if any, human interaction after initial configuration.**

## Security Considerations

The extent of your security considerations is somewhat governed by the intention of your Issuer.

As the developer of an Issuer solution, you will need to determine if your underlying Certificate Authority (CA) could be required to secure internet traffic or not.
Internal traffic could be deemed to be secure when plain-text communication is eliminated, which is easier to ensure.
The requirements for securing internet traffic are likely higher, since your responsibility now extends to cover concerns such as identity and attestation (e.g. "is this domain owner really who they say they are?")

To clarify, you will discover the additional security requirements mean it's much easier to build a self-signed Issuer than an Issuer for something like [Let's Encrypt](https://letsencrypt.org/).

## Building a Better User Experience

TODO

## Success Stories

TODO
