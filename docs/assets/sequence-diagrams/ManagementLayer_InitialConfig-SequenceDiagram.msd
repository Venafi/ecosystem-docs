#//# --------------------------------------------------------------------------------------
#//# Created using Sequence Diagram for Mac
#//# https://www.macsequencediagram.com
#//# https://itunes.apple.com/gb/app/sequence-diagram/id1195426709?mt=12
#//# --------------------------------------------------------------------------------------
title "Orchestration/Management Layer Initial Config w/ Venafi"

participant "Admin" as A
participant "Management\nLayer" as ML
participant "Venafi" as V

activate A
activate ML

A->ML: Enter required connection information\n(TPP URL, Scope, Access & Refresh Tokens)


	activate V
	ML->V: Test connection to Venafi
	alt [ Connection test succeeds ]
		V-->ML: Return 'Success' message
		ML->A: Prompt user to finsish config
		A->ML: User configures desired Policy/Zone target
		ML->V: Checks if policy configuration is valid
		alt [ Policy specification is valid ]
			V-->ML: Return list of available sub folders
			ML->A: Present subfolder list to user for verification
			A->ML: User saves config
		
		else [Policy specification is invalid ]
			V-->ML: Return error message
			ML->A: Return meaningful error message
		end # alt end
		
	else [ Connection test fails ]
		V-->ML: Return 'Failed' message
		deactivate V
		ML->A:Return meaningful error message
		deactivate ML
		deactivate A
	end # alt end	
