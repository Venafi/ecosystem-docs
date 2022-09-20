# Known Issues

*Last update: 21 January 2022*

??? optional-css-class "Changing the IP address of a {{vsat}} (physical or virtual) machine isn't reflected in the VaaS interface."
    If you change the IP address of the machine where you had previously installed a {{vsat}}, the IP address is not updated in the {{vs}} interface. Also, this can make the {{vsat}} inoperable, so you might need to restart the machine.   <!-- VC-13678 -->

??? optional-css-class "Progress bar for VSatellite install or uninstall not working correctly" 
    When installing or uninstalling a VSatellite while connected using SSH and the Windows version of the Putty client, the progress bar does not reflect progress, as expected. <!-- VC-12746 - VCKnights -->

<!-- ??? optional-css-class "The Target TLS Ports field not allowing use of comma-separated values" 
    The Target TLS Ports field no longer accepts comma separated values. If you paste in a string, such as *443, 8080, 
    8001, 8002, 8003*, only the first port is saved. <!-- VC-12951 - VCKnights -->

<!-- ??? optional-css-class "KnownIssueStatement" 
    BriefExplanation VC-12746 - VCKnights  -->

<!-- ## Resolved Issues

??? optional-css-class "Email notifications for domain discovery"
    Email notifications for domain discovery no longer needs to be disabled to prevent AWS SES suspension. VC-13292

 ??? optional-css-class "ResolvedIssue2"
    TextHere.

??? optional-css-class "ResolvedIssue3"
    TextHere. -->
