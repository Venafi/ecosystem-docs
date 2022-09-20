# Microsoft AD CS integration with Venafi as a Service 

Many organizations use {{adcsfull}} ({{adcs}}) to issue internally-trusted
certificates. Connecting {{ms}} {{adcs}} to {{vs}} provides comprehensive
visibility and automation. {{vs}} can provide visibility to the certificates
issued by {{ms}} {{adcs}}, and it can also automate certificate issuance through
{{ms}} {{adcs}}.

## How it works

{{ms}} {{adcs}} connects to {{vs}} using a
_[{{vsat}}](c-VSatellite-Management-about.md)_ and a
_[{{vsatw}}](c-VSatellite-howItWorks.md#about-vsat-workers)_.


The {{vsat}} is installed on a Linux server, and it creates the connection point
between your organization's internal network and {{vs}}. 

The {{vsatw}} is the connection point between the {{vsat}} to your {{ms}}
{{adcs}} server.

<div class="vaas-img">
    <img src="../img/vsat-and-worker-diagram.png" alt="{{vsatw}} diagram">
</div>

## What's Next

The information in this section provides you with the information you need to
set up {{adcs}} integration with {{vs}}. 

Before you start, you're going to need a couple servers for your {{vsat}} and
{{vsatw}}. If you don't have those yet, [have a look at the system requirements](issuing-certificates-with-microsoft-adcs.md#adcsPrereqs).

Also, your {{adcs}} service is going to need to [meet certain configuration requirements](setting-up-adcs.md). 

Once the servers are in place and your {{adcs}} is properly configured, we'll
[walk you through the rest of the setup](issuing-certificates-with-microsoft-adcs.md).
