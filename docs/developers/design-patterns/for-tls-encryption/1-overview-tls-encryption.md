# TLS Termination

**The backbone of modern secure communications.**

## Introduction

Before you begin, it's important to understand the "whats" and "whys" of TLS Termination. 

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


## Requirements and Considerations



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

- INSERT BLOG HERE

### Success Stories

Existing solutions that fit within this pattern:

=== "Venafi Marketplace"
    - [Apache HTTP Server](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d)
    - [NGINX](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/629018cb220a43b0c9a48868)
    - [F5 BIG-IP](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/620eeb25d419fb06a5c5bd57)
    - [Citrix ADC](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6297c2b57550f2ee553cf27d)

=== "Elsewhere"