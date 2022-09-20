# About Vault Venafi Secrets Engine integration with Venafi as a Service

![Vault Venafi Secrets Engine overview](Hashicorp_vault_flow_diagram.png)

The Venafi Vault plug-in is implemented as a custom plug-in that implements a
PKI secrets engine.

The integration is hosted in [Venafi’s Github
page](https://github.com/Venafi/vault-pki-backend-venafi).

The Venafi PKI secrets engine is configured by creating a new role that is
linked to a zone that will be used to issue certificates. It also requires the
API key that authenticates to {{vs}}.

Multiple roles can be created that use different zones to support use cases
where different certificate types are required, such as:

* Issuing certificates to Ingress controllers that contain TLS annotations to
  enable TLS for inbound traffic to your Kubernetes cluster
* Creating certificates as Kubernetes secrets for use by pods in a Kubernetes
  cluster to secure communication between pods with TLS

Once the Venafi PKI secrets engine is enabled and configured with one or more
roles, Vault will automatically forward certificate requests to {{vs}} for
issuance whenever the native Vault commands to create certificates are executed.