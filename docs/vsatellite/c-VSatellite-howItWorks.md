# How do VSatellites work?

{{vsat}}s rely on discovery services, which are designed to help distribute the work of machine identity management across multiple {{vsat}}s.

## About discovery services

In {{vs}}, a *discovery service* is a machine identity management function. {{vs}} includes several types of machine identity management functions, two of which include

- internal discovery service
- external discovery service

Typically, you'd schedule these services to run at particular times.

Services are the live machine identity management functions that run inside of
{{vsat}}s. However, not all services require you to deploy a {{vsat}}. Using a
{{vs}} web console, you can view the status and last known state of each
{{vsat}}.

[Learn more about discovery services](gs-Cloud-Discovery.md).

## <a name="about-vsat-workers"></a>About {{vsatw}}s

In addition to {{vsat}}s, {{vs}} also makes use of _{{vsatw}}s_ to support
{{adcsfull}} ({{adcs}}) integration. A {{vsatw}} is installed on a separate
Windows Server, and it connects a {{ms}} {{adcs}} server to a {{vsat}}. 

[Learn more about {{adcs}} integration and {{vsatw}}s](issuing-certificates-with-microsoft-adcs.md).

## What's Next

<!-- - [Learn more about what gets installed as part of {{vsat}}s](). **DW: add link to new topic** -->
- [Deploy a new {{vsat}}](t-VSatellite-deployNew.md)
- [Learn how to manage your installed {{vsat}}s](t-VSatellite-managing.md)
- [View your current list of {{vsat}}s](t-VSatellite-monitoring.md)
    <!--    - Toggle master vs. detail view **DW: add link to where we discuss the toggle view option** -->
- [Rename a {{vsat}}](renaming-a-vsatellite.md)
- [Delete a {{vsat}}](t-VSatellite-delete.md)
- [View a {{vsat}}'s available services](t-VSatellite-monitoring.md)
