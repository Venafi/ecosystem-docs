# Functional Testing

<!-- TODO How does functional testing confirm the problem that was intended to be solved? How will functional test results be reported? Are there any performance considerations? What about certification and documentation? -->
During development of your **Issuer** solution, you should keep the following functional tests in mind for this design pattern.
The test cases listed below are directly related to the [requirements and considerations](../1-requirements-issuer) outlined for this use case.

{% include '.admonitions/what-is-functional-testing-admonition.md' %}

The functional tests documented below are provided as examples.
Depending on the supported functionality of the target platform/service you're building for and/or the complexity of your solution, some tests listed below may not be necessary.
Similarly, it's possible that you've got such a new or unique solution, that we haven't identified recommended functional tests yet.

If you've got suggestions and/or functional tests that helped during your development, [please let us know](mailto:ecosystem@venafi.com?subject=ecosystem.venafi.com feedback - Ingress Functional Testing)!

??? tip "Reduce Confirmation Bias"

    It can be extremely helpful, especially when writing documentation that accompanies your solution, to involve others on your team who haven't been involved in the development process.
    While you might be able to perform all functionality without even referencing the docs, it's possible that a fresh set of eyes will uncover typos or minor omissions that someone directly involved in development might miss.

## Basic Functionality Tests

<!-- TODO anything different cert-manager vs. TLS Protect for Kubernetes? -->
{% include 'testing/ft-issuers-basic.md' %}

## Advanced Functionality Tests

{% include 'testing/ft-issuers-advanced.md' %}
