#//# --------------------------------------------------------------------------------------
#//# Created using Sequence Diagram for Mac
#//# https://www.macsequencediagram.com
#//# https://itunes.apple.com/gb/app/sequence-diagram/id1195426709?mt=12
#//# --------------------------------------------------------------------------------------
title "Abstracting Token Refresh for Your End Users"

participant "End User" as EU
participant "Integrated Platform" as IP
participant "Venafi" as V

activate EU
activate IP

EU->IP: Enter required SERVICE ACCOUNT connection information \n (Venafi URL/ClientID/Username/Password)

deactivate EU

IP->IP: Store required connection information SECURELY

activate V

IP->V: Use connection information \n to call '/vedauth/authorize' \n providing UN, PW, ClientID, & Scope
V-->IP: Returns Access/Refresh tokens \n and expiry information
IP->IP: Store tokens & expiry info


	IP->V: Use 'access_token' to \n authorize API calls to Venafi
	alt [access_token is still valid]
		V-->IP: API call returns data successfully
		
	else [access_token is expired]
		V-->IP: Returns 'access_token is expired'
		IP->V: Calls '/vedauth/authorize/' \n providing ClientID & refresh_token
		V-->IP: Returns fresh Access/Refresh \n tokens & expiry info
		IP->IP: Update stored tokens & \n expiry info with new values
		IP->V: Use 'access_token' to \n authorize API calls to Venafi
		V-->IP: API call returns data successfully
		end
		
IP->V: Call 'vedauth/Revoke/token' \n to clean up active grant

deactivate IP
deactivate V
