#  Ingress

TODO bring in local updates from ~/src/zzz-20221102-venafi-ecosystem

<!-- We can justify the inclusion of "ingress" because ingress is a known entity in JSS. -->

**A Kubernetes object that manages external access to the services in a cluster.**
**Ingress may provide load balancing, TLS termination and intelligent routing.**

## Introduction

Before you begin, it's important to understand the "whats" and "whys" of *Ingress* and *Ingress Controllers*. 

Kubernetes is is considered to be a [platform for building platforms](https://twitter.com/kelseyhightower/status/935252923721793536?lang=en-GB).
As such, it has a reduced set of opinions about how business demands can be met.
This creates voids which the Kuberenetes community rushes in to fill.
One such area is ingress controllers, for which the community has provided [many options](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/).

### What is it?

Organizations use {{mids}} to secure traffic to and from their workloads using Transport Layer Security (TLS), with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint itself (i.e. the container image). 
Other times, they may be installed on a load balancer or proxy.
Regardless of the location, proper management of that {{mid}} is critical to the availability and security of the workload.
When active {{mids}} expire or become unavailable, **outages** happen.

{% include '.admonitions/outages-admonition.md' %}

This design pattern focuses on the use case of orchestrating the delivery of {{mids}} to location(s) where they'll be used, as well as automating any configuration necessary to *activate* or *associate* them with target applications.
**The best solutions will require as little, if any at all, human interaction as possible after initial configuration.**

### Why is it necessary?

The internet was originally envisioned as a medium for sharing information, however the modern world demands that access to information should be much better protected.
To meet these demands we have seen the steady rise of HTTPS to the point where [modern browsers baulk at the use of plain old HTTP](https://security.googleblog.com/2019/10/no-more-mixed-messages-about-https_3.html).
So TLS is now a mandatory requirement and, henceforth, we all need to concern ourselves with the need for security of data in transit.

There is a strong argument to suggest that developers should keep [non-functional requirements](https://en.wikipedia.org/wiki/Non-functional_requirement#Examples) such a data security outside their codebase.
One of the benefits of placing a proxy, such as those under the control of an ingress controller, between your workload and the world beyond is that developers can isolate important aspects of software delivery and focus solely on business requirements.

## Considerations

TODO ...

<!-- TODO: the cross-cutting concern of TLS, where should my certificates go? -->

<!-- ##### Questions to guide us:

- What are the absolute **required capabilities**? (MVP)
    1. Ability to use a {{mid}}, an X.509 Certificate in this case, to secure traffic
    1. Ability to install/deploy/upload a {{mid}} to a 
    1. Ability to **validate** that a specific {{mid}} is where we think it is (data either proactively requested by Venafi or periodically reported on by the target consumer of the {{mid}})

- What sets the best solutions apart?
    {% include 'best-solutions-common.md' %}
    - Renewal of a {{mid}} should not cause downtime -->

### Primers
We think you'll find the following references helpful when developing your solution. 
*If you've found other articles or tools that you think should be included here, please let us know!**
<!-- .to-do: insert a way for users to let us know. Maybe a simple mailto: link will work for now, or do we suggest they update the page themselves and make a pull request? -->

#### Relevant Reading

- [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)

### Success Stories

Existing solutions that fit within this pattern:

=== "Venafi Marketplace"
    - [NGINX Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d)
    - [Pomerium Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/628cf590220a43b0c9a48842)

=== "Elsewhere"
    - [Kubernetes community](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/)