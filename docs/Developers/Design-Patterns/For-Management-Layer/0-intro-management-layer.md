#  Management Layer

**In the context of enterprise software applications, "management layer" is a higher-level component that provides centralized control and coordination of the various *other,* lower-level components under its management. It can also be referred to as the orchestration layer, or the management/control plane.**

---

## Introduction

Organizations use {{mids}} to secure traffic to and from their workloads using Transport Layer Security (TLS) with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint, itself (i.e. source code). 
Other times, they may be installed on a load balancer, [cloud WAF](../For-Cloud-WAF/0-intro-cloud-waf.md) or, in this case, a management layer. 

!!! abstract "Design Pattern: Management Layer"

    This design pattern focuses on the use case of adding and/or enhancing functionality of the management layer to be Venafi-aware.
    In this design pattern, **the management layer is responsible for automation of {{mids}}** and Venafi is responsible for validating and responding to requests initiated by the management layer.

Before you begin, it's important to understand the "whats," "whys" and "hows" of various *management layer* solutions. 

## What is it?

For our purposes, the management layer should be considered the source of truth for ALL configuration information, including, but not limited to {{mids}}, used by the objects (devices/applications/services) under its management.

!!! example "EXAMPLE"

    Consider [Citrix Application Delivery Management (ADM)](https://www.citrix.com/products/citrix-application-delivery-management/).
    ADM is a product from Citrix that provides centralized management and orchestration for Citrix's Application Delivery Controller (ADC) product line.
    It allows administrators to manage, configure, and deploy ADC apps and services from a single, centralized platform.
    This can help improve efficiency and reduce the time and effort needed to manage complex environments.
    ADM also provides additional features for monitoring and managing the performance and availability of ADC devices.

Because security is just one piece of the configuration the management layer is responsible for, it makes sense that any configuration updates are initiated there.
Multiple sources of truth can lead to collisions and synchronization issues since one source may not be aware of recent changes made by the other.

## Why is {{mid}} automation necessary?

Proper management of these {{mids}} is critical to the availability and security of the applications/devices/services under the purview of the management layer.
When active {{mids}} expire or become unavailable, outages happen.

{% include '.admonitions/outages-admonition.md' %}

These types of outages can occur for a variety of reasons, including human error or oversight, unnecessary bottlenecks during approval workflows or a general **lack of automation**.
The management layer *must* be aware of any and all information associated with a given {{mid}} and any workloads consuming it, so that it can proactively renew and re-provision on a schedule or ad-hoc, at the time of need. 

{% include 'value-drivers/vd-intro.md' %}

{% include 'value-drivers/vd-automate.md' %}

{% include 'value-drivers/vd-outages.md' %}