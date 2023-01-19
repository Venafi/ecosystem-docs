# Requirements

There are currently two levels of certification for {{tlspk}} solutions, **Foundation Certification** and **Advanced Certification**.
It's our hope that every developer strives for the most comprehensive solution, but understand that isn't always possible due to resource and/or time constraints.
The purpose of creating multiple levels of certification is two-fold:

- It provides a lower barrier to entry for smaller organizations and individual contributors
- It provides an opportunity for developers to further differentiate their solution by providing additional collateral that will help end users get started [#fastsecure](https://www.venafi.com/blog/why-fastsecure-future-machine-identity-management) when using the solution.

Meeting the requirements for Foundation Certification should be the first point of focus for any new developer.
These requirements have been designed to create a simple pathway for developers to get a listing onto the Venafi Marketplace, while ensuring a consistent, stable experience for all {{tlspk}} end users.
All {{tlspk}} solutions that are published on the Venafi Marketplace are required to meet the requirements for Foundation Certification.

Advanced Certification provides a means to differentiate an solution that goes above & beyond the requirements specified above.
Functionally, both Foundation Certification and Advanced Certification have the same technical requirements.
The difference between the two levels is really about end user enablement and ongoing testing to ensure the solution remains fully functional. 

From an end user's perspective, generally the more collateral available to be consumed, the less likely end users are to have questions that might block them from testing and ultimately utilizing the solution.
The easier it is to deploy and test the solution, the more widely adopted that solution becomes throughout the user base.
More users generate more feedback and ideas, and the solution becomes more robust as a result.

## Certification Requirements

=== "Foundation"

    1. The description of the solution is an accurate representation of functionality.
    2. The solution doesn't interfere with {{tlspk}} native functionality or performance.
    3. The solution was developed with overall security best practices in mind and makes no attempts to harvest user data.
    4. The solution uses generally available interfaces to interact with {{tlspk}} (jsctl, REST API, etc.).
    5. Accompanying documentation must be packaged with the solution and should include any necessary configuration instructions as well as clear usage examples. [Templates are provided](https://coolsolutions.venafi.com/ecosystem/example-solution-repo) for this purpose.
    6. The support model is clearly defined for all user types.
    7. A demonstration of all documented functionality must be [scheduled](https://venafi-service-certification.paperform.co) & completed with the Venafi Ecosystem team.

=== "Advanced"

    Everything listed in the Foundation Certification Requirements section tab be completed, in addition to the following:

    1. A 5-10 minute technical demonstration video covering any initial configuration and typical usage examples must be available online.
    2. When necessary, and if possible/feasible for the solution, a test instance or account will be provided to the Venafi Ecosystem team for internal testing and demonstration purposes.
    3. Automated testing must be put in place to test all documented functionality of your solution.
    4. All REST endpoints and/or jsctl functions used by the solution must be documented and provided to Venafi.
    These will be used internally by Venafi to track which features & functions are being used most by developers and end users.
    They will not be shared publicly.

!!! question "Do you have feedback about the certification process?"

    We've tried to make the certification process as simple and pain free as possible, but we're always looking to make it better.
    If you have any suggestions or feedback to improve the process, [we'd love to hear them](mailto:ecosystem@venafi.com?subject=Certification | {{tlspk}} | Feedback)!