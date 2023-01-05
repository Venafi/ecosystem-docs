The following functionality tests should be applicable to every solution targeting this use case.

| <h3>**Test Case**</h3> | <h3>**Description**</h3> | <h3>**Desired Outcome**</h3> |
| --- | --- | --- |
| Error Handling | Perform an operation which you expect to fail (unsupported key size, missing/incomplete data, provider-centric policy violation, etc.) | A meaningful error message will be recorded in the cert-manager logs and will propagate to the {{tlspk}} front-end |
| New Certificate | Provision a new certificate for use as a {{mid}} | Certificate is delivered back to cert-manager and observably ready for use from within {{tlspk}} | 
| Certificate Renewed | Renew certificate for use as a {{mid}} | Certificate is delivered back to cert-manager and revised expiry date is visible from within {{tlspk}} |
| Approval Status | Without approval from the [approver-policy](https://platform.jetstack.io/documentation/installation/approver-policy) component of {{tlspk}} Enterprise, no certificate should be issued | Unapproved certificates will be flagged as such in {{tlspk}} |
| Ingress Integration | Provide seamless integration with Ingress Controllers | Ingresses enlisting the support of your Issuer solution will behave as per native Issuers with regard to {{mids}} |
