<!-- TODO Should the introduction include: Problem you will solve, What you will build, What the outcome will be, How will it be used. Should this also establish an introduction to the benefits of building for TLS Protect for Kubernetes not just cert-manager, and why you'll want to certify? -->
#  Issuer

<!-- TODO Isn't an Issuer a cert-manager capability that allows integration with a certificate issuer (machine identity provider)? It's more than just a term. -->
**Issuer is the term used for a Custom Resource Definition (CRD) in Kubernetes that represents certificate authorities (CAs) able to generate signed certificates by honoring certificate signing requests.**

<!-- TODO Do we want to position issuer as just CRDs? -->
<!-- TODO The audience here are developers at CAs and other machine identity providers. Is it "yours"? -->
<!-- TODO TLS Protect for Kubernetes is introduced here along with cert-manager. There's no context on the purpose of either. -->
The Issuer CRDs are core components of [cert-manager](https://cert-manager.io/), a critical component in the fight to secure your Kubernetes clusters, helping companies <span class="value-drivers">modernize with speed and agility</span>.
{{tlspk}} includes an enterprise-hardened version of cert-manager and capabilities to support {{mids}} in the enterprise.

## Introduction

The chapter on [Ingress](../../For-Ingress/0-intro-ingress) explains how Kubernetes is broadly unopinionated about the tools you use to fulfill your business demands, such as how you ensure the security of your workloads.
The CNCF's move to accept [cert-manager](https://www.cncf.io/blog/2022/10/19/cert-manager-becomes-a-cncf-incubating-project/) as an incubating project solidifies its reputation as the de-facto Kubernetes solution for <span class="value-drivers">stopping outages</span> caused by TLS certificate expiry.

<!-- TODO Who is the 'you[r]'? The developer [who] is building a CA or other machine identity provider. -->
!!! abstract "Design Pattern: Issuer"

    This design pattern focuses on the use case of creation and renewal of {{mids}} via Issuers.
    It highlights the need to <span class="value-drivers">automate everywhere</span> to ensure that once your solution is deployed it stays there, **proactively** securing workloads long into the future.
    
Before you begin, it's important to understand the "what", "why" and "how" of *Issuers* in the context of Kubernetes. 

## What is it?

<!-- TODO Isn't the Issuer most importantly about cert-manager? -->
<!-- TODO What other types of machine identities does cert-manager support for Issuers? -->
An Issuer CRD extends the Kubernetes API, abstracting away the complexity of Certificate Authorities (CAs) inside your clusters.
Each Issuer object represents an **entity** capable of storing, signing, and issuing {{mids}}.
These {{mids}} are typically, but not restricted to, X.509 certificates.
This entity could be a digital security company you already know and trust, a non-profit organization or just some well-known device inside your data center.
Each of these entities present their own strengths, with their use determined by organizational policies, individual choice and the task at hand.
In a Kubernetes architecture which <span class="value-drivers">prevents misuse and compromise</span>, use of a cert-manager Issuer is a mandatory requirement.

## Why is it necessary?

<!-- maybe some history of CAs -->

<!-- keyword: lifecycle automation, attestation -->

<!-- TODO In this case it's needed because the developer from the CA needs to get their machine identities to consumers, right? -->
A range of Issuers are necessary because there is no one-size solution for issuance of {{mids}}.
For example, the fortification of Ingress traffic is typically of greater concern than that of your internal microservices.
Nonetheless, security is a fundamental requirement in both cases.

## How it helps?

<!-- TODO Is this how cert-manager helps, or the Issuer? -->
cert-manager abstracts the different requirements and capabilities of these entities behind an assortment of available Issuer types, meaning the experience of using cert-manager is consistent regardless of your circumstances.

The following diagram is taken from the cert-manager documentation [homepage](https://cert-manager.io/docs/).

![cert-manager issuers](../../../assets/images/cert-manager-issuers.svg)

<!-- TODO Not sure I understand why disconcerting. Is it disconcerting to the developer? Their users? -->
This is great if your chosen Issuer type appears on the above image but disconcerting otherwise.

<!-- TODO There are many developed by Cloudflaire, Amazon, Google, and more -->
Thankfully, the loosely-coupled and extensible nature of cert-manager and Kubernetes enables a solution in the shape of [External Issuers](https://cert-manager.io/docs/configuration/external/) of which there are several already available in the public domain.
