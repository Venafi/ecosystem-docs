# Creating an application in Venafi as a Service

??? question "What is an application?"
    Creating an application gives you the ability to manage all aspects of your business critical applications.

    *Applications* are bundles of software that make up your site’s back end, from
    the operating system and web servers to APIs and programming frameworks. Each
    component provides a layer for their compatibility, and bundling them makes them
    easier to download and deploy all at once. The components of an Application can
    range from the general (an operating system) through to the specific (a
    particular PHP framework).

!!! DYK "Did you know?"
    The people who create and configure applications are typically {{rolesRO}}s.

<!-- SNIPPET BEGIN APPLICATION STEPS -->

1. In the menu bar, click **Organization > Applications**.

2. Click **New**.

3. In **Add an Application**, do the following:
    - Enter an **Application Name** for your new application.
    - (Optional) Enter a **Description**, which can be helpful to other users and
      teams who might need to know the purpose of your application.          
    - Select **Application Owners**, which can be both individual users or teams.
    - Select one more more **Certificate Issuing Templates**.

        !!! Tip "For {{ask}}"
            To use [{{ask}}](what-is-automated-secure-keypair.md), the template that you select must have a **Key Pair Generation** of either **Venafi or user generate key pair**
            or **Venafi generated key pair**.


    - In the **Assignment** field, type external FQDNs (hostname.domain.tld,
      such as www.mydomain.com), and internal FQDNs, IP addresses or ranges of
      addresses.

        !!! note "Note"
            If you don't know the FQDN or IP ranges, the application's name and owners are used as placeholders, then you can simply invite owners who can provide the details themselves.

    
4. When you're finished, click **Create**.

    You'll see your new application on the Applications page.

    Click the Application's name to see [details about and to edit](edit-or-delete-application.md) it.

<!-- SNIPPET END APPLICATION STEPS -->
