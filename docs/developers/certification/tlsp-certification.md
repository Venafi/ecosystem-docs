## **Introduction**

This page is meant to be your home base throughout the certification process, so please feel free to jump around, read ahead, bookmark and come back to it as needed. 

??? question "Ready to certify?"

    If you've already completed your integration and are ready to submit a request for Certification, you can [start here.](#certification-process)

As a **TLS Protect Cloud Certified** integration, Venafi users have an extra level of confidence that your solution was designed with their best interests at the forefront. For that reason, certified integrations see more adoption from our mutual customer base. When building an integration to TLS Protect Cloud, one desired outcome should be official certification. Official certification is the first step to listing the integration on the [Venafi Marketplace](https://marketplace.venafi.com), which is the #1 way end users discover and deploy integrations.  

!!! success ""

    Certification is the only way that an integration will be listed on the Venafi Marketplace as compatible with TLS Protect Cloud. 

![Certify](assets/images/certification/certify-chart.png)

The TLS Protect Cloud Certification Program is still evolving and so some specifics about the following requirements are subject to change. Ample notice will be given to any developers of an existing certified integration, ensuring plenty of time to make any necessary updates to maintain certification.

The following requirements are applicable to every TLS Protect Cloud integration, however there may be additional, unlisted requirements depending on the specific use case of the integration. There will be integrations and use cases that come forward that are totally new and unique from every integration that has gone through the certification process - and that’s GREAT! It means {{mim}} is continuing to evolve and see continued adoption.

!!! note "We're all in this together"

    In cases where the Venafi team requests additional requirements be met, we will work with you to determine what success looks like and do our best to provide any tools/guidance necessary to reach certification.

### **Technical Certification vs. Partner Program**

The technical certification process is not to be confused with Venafi Partnership, though the two are related. The best way to think about it would be “Packaging” vs. “Marketing.”

#### **Packaging**

The final step of the TLS Protect Cloud certification process will be ***Packaging*** - deciding how end users will deploy and interact with your integration. In order for end users to discover the integration and establish a strong user base, the packaging of the integration should be polished and easy to understand. Use of company logos, iconography, product names, marketing copy, etc. will all help users quickly identify your integration in the growing [Venafi Marketplace](https://marketplace.venafi.com). 

![Package](assets/images/certification/package-chart.png)

#### **Marketing**

***Marketing***, on the other hand, focuses on bringing attention to a fully packaged & published integration. Once the integration has been certified and the initial Marketplace Listing has been created, the next logical step would be an official partnership with Venafi, which will also engage the Venafi Partner Marketing team to start making some noise about the new solution available to Venafi users.

## **Certification Requirements**

There are currently two levels of certification for TLS Protect Cloud integrations, `Foundation Certification` and `Advanced Certification`. It's our hope that every developer strives for the most comprehensive integration, but understand that isn't always possible due to resource and/or time constraints. The purpose of creating two levels of certification is two-fold:

- It provides a lower barrier to entry for smaller organizations and individual contributors
- It provides an opportunity for developers to further differentiate their integration by providing additional collateral that will help end users get started [#fastsecure](https://www.venafi.com/blog/why-fastsecure-future-machine-identity-management).

### Foundation Certification

Meeting the requirements for `Foundation Certification` should be the first point of focus for any new developer. These requirements have been designed to create a simple pathway for developers to get a listing onto the Venafi Marketplace, while ensuring a consistent, stable experience for all TLS Protect Cloud end users.  All TLS Protect Cloud integrations that are published on the Venafi Marketplace are required to meet the requirements for `Foundation Certification`.

#### **Foundation Certification Requirements**

1. The description of the integration is an accurate representation of functionality.
2. The integration doesn't interfere with TLS Protect Cloud native functionality or performance.
3. The integration was developed with overall security best practices in mind and makes no attempts to harvest user data.
4. The integration uses generally available interfaces to interact with TLS Protect Cloud (REST API, Vcert, etc.).
5. Accompanying documentation must be packaged with the integration and should include any necessary configuration instructions as well as clear usage examples. [Templates are provided](https://coolsolutions.venafi.com/ecosystem/example-integration-repo) for this purpose.
6. The support model is clearly defined for all user types.
7. A demonstration of all documented functionality must be [scheduled](https://venafi-service-certification.paperform.co) & completed with the Venafi Ecosystem team. 


### Advanced Certification

`Advanced Certification` provides a means to differentiate an integration that goes above & beyond the requirements specified above. Functionally, both `Foundation Certification` and `Advanced Certification` have the same technical requirements. The difference between the two levels is really about end user enablement and ongoing testing to ensure the integration remains fully functional. 

From an end user's perspective, generally the more collateral available to be consumed, the less likely end users are to have questions that might block them from testing and ultimately utilizing the solution. The easier it is to deploy and test the integration, the more widely adopted that solution becomes throughout the user base. More users generate more feedback and ideas, and the integration becomes more robust as a result.

#### **Advanced Certification Requirements**

Everything listed in the [Foundation Certification Requirements](#tier-0-certification-requirements) section, above, must be completed, in addition to the following:

1. A 5-10 minute technical demonstration video covering any initial configuration and typical usage examples must be available online.
2. When necessary, and if possible/feasible for the integration, a test instance or account will be provided to the Venafi Ecosystem team for internal testing and demonstration purposes.
3. Automated testing must be put in place to test all documented functionality of your integration.
4. All REST endpoints and/or VCert functions used by the integration must be documented and provided to Venafi. These will be used internally by Venafi to track which features & functions are being used most by developers and end users. They will not be shared publicly.

## **Certification Process**

We've tried to make the certification process as simple and pain free as possible, but we're always looking to make it better. If you have any suggestions or feedback to improve the process, we'd love to hear them! Please send any feedback to Paul Cleary (paul.cleary@venafi.com).

Once your integration has been built and been tested internally by your team, you've produced any accompanying documentation, and you've recorded a short video demo walking through each supported function of your integration, your project is ready for certification!

### **Please [click here](https://venafi-service-certification-request.paperform.co) to submit a Certification Request.** 

## **FAQs**

**QUESTION: Will my integration be listed on the Venafi Marketplace if I don't pursue official certification?**

ANSWER: Your integration may still be listed if it works with Venafi Trust Protection Platform, but it will not be listed as officially compatible with TLS Protect Cloud and will not have the official badge of certification.

---

**QUESTION: How long will the certification process take?**

ANSWER: The certification process itself moves relatively quickly - you've already done the time-consuming part building and documenting the integration. Once you've submitted a Request for Certification, it typically takes only a couple of days to schedule the final milestone demo (a short session for you to demonstrate the described functionality to the Venafi Ecosystem team).

---

**QUESTION: Will I receive any marketing assets that I can use on my own websites and collateral?**

ANSWER: Yes, definitely! We love seeing Venafi certification badges out in the wild. Official badges will be provided upon completion of the certification process.  

---

**QUESTION: How often will I be required to re-certify my integration?**

ANSWER: Great question - thanks for asking! For now, we'd like you to re-certify for any Major release or feature addition/enhancement. Minor releases don't require re-certification. If you've just released a new Major version or added a new feature, **please [click here](https://venafi-service-certification-request.paperform.co) to submit a new Certification Request.** 

## **Resources**

- [Example Integration Repo](https://coolsolutions.venafi.com/ecosystem/example-integration-repo) - This provides a thorough example of how the README.md file should be created to be most impactful for Venafi users. Rather than creating Word documents or PDFs, <mark>**all documentation should start in Markdown**</mark>, which provides better version control and can then be easily translated to other formats as needed.
- [TLS Protect Cloud API Documentation](https://docs.venafi.cloud/api/c-cloud-api/)
- [Venafi Marketplace](https://marketplace.venafi.com) - Explore the Marketplace to get an idea about some of the existing integrations to Venafi. 
