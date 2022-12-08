{% include 'testing/ft-general-basic.md' %}
| New Certificate | Request a *new* certificate from Venafi | Certificate is issued, retrieved and installed downstream and ALL location(s) are reported back to Venafi | 
| Existing Certificate (non-renewed)| Request *the same* certificate from Venafi (without renewing the cert) | Certificate is issued, retrieved and installed downstream with location(s) reported back to Venafi | 
| Existing Certificate (renewed) | Make a *manual* renewal request on an existing certificate | Certificate is provisioned with location(s) reported back to Venafi |