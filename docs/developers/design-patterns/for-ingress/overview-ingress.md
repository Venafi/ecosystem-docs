#  Ingress

<!-- **Ingress controllers are specialized load balancers for Kubernetes and other containerized environments.** -->

<!-- We can justify the inclusion of "ingress" because ingress is a known entity in JSS. -->

**An Kubernetes object that manages external access to the services in a cluster.**
**Ingress may provide load balancing, TLS termination and intelligent routing.**

## Introduction

Before you begin, it's important to understand the "whats" and "whys" of *Ingress* and *Ingress Controllers*. 

### What is it?

Organizations use {{mids}} to secure traffic to and from their workloads using Transport Layer Security (TLS) with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint, itself (i.e. source code). 
Other times, they may be installed on a load balancer or proxy.
Regardless of the location, proper management of that {{mid}} is critical to the availability and security of the workload.
When active {{mids}} expire or become unavailable, outages happen.

{% include '.admonitions/outages-admonition.md' %}

This design pattern focuses on the use case of orchestrating the delivery of {{mids}} to location(s) where they'll be used, as well as automating any configuration necessary to *activate* or *associate* them with target applications.
**The best solutions will require as little, if any at all, human interaction as possible after initial configuration.**

### Why is it necessary?


## Considerations



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