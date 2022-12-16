# Getting Started

If you've made it here, you should already have a general understanding about [Ingress objects and how they use {{mids}}](1-overview-ingress.md) and you're ready to get started developing your **Ingress** solution.

## High-level Process

1. Log In to {{tlspk}} **or**, if you don't already have one, head [here](https://platform.jetstack.io/){: target="_blank" }, select **ACCESS YOUR ACCOUNT**, select **Sign Up**, complete the Terms of Service  and follow the on screen prompts.
**Note**: new users will be allocated a **organization name** made of two randomly selected words (e.g. foxtrot-charlie) which is your private workspace within the SaaS platform.
1. From the {{tlspk}} console, select **Clusters** and **CONNECT NEW CLUSTER** to familiarize yourself with the steps required to introduce a Kubernetes cluster to your organization.
Your choice of Kubernetes distribution is somewhat arbitrary, however you should consider the need to create them repeatedly to enable thorough testing.
You should also consider that not all distributions provide native support for Kubernetes services of type LoadBalancer.
1. Try out one or two of the [most popular Ingress Controllers](https://kubevious.io/blog/post/comparing-top-ingress-controllers-for-kubernetes) to familiarize yourself with their shared behavior and relative strengths.
1. Head over to https://platform.jetstack.io/org/[ORG]/certinventory/cluster/[CLUSTER]/ingresses.
This is where you will locate any active Ingress resources in your registered cluster(s).
1. Start building!
We highly recommend using [Kubebuilder](https://github.com/kubernetes-sigs/kubebuilder) framework to increase your velocity and reduce the complexity inherent in developing Kubernetes controllers.
1. Perform [functional testing](3-functional-testing-ingress.md)
1. Get [certified](../../Certification/TLS-Protect-For-Kubernetes/1-tlsp-certification-intro.md)!

## Getting Help

If you aren't able to find what you're looking for, or have a specific question related to your use case, please [post a question](https://community.venafi.com/ask-the-community-23){: target="_blank" } to the Developer Forum section of Venafi's {{com}} or [email](mailto:support@venafi.com?subject=Developer Question: Ingress) Venafi Customer Support. 



<!-- 1. Create a [TLS Protect Cloud](https://vaas.venafi.com){: target="_blank" } account if you don't have one already.
2. Decide on a programming language and understand what tooling, if any, your solution will use (If you aren't sure yet, [this](https://venafi-dev-onboarding.paperform.co/){: target="_blank" } might help 🙂).
3. Start building!
4. Perform [functional testing](3-functional-testing-cloud-waf.md).
5. Get [certified](../../Certification/TLS-Protect-Cloud/1-tlsp-certification-intro.md)! -->


<!-- Need to say more about JSS -->