#  Cloud WAF

**Web Application Firewalls (WAFs) help protect web applications by monitoring and filtering traffic between the app and the internet.**

---

## Introduction

Organizations use {{mids}} to secure traffic to and from their workloads using Transport Layer Security (TLS) with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint, itself (i.e. source code). 
Other times, they may be installed on a load balancer, proxy or, in this case, a Cloud WAF.

!!! abstract "Design Pattern: Cloud WAF"

    This design pattern focuses on the use case of orchestrating the delivery of {{mids}} to the WAF, as well as automating any configuration necessary to *activate* or *associate* those {{mids}} to target applications being secured by the WAF.

Before you begin, it's important to understand the "whats" and "whys" of *Cloud WAFs*. 

## What is it?

A WAF is a type of reverse proxy which protects the application itself from vulnerabilities caused by malicious activity.
WAFs use {{mids}} in one of two ways:

- Securing traffic to the admin interface of the WAF itself
- Securing traffic to the applications being managed by the WAF

### USE CASE 1: Securing traffic to the admin interface of the WAF itself

While WAFs don't typically protect the traffic to their own administration interfaces in the same way they do for managed applications, ensuring that administrator traffic is encrypted with an enterprise-trusted {{mid}} is just as important.
If that traffic is not secured, admin credentials are at risk of leaking.
If operations involving the {{mid}} are not automated, admins can experience outages when logging in to make changes.
This could potentially present a cascading effect if they are investigating an ongoing threat or mitigating an issue.

### USE CASE 2: Securing traffic to the applications being managed by the WAF

Securing traffic to applications is slightly more complex since there can be multiple applications being managed by a WAF, and each application needs its own {{mid}}.
There are typically two options for {{mid}} automation targeting application traffic.
Which option you choose will depend on the WAF product or service your solution is being built for.

#### The WAF has a built-in Certificate Authority (CA)

In this scenario, the WAF terminates the original TLS connection, and uses its built-in CA to issue new {{mids}} for traffic between the WAF and the application.
Some next-gen WAFs can generate {{mids}} at [just-in-time](https://www.ssh.com/academy/iam/just-in-time-access){: target="_blank" } speed.
It's critical that every {{mid}} is trusted by the organization, and every issuance is known and traceable by the {{midcp}}. 

#### The WAF stores a copy of the {{mid}} (including the private key) for each app

In this scenario, the WAF maintains a copy of the {{mid}} for each application under management.
When a {{mid}} is renewed, both the application and the WAF will need the new version.

## Why is {{mid}} automation necessary?

Proper management of these {{mids}} is critical to the availability and security of the applications being managed by the WAF.
When active {{mids}} expire or become unavailable, outages happen.

{% include '.admonitions/outages-admonition.md' %}

These types of outages can occur for a variety of reasons, including human error or oversight, unnecessary bottlenecks during approval workflows or a general **lack of automation**.

In addition to {{mids}} for each application, the solution must be capable of storing and using any additional configuration information and metadata required by the WAF to use the {{mid}} once it is provisioned.
This introduces another failure point, and another potential <span class="outage">**outage**</span> to be aware of.

{% include 'value-drivers/vd-intro.md' %}

{% include 'value-drivers/vd-full.md' %}