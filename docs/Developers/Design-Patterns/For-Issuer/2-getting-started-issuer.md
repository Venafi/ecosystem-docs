# Getting Started

If you've made it here, you should already have a general understanding about [Issuers and {{mids}}](1-overview-issuers.md).
Now you're ready to get started developing your **Issuer** solution.

<!-- TODO What the architecture process? What's the process for starting developing? What are considerations for authenticating? What about workflow? How does cert-manager differ from TLS Protect for Kubernetes? -->
<!-- TODO From a getting started at the highest level this doesn't seem what I need to know. I need to know the architecture, the min/preferred design, authentication model, operations, errors/exception, and more. -->
## High-level Process

1. Head over to [{{tlspk}}](https://platform.jetstack.io/){: target="_blank" } and select **ACCESS YOUR ACCOUNT**.
1. Log In to your account **or**, if you don't already have one, select **Sign Up**, complete the Terms of Service  and follow the on screen prompts.
**Note**: new users will be allocated a **organization name** made of two randomly selected words (e.g. foxtrot-charlie) which is your private workspace within the SaaS platform.
1. From the {{tlspk}} console, select **Clusters** and **CONNECT NEW CLUSTER** to familiarize yourself with the steps required to introduce a Kubernetes cluster to your organization.
Your choice of Kubernetes distribution is somewhat arbitrary, however you should consider the need to create them repeatedly to enable thorough testing.
1. Head over to https://platform.jetstack.io/org/[ORG]/certinventory/cluster/[CLUSTER]/issuers.
This is where you will locate any active Issuer objects in your registered cluster(s).
1. From the {{tlspk}} console, select **ADD AN ISSUER** to familiarize yourself with the steps required to introduce new Issuer objects (both native and [**external**](https://cert-manager.io/docs/configuration/external/#known-external-issuers)) to your cluster.
1. Start building!
We highly recommend using [Kubebuilder](https://github.com/kubernetes-sigs/kubebuilder) framework to increase your velocity and reduce the complexity inherent in developing any Kubernetes controller.
1. Perform [functional testing](3-functional-testing-issuers.md).
1. Get [certified](../../Certification/TLS-Protect-For-Kubernetes/1-tlsp-certification-intro.md)!

## Getting Help

The cert-manager team have produced an article named [Implementing External Issuers](https://cert-manager.io/docs/contributing/external-issuers/) which is geared directly towards assisting developers like yourself.
Pay special attention to the sections named [Approval](https://cert-manager.io/docs/contributing/external-issuers/#approval) and [Conditions](https://cert-manager.io/docs/contributing/external-issuers/#conditions).

If you aren't able to find what you're looking for, or have a specific question related to your use case, please [post a question](https://community.venafi.com/ask-the-community-23){: target="_blank" } to the Developer Forum section of Venafi's {{com}} or [email](mailto:support@venafi.com?subject=Developer Question: Issuer) Venafi Customer Support.
