# Working with Trusted CA Certificates

From the **Trusted CA Certificates** page in {{ vs }}, you can add, download,
and delete trusted certificates.

??? optional-css-class "What is a CA Certificate?"
    A CA certificate is a digital certificate issued by a certificate 
    authority (CA), so that SSL clients, such as web browsers, can 
    use it to verify the SSL certificates signed by the CA.

## View Trusted CA certificates

1. In the menu bar, click **Inventory** > **Trusted CA Certificates**.
1. In the left navigation pane, click the certificate you want to view. The
   details open in the right pane.

## Add a trusted CA certificate using a Base64 encoded text file

1. In the menu bar, click **Inventory** > **Trusted CA Certificates**.
1. In the toolbar, click **Add**.
1. Using either the **Paste Base64 encoded text** or **Upload files** option,
   either paste or upload the certificates you want to add. You can upload up to
   200 certificates at a time.

    !!! note
        The certificates must be encoded in Base64 format. 

1. When you're done, click **Add**.

You'll see your new CA certificate in inventory and can download it.

## Download a Trusted CA certificate

1. In the menu bar, click **Inventory** > **Trusted CA Certificates**.
1. In the left navigation pane, click the certificate you want to download.

    !!! note
        You can only download one certificate at a time.

1. In the toolbar, click **Download**. 


## Delete a trusted CA certificate

!!! warning  
    Keep in mind that any certificate that chains to the deleted certificate
    will be marked as *Distrusted*.

1. In the menu bar, click **Inventory** > **Trusted CA Certificates**.
1. In the left navigation, click the certificate you want to delete. If you want
   to delete multiple certificates, click the checkbox next to each certificate
   you want to delete.
1. In the toolbar, click **Delete.**
