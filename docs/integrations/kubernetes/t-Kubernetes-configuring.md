# Configuring the Kubernetes integration

The interface between a cert-manager instance and {{vs}} is configured via a
cert-manager _issuer_. The issuer contains a reference to a Kubernetes secret
that contains your {{vs}} API key as well as the zone that will be used by the
cert-manager plugin to request certificates. The ‘cloudsecret’ field contains
the name of the Kubernetes secret that contains your API key. The ‘zone’ field
contains the name of the zone.

```
apiVersion: certmanager.k8s.io/v1alpha1
kind: Issuer
metadata:
    name: cloud-devops-issuer
    namespace: cert-manager-example
spec:
    Venafi:
        cloudsecret: clouddevsecret
        zone: "Default"
```      

* Use **Your Parameters** on the Automation page to determine which zone should
  be used to issue certificates.

    ![screen](Configuring_the_Integration.png)

    
!!! note "Note"  
    Your Parameters displays the policies that must be conformed to when
    certificates are requested from the zone.

    Additional information and examples of setting up the issuer with {{vs}} 
    and other Venafi solutions can be found in [Venafi's Github][1] page.

[1]:https://github.com/venafi