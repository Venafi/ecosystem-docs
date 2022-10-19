# Testing Diagrams

<!-- Needs lots of formatting work to make it readable. Might be easier to do images for now. -->

Here's an example of a diagram:

``` mermaid
%%{
  init: {
    "sequence": {
      "showSequenceNumbers": true,
      "messageAlign": "center"
    }
  }
}%%
sequenceDiagram

    actor EU as User
    participant IP as Integrated Platform
    participant V as Venafi

    activate EU
    EU->IP: Enter required SERVICE ACCOUNT connection information (Venafi URL/ClientID/Username/Password)

    deactivate EU
    activate IP

    IP->IP: Store required connection information SECURELY

    activate V

    IP->V: Use connection information to call '/vedauth/authorize' providing UN, PW, ClientID, & Scope
    V-->IP: Returns Access/Refresh tokens and expiry information
    IP->IP: Store tokens & expiry info


        IP->V: Use 'access_token' to authorize API calls to Venafi
        alt [access_token is still valid]
            V-->IP: API call returns data successfully
            
        else [access_token is expired]
            V-->IP: Returns 'access_token is expired'
            IP->V: Calls '/vedauth/authorize/'  providing ClientID & refresh_token
            V-->IP: Returns fresh Access/Refresh  tokens & expiry info
            IP->IP: Update stored tokens &  expiry info with new values
            IP->V: Use 'access_token' to  authorize API calls to Venafi
            V-->IP: API call returns data successfully
            end
            
    IP->V: Call 'vedauth/Revoke/token'  to clean up active grant

    deactivate IP
    deactivate V
```
