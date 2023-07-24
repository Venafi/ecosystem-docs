The following functionality tests should be applicable to every solution targeting this use case.

| <h3>**Test Case**</h3> | <h3>**Description**</h3> | <h3>**Desired Outcome**</h3> |
| --- | --- | --- |
| ING-01 | **Documentation**: Solution should be fully documented | Both online and embedded CRD documentation (when applicable) is provided |
| ING-02 | **Error Handling**: Perform an operation which you expect to fail (unsupported key size, missing/incomplete data, etc.) | The error will be encountered and a meaningful error message will be presented to the end user and, if applicable, back to Venafi |
| ING-03 | **CRUD Lifecycle**: Standard logic around creation, modification and deletion | Ingress and its standard behavioral effects should be observable from within {{tlspk}}. Ingress is observed as both updated and subsequently deleted. Exceptions to these outcomes must be justified and documented | 
| ING-04 | **TLS**: Support TLS-enabled public routes | TLS-enabled Ingress routes are provisioned and observable from within {{tlspk}}. Meanwhile, browser can navigate to workload via HTTPS without security warnings | 
| ING-05 | **Certificate Renewed**: Renew certificate used as a {{mid}} | Revised expiry date for Ingress {{mid}} is visible from within {{tlspk}}. Ingress reconfiguration is automatically triggered |
