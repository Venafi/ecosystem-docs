Overview: TLS Encryption

### What is TLS Encryption?

Organizations use {{mids}} to secure traffic to their applications, workloads & servers using Transport Layer Security, or TLS, with HTTPS being the most common use case.

Sometimes those {{mids}} are installed at the application endpoint, itself. Other times, they may be installed on a load balancer or proxy. Regardless of the location, proper management of that {{mid}} is critical to the availability and security of the application. When {{mids}} expire, it creates outages.

{% include '.admonitions/outages-admonition.md' %}

This design pattern focuses on the use case of orchestrating the delivery of {{mids}} to location(s) where they'll be used, as well as automating any configuration necessary to *activate* or *associate* them with target applications. **The best solutions will require as little, if any at all, human interaction as possible after initial configuration.**



### Examples

Existing solutions from the [Venafi Marketplace](https://marketplace.venafi.com) that fit this category include:

- [Apache HTTP Server](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6294f5507550f2ee553cf25d)
- [NGINX](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/629018cb220a43b0c9a48868)
- [F5 BIG-IP](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/620eeb25d419fb06a5c5bd57)
- [Citrix ADC](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/6297c2b57550f2ee553cf27d)