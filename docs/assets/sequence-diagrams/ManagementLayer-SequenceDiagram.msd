#//# --------------------------------------------------------------------------------------
#//# Created using Sequence Diagram for Mac
#//# https://www.macsequencediagram.com
#//# https://itunes.apple.com/gb/app/sequence-diagram/id1195426709?mt=12
#//# --------------------------------------------------------------------------------------
title "Orchestration/Management Layer Usage w/ Venafi"

participant "Certificate\nConsumer" as CC
participant "Admin" as A
participant "Management\nLayer" as ML
participant "Venafi" as V
participant "Certificate\nAuthority" as CA

activate A
activate ML

A->ML: Request certificate


	ML->ML: Check currently saved policy
	alt [ Request meets policy ]
		ML->ML: Create CSR or\nAPI request
		activate V
		ML->V: Request certificate
		
		alt [ Request meets Policy ]
			activate CA
			V->CA: Request certificate
			CA-->V: Issue certificate
			deactivate CA
			activate CC
			
			loop
				ML->V: Attempt certificate retrieval
				
				alt [ Certificate is ready for download ]
				V->ML: Provision certificate
				ML->CC: Provision certificate
				
					alt [ Provisioned successfully ]
						CC-->ML: Return 'Success' message
						ML->A: Return 'Success' message
						ML->V: Report certificate\ninstallation information
					
					else [ Provisioning failed ]
						CC-->ML: Return 'Failed' message
						deactivate CC
						ML->A: Return 'Failed' message\n(ideally with reason for failure)
					end # alt end
				else [ Certificate is not ready ]
					V-->ML: Return 'Cert not ready'
				end # alt end
			end # loop end
		else [ Request doesn't meet policy ]
			V->ML: Return error message\ndetailing why cert is unavailable
			deactivate V
			ML->A: Return meaningful error message
		end
	else [ Request doesn't meet policy ]
		ML-->A: Return meaningful error message
		
		deactivate ML
		deactivate A
	end # alt end

	
	# Insert condition here for when request is denied by Venafi or certificate is still processing



	