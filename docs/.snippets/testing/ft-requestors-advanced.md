Depending on the exact functionality of the target solution, the following tests may or may not be applicable.

| <h3>**Test Case**</h3> | <h3>**Description**</h3> | <h3>**Desired Outcome**</h3> |
| --- | --- | --- |
| New Certificate *Association* | Request a *new* certificate and **create a new** associated configuration object to utilize the certificate (e.g. Security "Profile") | Certificate is provisioned with location(s) reported back to Venafi and configuration object is created automatically at the target | 
| Existing Certificate *Association* | Make a renewal request and **update an existing** associated configuration object | Certificate is provisioned with location(s) reported back to Venafi and existing configuration object is validated (and updated if required) | 
| Automated Renewals | Request a short-lived certificate from Venafi and let your product automate the renewal | Renewal request is made to Venafi and renewed certificate is automatically attached to the associated configuration object (ideally with no downtime) |