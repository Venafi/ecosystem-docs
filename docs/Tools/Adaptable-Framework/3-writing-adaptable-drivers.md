# Writing Adaptable Drivers

Venafi Adaptable Drivers provide a way quick, easy framework to build solutions, primarily with target **application platforms** (web servers, network devices, application firewalls, etc.) and **CAs** (certificate authorities), but also to support flexible workflow and logging needs for unique environments.

!!! note 

    Venafi Adaptable Drivers support Venafi TLS Protect Datacenter only. Venafi Product Management is working on a similar framework for TLS Protect Cloud use cases. 

    Please **[sign up here](https://venafi-connector-framework-confirm-interest.paperform.co)** to be notified when developer tools are available for TLS Protect Cloud.

## Getting Started

1. Read through this section on the Adaptable Framework (You're almost done!)
2. Decide which DevKit you'll need below :point_down:
3. Build & test your driver using the tools provided in the DevKit
4. Test your driver against TLS Protect Datacenter
5. [Submit your driver to Cool Solutions](https://coolsolutions.venafi.com){: target="_blank" } (Venafi's managed GitLab instance)
6. Complete the Marketplace Listing Questionnaire

## Adaptable Driver Types

=== "Adaptable CA"
    Choose this if you are building an solution between Venafi and a Machine Identity ***Producer***, like a Certificate Authority or Managed PKI.

    [Adaptable CA Full Documentation](https://docs.venafi.com/Docs/current/TopNav/Content/Drivers/cco-drivers-AdaptableCA-Overview.php)

=== "Adaptable App"
    Choose this if you are building an solution between Venafi and a Machine Identity ***Consumer***, like an application server, network device, WAF, etc.

    [Adaptable Application Full Documentation](https://docs.venafi.com/Docs/current/TopNav/Content/Drivers/cco-drivers-AdaptableApp-Overview.php)

=== "Adaptable Log"
    Choose this if you are building a solution that will be used to perform virtually any programmatic task in response to the logging of a Venafi event.

    [Adaptable Log Full Documentation](https://docs.venafi.com/Docs/current/TopNav/Content/Logging/c-logging-AdaptableChannel-config-tpp.php)

=== "Adaptable Workflow"
    Choose this if you are building a solution with the goal of further customizing Venafi's native approval workflows.

    [Adaptable Workflow Full Documentation](https://docs.venafi.com/Docs/current/TopNav/Content/Workflow/c-workflow-adaptable-workfow-overview.php)

