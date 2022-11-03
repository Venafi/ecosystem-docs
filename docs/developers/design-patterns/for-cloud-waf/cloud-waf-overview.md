#  Cloud WAF

**Web Application Firewalls (WAFs) help protect web applications by monitoring and filtering traffic between the app and the internet.**

## Introduction

Organizations use {{mids}} to secure traffic to and from their workloads using Transport Layer Security (TLS) with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint, itself (i.e. source code). 
Other times, they may be installed on a load balancer, proxy or, in this case, a Cloud WAF.

Before you begin, it's important to understand the "whats" and "whys" of *Cloud WAFs*. 

### What is it?

A WAF is a type of reverse proxy which protects the application itself from vulnerabilities caused by malicious activity.
WAFs use {{mids}} in one of two ways:

- Securing traffic to the admin interface of the WAF itself
- Securing traffic to the applications being managed by the WAF

Regardless of the purpose, proper management of those {{mids}} are critical to the availability and security of the workload.
When active {{mids}} expire or become unavailable, outages happen.

{% include '.admonitions/outages-admonition.md' %}

#### Securing traffic to the admin interface of the WAF itself

While WAFs don't typically protect the traffic to their own administration interfaces in the same way they do for managed applications, ensuring that administrator traffic is encrypted with an enterprise-trusted {{mid}} is just as important.
If that traffic is not secured, admin credentials are at risk of leaking.
If operations involving the {{mid}} are not automated, admins can experience outages when logging in to make changes.
This could potentially present a cascading effect if they are investigating an ongoing threat or mitigating an issue.

#### Securing traffic to the applications being managed by the WAF



This design pattern focuses on the use case of orchestrating the delivery of {{mids}} to the WAF, as well as automating any configuration necessary to *activate* or *associate* those {{mids}} to target applications being secured by the WAF.

**The best solutions will require as little, if any at all, human interaction as possible after initial configuration.**


### Why is {{mid}} automation necessary?


## Requirements and Considerations



<!-- ##### Questions to guide us:

- What are the absolute **required capabilities**? (MVP)
    1. Ability to use a {{mid}}, an X.509 Certificate in this case, to secure traffic
    1. Ability to install/deploy/upload a {{mid}} to a 
    1. Ability to **validate** that a specific {{mid}} is where we think it is (data either proactively requested by Venafi or periodically reported on by the target consumer of the {{mid}})

- What sets the best solutions apart?
    {% include 'best-solutions-common.md' %}
    - Renewal of a {{mid}} should not cause downtime -->



## Primers
We think you'll find the following references helpful when developing your solution. 
*If you've found other articles or tools that you think should be included here, please let us know!**
<!-- .to-do: insert a way for users to let us know. Maybe a simple mailto: link will work for now, or do we suggest they update the page themselves and make a pull request? -->

- [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)

## Success Stories

Existing solutions that fit within this pattern:

=== "Venafi Marketplace"
    - [NGINX Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d)
    - [Pomerium Ingress](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/628cf590220a43b0c9a48842)

=== "Elsewhere"