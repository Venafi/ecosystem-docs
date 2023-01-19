{% include 'testing/ft-general-basic.md' %}
| New TLS-enabled Ingress | Provision an ingress with a working TLS-enabled public route | Ingress is provisioned and available for inspection from within {{tlspk}}. Meanwhile, browser can navigate to workload via HTTPS | 
| Certificate Renewed | Renew certificate used as a {{mid}} | Revised expiry date for Ingress {{mid}} is visible from within {{tlspk}}. Ingress reconfiguration is automatically triggered |
