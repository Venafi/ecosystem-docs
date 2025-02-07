# Getting Started

If you've made it here, you should already have a general understanding about [how the Ingress resource relates to {{mids}}](0-intro-ingress.md){: target="_blank" } and you're ready to get started developing your **Ingress** solution.

## High-level Process

1. Head over to [{{tlspk}}](https://platform.jetstack.io/){: target="_blank" } and select **ACCESS YOUR ACCOUNT**.
1. Log In to your account **or**, if you don't already have one, select **Sign Up**, complete the Terms of Service  and follow the on screen prompts.
**Note**: new users will be allocated a **organization name** made of two randomly selected words (e.g. foxtrot-charlie) which is your private workspace within the SaaS platform.
1. From the {{tlspk}} console, select **Clusters** and **CONNECT NEW CLUSTER** to familiarize yourself with the steps required to introduce a Kubernetes cluster to your organization.
Your choice of Kubernetes distribution is somewhat arbitrary, however you should consider the need to create them repeatedly to enable thorough testing.
You should also consider that not all distributions provide native support for Kubernetes services of type LoadBalancer.
1. Try out one or two of the [most popular Ingress Controllers](https://kubevious.io/blog/post/comparing-top-ingress-controllers-for-kubernetes){: target="_blank" } to familiarize yourself with their shared behavior and relative strengths.
1. Head over to https://platform.jetstack.io/org/[ORG]/certinventory/cluster/[CLUSTER]/ingresses.
This is where you will locate any active Ingress objects in your registered cluster(s).
1. Start building!
We highly recommend using [Kubebuilder](https://github.com/kubernetes-sigs/kubebuilder){: target="_blank" } framework to increase your velocity and reduce the complexity inherent in developing any Kubernetes controller.
1. Perform [functional testing](3-functional-testing-ingress.md){: target="_blank" }.
1. Get [certified](../../Certification/TLS-Protect-For-Kubernetes/1-tlspk-certification-intro.md){: target="_blank" }!

## Getting Help

We think you'll find the following references helpful when developing your solution. 

- [Official Kubernetes Ingress Documentation](https://kubernetes.io/docs/concepts/services-networking/ingress/){: target="_blank" }
- [Kubernetes Ingress Explained for Beginners](https://www.youtube.com/watch?v=izWCkcJAzBw){: target="_blank" }
- [Everything you need to know about Kubebuilder](https://www.youtube.com/watch?v=_XUJ1HoinWA){: target="_blank" }
- [Writing a Kubernetes Operator from Scratch Using Kubebuilder](https://www.youtube.com/watch?v=LLVoyXjYlYM){: target="_blank" }

If you are not able to find what you're looking for or you've found other articles/tools that deserve to be included here please [post a question](https://community.venafi.com/ask-the-community-23){: target="_blank" } to the Developer Forum section of Venafi's {{com}} or [email](mailto:ecosystem@venafi.com?subject=ecosystem.venafi.com feedback - Ingress design pattern) the Ecosystem team. 
