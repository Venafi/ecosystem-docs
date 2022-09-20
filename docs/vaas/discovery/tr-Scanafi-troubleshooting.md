# Troubleshooting Scanafi

Here's some useful information to help you troubleshoot the Scanafi utility.

Scanafi log messages and info:

| Number  |   Log Message  |  Severity  | Full Handshake Yes/No | Additonal Info  |
|:----------|:-------------|:------|:---------|:----------|
| 1 | Unable to get protocols for "IP Address" error:00ff0001 | Critical | No, only Client Hello | 0x00FF0001 => unable to connect, which prevents Scanafi from getting protocols and thus this error is reported.|
| 2|  Unable to complete scan for "IP Address" | Critical | No, only Client Hello | If you don't have enough information to proceed with scanning this error is shown, for example, if you cannot retrieve protocols (i.e. #1) you cannot scan for ciphers because those are per protocol and you have 0 protocols.  |
| 3|  Received error: Handshake failed when connecting to host  | Critical | No, only Client Hello | Connection Error: Handshake can fail for many reasons. It will take effort to classify these situations and report errors for user's eyes instead of log for developers. |
| 4|  Received error: Unable to connect to host  | Critical | No, only Client Hello | Connection Error: unable to connect, which prevents Scanafi from getting certificates |
| 5|  Received error: Connection timeout connecting to host  | Critical | No, only Client Hello | Connection Error: connection timeout while connecting to host |
| 6|  Received error: Incomplete parameters provided when connecting to host | Critical | No, only Client Hello | Connection Error: incomplete set of parameters provided while connecting to host |
| 7|  Received error: Received error: Protocol not supported with host | Critical | No, only Client Hello | Connection Error: connection error with invalid list of protocols provided |
| 8|  Received error: Received error: Internal error received from host | Critical | No, only Client Hello | Connection Error: internal error while connecting to host, no specific reason |
| 9|  No error: successful connection to host| |  |  |
| 10|  Invalid code provided | Critical | No, only Client Hello | Connection Error: (unknown error) – i.e. unable to process/map error code returned by internal APIs |
| 11|  Ciphers for "IP Address" error: "Error #" | Minor |  | Connection Error: (unknown error) – i.e. unable to process/map error code returned by internal APIs |
| 12|  Unable to get ECC named curves for "IP Address" error: "Error #" | Minor | | For a protocol negotiated during handshake, unable to get ECC (Elliptic Curve Cryptography) named curves from a host |
| 13|  Unable to check secure renegotiation support for "IP Address" error: "Error #" | Minor | |  Unable to check if secure renegotiation is supported by a host |
| 14|  Unable to check compression support for "IP Address" error: "Error #" | Minor | |  Unable to check if compression is supported by a host |
| 15|  Unable to check client initiated renegotiation support for "IP Address" error: "Error #" | Minor | |  Unable to check if the client-initiated renegotiation is supported by a host |
