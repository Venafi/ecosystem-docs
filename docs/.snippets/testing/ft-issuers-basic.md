{% include 'testing/ft-general-basic.md' %}
| New Certificate | Provision a new certificate for use as a {{mid}} | Certificate is provisioned and available for inspection from within {{tlspk}} | 
| Certificate Renewed | Renew certificate for use as a {{mid}} | Revised expiry date is visible from within {{tlspk}} |
| Approval Status | Without approval from the [approver-policy](https://platform.jetstack.io/documentation/installation/approver-policy) component of {{tlspk}} Enterprise, no certificate should be issued | Unapproved certificates will be flagged as such in {{tlspk}} |
| Ingress Integration | Provide seamless integration with Ingress Controllers | Ingresses enlisting the support of your Issuer solution will behave as per native Issuers with regard to {{mids}} |
