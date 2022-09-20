# Create an Enhanced discovery service

Create and run an Enhanced discovery service to perform certificate discoveries
inside of your company's network according to a fixed schedule (optional).

Enhanced Discovery takes advantage of Venafi's {{vsat}}s to extend the reach of
your {{vs}} account beyond public networks to discover certificates within your
on-premise/private networks and machines. 

This discovery service validates discovered certificates automatically.

!!! tip "TIP"
    If you want to simply perform a quick certificate discovery inside your company's network, [create a Basic discovery service instead](t-discovery-create-Basic-discovery.md).

### Before you start

Consider the following pre-requisites before you create your discovery service:

{{vsat}} discovers certificates on endpoints that are not reachable from the
public internet. You'll need administrator access to an endpoint that meets the
following system requirements: 

  - {% include 'vsat/sn-vsat-supported-ubuntu.md' %}
  - {% include 'vsat/sn-vsat-req-ram.md' %}
  - {% include 'vsat/sn-vsat-req-cpu.md' %}
  - {% include 'vsat/sn-vsat-req-disk.md' %}

### To create an Enhanced discovery service

1. Log in to {{vs}}.
1. Click **Discovery**, and then click **New** > **Enhanced discovery**.
1. Following the remaining prompts.

<!-- add Steps Verification, which helps the reader know if they're done, if what they did worked. In this particular case, how do I know the enhanced discovery ran? we don't do a good job in the UI of showing that. -->

??? optional-css-class "About vSatellites"
    {{vsat}}s are a new, novel and critical part of {{vs}}, {{ven}}'s cloud-native machine identity management service.

    {{vsat}}s extend the reach of your {{vs}} account beyond 
    publicly accessible networks and hosts, to your on-premise/private 
    cloud networks and machines, enabling you to develop the full 
    picture of your machine identities across your organization, 
    irrespective of public or private visibility.

    <!-- **(TBD: Overview InfoGraphic of VSat architecture; [start with 
    this one from Walter](https://lucid.app/lucidchart/invitations/accept/f0887f79-c3a8-4fc0-9e83-add50c7d6a1b) 
    -->
    At the most basic level, {{vsat}} is a self-updating 
    application that is a runtime extension of {{vs}} that runs within 
    your private infrastructure.

    {{vsat}} is a modern, self-contained, low-footprint, 
    Kubernetes-based application runtime and runs on popular 
    Linux systems.

    You manage your own {{vsat}}s remotely using your company's own 
    {{vs}} account. So, after your administrators have completed a 
    one-time download and setup of {{vsat}}s on your designated 
    machines (Linux), full administration and management of services 
    for those {{vsat}}s is performed from using the {{vs}} web 
    console. This includes self-updates of the {{vsat}} runtime itself.

    Learn more about [managing your existing 
    {{vsat}}s](t-VSatellite-managing.md). Or you can learn a bit more about [how {{vsat}}s actually work, 
    including the moving parts](c-VSatellite-howItWorks.md).

## What's next?

After you perform a discovery, it's a good idea to then [assign certificates to
applications](assign-or-reassign-certificate-to-application.md).
