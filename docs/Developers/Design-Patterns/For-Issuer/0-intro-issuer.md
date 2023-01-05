<!-- TODO Should the introduction include: Problem you will solve, What you will build, What the outcome will be, How will it be used. Should this also establish an introduction to the benefits of building for TLS Protect for Kubernetes not just cert-manager, and why you'll want to certify? -->
#  Issuer

**Issuer is a capability of [cert-manager](https://cert-manager.io/) enabling integration with {{mid}} providers. These providers are typically Certificate Authorities which publish digital certificates to secure communication between workloads.**

<!-- TODO TLS Protect for Kubernetes is introduced here along with cert-manager. There's no context on the purpose of either. -->
cert-manager is a critical component in the fight to secure your Kubernetes clusters, helping companies <span class="value-drivers">modernize with speed and agility</span>.
{{tlspk}} includes an enterprise-hardened version of cert-manager alongside extensions to support and manage {{mids}} in the enterprise.

## Introduction

The chapter on [Ingress](../../For-Ingress/0-intro-ingress) explains how Kubernetes is broadly unopinionated about the tools you use to fulfill your business demands, such as how you ensure the security of your workloads.
The CNCF's move to accept [cert-manager](https://www.cncf.io/blog/2022/10/19/cert-manager-becomes-a-cncf-incubating-project/) as an incubating project solidifies its reputation as the de-facto Kubernetes solution for <span class="value-drivers">stopping outages</span> caused by TLS certificate expiry.

<!-- TODO Who is the 'you[r]'? The developer [who] is building a CA or other machine identity provider. -->
!!! abstract "Design Pattern: Issuer"

    This design pattern focuses on the use case of creation and renewal of {{mids}} via Issuers.
    It highlights the need to <span class="value-drivers">automate everywhere</span> to ensure that once your solution is deployed it stays there, **proactively** securing workloads long into the future.
    
Before you begin, it's important to understand the "what", "why" and "how" of *Issuers* in the context of Kubernetes. 

## What is it?

The Issuer capability in cert-manager extends the Kubernetes API, abstracting away the complexity of {{mid}} providers inside your clusters.
Each Issuer object represents an **entity** capable of storing, signing, and issuing {{mids}}.
These {{mids}} are typically X.509 certificates.
This entity could be a digital security company you already know and trust, a non-profit organization or just some well-known device inside your data center.
Each of these entities present their own strengths, with their use determined by organizational policies, individual choice and the task at hand.
In a Kubernetes architecture which <span class="value-drivers">prevents misuse and compromise</span>, use of a cert-manager Issuer is a mandatory requirement.

## Why is it necessary?

The following diagram is taken from the cert-manager documentation [homepage](https://cert-manager.io/docs/).

![cert-manager issuers](../../../assets/images/cert-manager-issuers.svg)

As you can see, native Issuer support is currently limited to the {{mid}} providers shown above.
As a developer who needs to extend the reach of cert-manager to provide support for an alternate {{mid}} provider, this design pattern is for you.
