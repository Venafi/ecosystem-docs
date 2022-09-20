# Troubleshooting

Need help solving a perplexing issue? We're listening to you and creating workarounds for troubleshooting the most common issues.

Please check back here regularly for new content. If something's missing, please [send us your feedback](mailto:documentationfeedback@venafi.com) and we'll get on it!

## VSatellites

### One or more of my VSatellites appear to have lost connection.

Lost {{vsat}} connections occur most often because of a network failure between {{vsat}} and {{vsl}}. 

Try the following methods to troubleshoot a potentially disconnected {{vsat}}:

1. Verify that the machine that's hosting {{vsat}} is up and running.
1. Verify that there's network connectivity between that {{vsat}} machine and {{vs}}:
    - Make sure that port 443 isn't blocked on the {{vsat}} machine.
    - Verify that the {{vsat}} is able to reach https://vsat-gw.venafi.cloud:9443
1. If at this point a {{vsat}} continues to lose connection, [uninstall](../vsatellite/t-VSatellite-delete.md) and then [reinstall](../vsatellite/t-VSatellite-deployNew.md) the {{vsat}}.

!!! note "Note"
    Changing the IP address on the (physical or virtual) machine where you're hosting {{vsat}}s can also cause the {{vsat}} to fail. For more information, see the related [known issue](KnownIssues.md).

If you continue to have issues, please contact [Venafi Technical Support](https://support.venafi.com/hc/en-us).