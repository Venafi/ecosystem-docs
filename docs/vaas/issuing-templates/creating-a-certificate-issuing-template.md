# Creating a certificate Issuing Template

Issuing Templates combine the selection of a CA account with rules that enforce
certificate policy, all in a single location. Issuing templates can be edited
(individually or in bulk), copied, or deleted.

Once the issuing templates are created, {{rolesRO}} can add them to their
[applications](creating-an-application), and then submit certificate requests
using the issuing templates.

!!! important "Important"
    You must be a {{rolesSA}} or {{rolesPKI}} to do this.

## <a name="template"></a>To create an issuing template

<!-- !!! question "What's the difference between *issuing rules* and *recommended settings*?"

The fiels in the certificate issuing template allow you to create *issuing rules*, which give you the ability to restrict fields to one or more values. 

Creating an issuing template allows you to require certain values to be used for any certificate request that is made using this issuing template. 

When you create an issuing template, you will see a **Recommended Settings** column on the right side of the page.

Recommended Settings pre-populate the fields on a certificate request. However, Resource Owners will be able to change those values on certificate requests.

On the other hand, Issuing Rules allow you to require a specific value in order for a certificate request to be submitted.

Note that you can use both recommended settings and issuing rules in the same issuing template. If both a recommended setting and an issuing rule are applied to the same field, the issuing rule takes precedence.    -->

<div markdown="1" class="prereqs">

## Before you begin 

- You should already have [configured the certificate
authority](adding-a-certificate-authority.md) you plan to use in your issuing template.

- If you are creating a template for a {{dc}}, {{ent}}, {{ztpki}}, or {{adcs}}
certificate authority, you'll be asked to select a *product option*. The
available options are pre-populated in {{vs}} with data from the CA.

</div>

1. Click **Settings** > **Issuing Templates**.
2. Click **New**.
3. Enter an **Issuing Template Name**.
4. From the **Certificate Authority** drop-down, select the CA you will use for
   this template.
5. (Conditional) If you selected a {{dc}}, {{ent}}, {{adcs}}, or {{ztpki}}
   CA in the previous step, you will see the **Certificate Authority Product
   Option** field. Select a product option. 

    Additional fields may appear as required by your CA. Verify the values in those fields and change
   them as necessary.

6. Select an option for **Key Generation**.

    !!! info
        To use [{{ask}}](../automated-secure-keypair/what-is-automated-secure-keypair.md), select one of the VaaS generated options.

7. (Optional) Customize the template's default **Validity Period**.

    **The recommended value is 90 days.** The minimum setting is 1 hour.

    !!! info
        Be aware that when the CSR is submitted and the validity period requested exceeds that allowed by the CA, an error message will be returned.

8. Complete the **Common Name**, **Subject Alternative Names**, and **CSR Parameters** fields.

     - These fields accept [regular expressions](../issuing-templates/c-templates-using-advanced-rules-regex.md).
     - Additional SAN types are available by clicking the **Show Advanced SAN options** drop-down.
     - The **Common Name** and **Subject Alternate Name** fields also include a **Test** button, which allows you to test your regular expressions.

    !!! tip "Tips for completing these fields"
        - Leaving `.*` will require a value for that field when filling out the certificate request form, though _any_ value will match.
        - Leaving the field blank disables the field on the certificate request form.
        - Entering a single value will require the certificate request form to match that value.
        - Entering multiple values will require certificate requests match _one_ of the specified values.
        - Adding `^$` as one of the permitted values will allow that field to be left blank on a the certificate request form.
  
            This is the default behavior when submitting requests using the API.

        - You can disable or remove required validation for any field. See the tip below instructions.

    !!! tip "Enabling, disabling, and validating fields"
        The common name, SAN, and CSR Parameter fields can be enabled or disabled. Disabling a field prevents that field from being set on certificate requests that use this template.
        
        Also, for enabled fields, you can specify whether that field requires validation when {{rolesRO}}s submit certificate requests using this template.

        To change these settings for any field, click the menu button ![Image of the field menu button](./img/Icon_bypass_this_field.png) next to the field. 

9. Select the **Key Algorithm** types you want to allow.

10. Select an **Extended Key Usage** type. The valid values are **Client Authentication**, **Server Authentication**, and **Any**. If you want to allow all uses, select **Any**.

    !!! question "What is Extended Key Usage?"
        Extended key usage (EKU) allows you to select the purpose of the public key contained in the certificate and restrict usage of the public key to only those purposes defined by the EKU settings. 

11. In the **Resource Consumers** section, specify who should be able to assign this template to applications.

    - To allow all users to use this template, enable **Allow everyone to consume**.
    - Otherwise, select specific users in the **Resource Consumers** field, and then click **Add**.

    !!! info
        Selecting neither option means that this template won't be available for {{rolesRO}}s to assign to any applications.

12. Click **Save**.

## What's next
To use a certificate issuing template, you must associate it with an
application. The template you just created should now be ready to assign to [applications](../application/creating-an-application.md).