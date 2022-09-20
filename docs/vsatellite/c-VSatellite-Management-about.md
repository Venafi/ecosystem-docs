# Overview: Venafi VSatellites

{{ven}} {{vsat}}s are a new, novel and critical part of {{vs}}, 
{{ven}}'s cloud-native machine identity management service.

{{vsat}}s extend the reach of your {{vs}} account beyond 
publicly accessible networks and hosts, to your on-premise/private 
cloud networks and machines, enabling you to develop the full 
picture of your machine identities across your organization, 
irrespective of public or private visibility.

<!-- **(TBD: Overview InfoGraphic of VSat architecture; [start with 
this one from Walter](https://lucid.app/lucidchart/invitations/accept/f0887f79-c3a8-4fc0-9e83-add50c7d6a1b) 
-->
At the most basic level, {{ven}} {{vsat}} is a self-updating 
application that is a runtime extension of {{vs}} that runs within 
your private infrastructure.

{{vsat}} is a modern, self-contained, low-footprint, 
Kubernetes-based application runtime and runs on [popular 
Linux systems](t-VSatellite-deployNew.md). 

You manage your own {{vsat}}s remotely using your company's own 
{{vs}} account. So, after your administrators have completed a 
one-time download and setup of {{vsat}}s on your designated 
machines (Linux), full administration and management of services 
for those {{vsat}}s is performed from using the {{vs}} web 
console. This includes self-updates of the {{vsat}} runtime itself.

## What's Next?

Learn how to [set up your first {{vsat}}](t-VSatellite-deployNew.md), 
or if you've already done so, learn more about [managing your existing 
{{vsat}}s](t-VSatellite-managing.md).

Or you can learn a bit more about [how {{vsat}}s actually work, 
including the moving parts](c-VSatellite-howItWorks.md).
