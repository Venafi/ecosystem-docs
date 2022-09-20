# Provision certificates to machines

{{vs}} can provision certificates directly to certificate keystores of machines that are defined. If you've not yet created the machine to which you want to provision the certificate, [start there first](create-a-new-machine.md). Otherwise, follow the steps below.

<div markdown="1" class="prereqs">

## Before you begin

- The certificate you want to provision should already be in the {{vs}} [certificate inventory](../certificates/using-filters-to-find-certificates.md) and requested using [Automated Secure Keypair](what-is-automated-secure-keypair.md).
- The machine should already be created in {{vs}}.

</div>

## F5 BIG-IP LTM

<p class="stepIntro">You can provision a certificate to an existing SSL profile on your F5, or you can use {{vs}} to create a new SSL profile for you. The steps below walk you through both scenarios.</p>

1. In the {{vs}} toolbar, click **Machines**. The Machines list opens.
2. Click the checkbox next to the F5 BIG-IP LTM machine that you want to provision a certificate to.
3. Click **Provision a certificate**.
4. From the **Choose a certificate from the inventory** field, begin typing the certificate name you want to provision. Click the certificate when you see it listed.

    Verify that you've selected the correct certificate by reviewing the subject DN, validity, and fingerprint.

5. In **Certificate Name**, enter the name for this certificate as you want it to appear on your F5.

    ??? question "What if the name is already in use on the F5?"
        When provisioning a certificate to the F5, {{vs}} checks to see if the name you enter in this field is already in use. 

         - If the name you enter isn't in use, {{vs}} will use it.
         - If the name is in use, {{vs}} checks to see if it's the same certificate. If so, {{vs}} uses the certificate that is already on the F5.
         - If the name is in use, but it's a different certificate, then {{vs}} creates a new certificate. A unique certificate name will be generated using a combination of the certificate name entered in this field, the expiration date from the certificate, and a unique numerical value, such as `my-cert-name_22Oct05_3117`.

6. In **Chain Bundle Name**, enter the name for the CA certificate bundle as you want it to appear on your F5.  

    !!! note
        The bundle name must not exist or must already contain the chain CA certificates and may contain other certificates.

7. From the **Profile Type** drop-down, select either **Client SSL Profile** or **Server SSL Profile**, depending on the type of F5 profile you're provisioning to.
8. In the **Partition** field, enter an F5 partition name. This partition must already exist on the F5. Leaving this field blank will default to the F5's `Common` partition.
   
    !!! note
        The partition name is case sensitive.

1. In the **Parent Profile** field, enter the name of the parent profile you want to associate with the SSL Profile.

    !!! note
        If you're using an existing SSL Profile in the next step, this field will be ignored. {{vs}} will not modify the parent profile of existing SSL profiles.

2. In the **SSL Profile** field, enter an SSL profile name. This can be either a name that is already in use on the F5 partition, or a new name.

    ??? question "What happens if the name is already in use?"

        If the profile name you enter already exists in the F5 partition you entered previously (see step 8 above), then {{vs}} will provision the certificate to that profile. Otherwise, {{vs}} creates a new profile using the name you enter here.

3.  For Client SSL Profiles, you can optionally enter an alternative DNS name for Server Name Indication in the **SNI** field.

    !!! warning
        If you're editing an existing SSL profile, any current Server Name value will be overwritten if you enter a value you here.

4.  If you don't want the certificate to be pushed when you save, click the **Push upon saving** slider to No.
5.  Click **Save**.

After saving, the certificate is pushed to the F5 profile that you specified, and a machine identity is created in the **Machine Identities** tab. If you created a new SSL profile, that profile is now ready to be assigned to a virtual server or https health monitor on the F5.

## Microsoft IIS

1. In the {{vs}} toolbar, click **Machines**. The Machines list opens.
2. Click the checkbox next to the Microsoft IIS machine that you want to provision a certificate to.
3. Click **Provision a certificate**. The **Provision a certificate** modal opens.
4. From the **Choose a certificate from the inventory** field, begin typing the certificate name you want to provision. Click the certificate when you see it listed.

    Verify that you've selected the correct certificate by reviewing the subject DN, validity, and fingerprint.

5. From the **CAPI Store** drop down, select the certificate store you want the certificate installed in. The Web Hosting store is recommended for certificates used by IIS.
6. Enter a **Friendly Name** for this certificate. The certificate will appear with this name when used in IIS.
7. In the **IIS Web Site Name** field, enter the site from your IIS server that you want to provision the certificate to.
8. If you want {{vs}} to create a new binding if a matching binding isn't found, click the **Create Binding if not found** slider.

    ??? question "What happens if I don't choose this and the binding doesn't exist?"

        If the specified binding doesn't exist and you've told {{vs}} not to create it, the certificate will be added to the CAPI store, and provisioning will result in an error.

9. In the **Binding IP Address** field, enter an IP address that is bound to Windows. The certificate will be available only for the IP address you enter here.  Leave the field empty if you want the certificate to be available an all of the Windows server's IP addresses.
10. In the **Binding Port**, enter a port number to add to the binding.
11. In the **Binding Hostname**, enter a hostname to add to the binding if you want the binding to use Server Name Indication (SNI).
12. If you don't want the certificate to be pushed when you save, click the **Push upon saving** slider to No.
13. Click **Save**.

## Common KeyStore

1. In the {{vs}} toolbar, click **Machines**. The Machines list opens.
2. Click the checkbox next to the Common KeyStore machine that you want to provision a certificate to.
3. Click **Provision a certificate**.
4. From the **Choose a certificate from the inventory** field, begin typing the certificate name you want to provision. Click the certificate when you see it listed.

    Verify that you've selected the correct certificate by reviewing the subject DN, validity, and fingerprint.

5. From the **KeyStore Type** drop-down, select a type.

    === "PEM"
        1. Enter the **Certificate Path**, **Private Key Path**, and **Certificate Chain Path** values.
        2. In the **Key Password** field, enter the private key's password if it should be encrypted.
        3. In the **Service Name** field, enter the name of the service to restart after provisioning the certificate.
        4. If you don't want the certificate to be pushed when you save, click the **Push upon saving** slider to No.
        5. Click **Save**.

    === "JKS"
        1. Enter the **KeyStore Path**, **Alias**, and **Store Password** values.
        2. In the **Key Password** field, enter the private key's password if it should be different than the Store Password.
        3. In the **Service Name** field, enter the name of the service to restart after provisioning the certificate.
        4. If you don't want the certificate to be pushed when you save, click the **Push upon saving** slider to No.
        5. Click **Save**.

    === "PKCS#12"
        1. Enter the **KeyStore Path** value.
        2. In the **Key Password** field, enter the private key's password.
        3. In the **Service Name** field, enter the name of the service to restart after provisioning the certificate.
        4. If you don't want the certificate to be pushed when you save, click the **Push upon saving** slider to No.
        5. Click **Save**.