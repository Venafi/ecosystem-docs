# Create a Basic discovery service

Create and run a Basic discovery service if you want to simply perform a quick certificate discovery inside your company's network. This discovery type uses Venafi's Scanafi utility to let you run manual discoveries.

!!! tip "TIP"
    Basic discovery does not include automated certificate validation. If you want automated certificate validation, [create an Enhanced discovery service instead](t-discovery-create-Enhanced-discovery.md).

## Before you start

Consider the following pre-requisites before you create your discovery service.

Scanafi discovers certificates on endpoints that are not reachable from the public internet. You'll need administrator access to an endpoint on which to download, install, and run Scanafi.

??? optional-css-class "What is Scanafi?"
    Scanafi is a lightweight command line tool that enables you to scan hosts on your internal network for SSL/TLS certificates. Scanafi is available as a single executable file for Windows, Linux, and MacOS operating systems.

    Scanafi performs certificate discoveries on port 443 and additional well-known ports via SSL/TLS and STARTTLS handshakes. It also tests for the presence of known vulnerabilities such as DROWN, Heartbleed, logjam, poodle, and poodle TLS.

    The primary mode of operation involves sending certificate discovery results to the {{vs}} Platform over REST API. This communication is over HTTPS TCP Port 443.

    Scanafi can operate in two simple modes: online or offline. 
    
    - The online mode involves the automatic transmission of certificate discovery results to the {{vs}} instance specified in the API call portion of the command line operation. Communication is over HTTPS and authentication credentials (an API token) for {{vs}} are also required. You can get an API token after successful registration on {{vs}}.
    - Scanafi is capable of operating in a offline mode. In this mode, all certificate discovery results are logged to a standard text file, in JSON format. This file can then be collected for out-of-band import to {{vs}} Platform using the {{vs}} API.

## To create a Basic discovery service

1. Sign in to {{vs}}.
1. Click **Discovery**, and then click **New** > **Basic discovery**.
1. Follow the remaining prompts.

<!-- add Steps Verification, which helps the reader know if they're done, if what they did worked. In this particular case, how do I know the basic discovery ran? we don't do a good job in the UI of showing that. -->

## What's next?

After you perform a discovery, it's a good idea to then [assign certificates to
applications](assign-or-reassign-certificate-to-application.md).
