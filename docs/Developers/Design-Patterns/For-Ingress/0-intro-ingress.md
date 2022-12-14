#  Ingress

**Ingress is the term used for a native Kubernetes resource that details the external routes into a cluster.
Ingress may provide load balancing, TLS termination, intelligent routing and API Gateway functionality.**

cert-manager integrates with Ingress objects to fulfill their role in securing your Kubernetes clusters.
{{tlspk}}, which provides first-class support for Ingress objects, includes an enterprise-hardened version of cert-manager and capabilities to support {{mids}} in the enterprise.

## Introduction

Kubernetes is a [platform for building platforms](https://twitter.com/kelseyhightower/status/935252923721793536?lang=en-GB) which helps companies <span class="value-drivers">modernize with speed and agility</span>.
It has a reduced set of opinions about how business demands are fulfilled.
This creates technological voids which the Kuberenetes community strives to fill.
One such area is Ingress Controllers, for which the community has provided [many options](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/).

!!! abstract "Design Pattern: Ingress"

    This design pattern focuses on the use case of leveraging {{mids}} via ingress controllers.
    It highlights the need for automation to ensure that once your solution is deployed it stays there, **proactively** securing workloads long into the future.

    <!-- The CRD for "Ingress" has a well defined specification, so each and every controller implementation is duty-bound to present a familiar face to the world. -->

Before you begin, it's important to understand the "what", "why" and "how" of *Ingress*. 

## What is it?

An Ingress is a Kubernetes resource.
Objects of this type represent lines of communication from **outside** a cluster (which could mean the internet) to workloads running **inside** this cluster.
Ingress objects bring network intelligence to multi-purpose [proxy servers](https://en.wikipedia.org/wiki/Proxy_server) in the form of rules-based routing.
Without the ability to span this divide Kubernetes would be isolated from the outside world and limited to running non-interactive workloads such as batch jobs.

The Ingress resource is native to Kubernetes but Ingress Controller resources are not.
An Ingress object can exist, but without an associated controller to respond, it will remain dormant - somewhat like a car without a driver.
Selecting a suitable Ingress Controller is a choice each cluster intends for you to make.

## Why is it necessary?

In addition to rules-based routing Ingress Controllers also provide enhanced security which, given the importance of {{mids}}, should be your primary concern.

The internet was originally envisioned as a medium for sharing information, however the modern world demands that information should be much better protected.
To meet these demands we have seen the steady rise of HTTPS to the point where modern browsers baulk at the use of [plain old HTTP](https://security.googleblog.com/2019/10/no-more-mixed-messages-about-https_3.html) so Transport Layer Security (TLS), which powers HTTPS, is now a mandatory requirement.
Henceforth you need to enforce the **security of your data in transit**.
Doing so with an Ingress Controller moves TLS termination closer to your workloads thereby helping to <span class="value-drivers">prevent misuse and compromise</span>.

Organizations use {{mids}} to provide end-to-end security of data sent between running processes with the TLS cryptographic protocol.
The use of X.509 certificates and HTTPS are the most common manifestation of this.

Those {{mids}} are sometimes installed at the application endpoint - as a layer of configuration inside your container images.
Cloud native principles such as [12 factor dependencies](https://12factor.net/dependencies) may convince you this is the right choice.
It's certainly convenient but this approach has a major flaw in that {{mids}} eventually expire so they must *not* be treated as **static** dependencies of your workloads.

This matters because when active {{mids}} expire or become unavailable, **outages** happen.

{% include '.admonitions/outages-admonition.md' %}

<!-- see note below -->
There are further limitations that stem from the use of containers with pre-baked security measures but the example above represents one that can be effectively tackled through the use of an Ingress.
<!-- The larger paragraph below is 100% valid, but is perhaps better suited to a discussion about service meshes or the cert-manager CSI-driver - ingress does not provide a solution to the problem described -->
<!--
When you look at the wider picture, you may also notice another concern related to the use of containers with pre-baked security measures.
If your container is used in the context of a Kubernetes [deployment](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/) resource then it may do so as a scaled-out fleet of workloads, each sharing the same {{mid}}.
This outcome is contrary to the meaning of the word "identity" an should be avoided when possible.
Arguably, the total number of {{mids}} in any given cluster should equal the total number of running workloads.
-->

## How it helps?

You can <span class="value-drivers">stop outages</span> caused by expiring {{mids}} with the use of an **proxy** placed in front of your workload.
This proxy should be configured to enforce TLS and act as the point of TLS termination.
This means that traffic touching the internet can be HTTPS whilst traffic touching the workload can remain as plain old HTTP.
The configuration of this proxy is determined by how your Ingress Controller interprets your Ingress objects.
Your Ingress Controller should be able to **inject** your {{mid}} into this proxy at the point of creation.
Perhaps more importantly, since {{mids}} are a **dynamic** dependency of your workload, your Ingress Controller should also be able to re-inject {{mids}}, whenever they are renewed.
This approach adheres to the principle of <span class="value-drivers">automating everywhere</span> and can permanently eliminate {{mid}} expiry as a outage risk.

Thankfully, the [Ingress specification](https://kubernetes.io/docs/reference/kubernetes-api/service-resources/ingress-v1/) accommodates TLS protection as an explicit attribute.
This is a clear indication that **all** Ingress Controller implementations are expected to provide proactive TLS support, relieving your workloads of that responsibility.
