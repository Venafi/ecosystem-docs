# Requesting and viewing a certificate

You can easily request, download, and view a requested certificate using {{vs}}.

!!! important "Important" 

    Be sure that the [prerequisite steps](requesting-downloading-installing-certificates.md) 
    have been completed before you start.
    
!!! note "Note"  
        
    You can only submit certificate requests for applications where you are [listed as an 
    owner](edit-or-delete-application.md#owner). Also, the application must have at least one 
    [certificate issuing template assigned](edit-or-delete-application.md#cit) to it.

    If either of these are not met, [edit the application](edit-or-delete-application.md) before proceeding.


## To request a certificate

1. In the menu bar, click **New > Certificate Request**.

    or

1. From the **Organization** > **Applications** screen, select the checkbox next
   to the application, and then click **Request Certificate**.

1. In **Installation Settings**, choose the application where the certificate
   will be installed. Click **Next**.

1. From the **Application** drop down, choose the application that this request is for.

    ??? question "Why don't I see the application I'm looking for?"
        Only applications that meet the criteria listed in the note above will
        show up. Make sure the application meets those criteria.
    
2. Select the correct **Certificate use-case**
   
    ??? question "What is a certificate use-case?"
        The certificate use-cases listed here represent the certificate 
        issuing templates assigned to the application. If you're not sure 
        which one to pick, check with your {{rolesPKI}}.
    
1. Click the radio button for the **Request method** you want to use. If one of the
   buttons is grayed out, the {{rolesPKI}} has disabled that option in the
   issuing template.

    === "Venafi automated certificate request"
        Complete the fields. Depending on the issuing template, some fields may 
        be pre-populated and others may be locked. 
        
        For fields that you can edit, make sure that they conform the guidelines 
        in the **Use-case CSR and security requirements** column on the right.

        After you've completed the fields, click **Submit Request**.
   
    === "Generate CSR and private key myself"
        Generate a CSR, and paste it into the **CSR Upload** field. Then click
        **Submit Request**.

The request is now sent to the CA specified on the issuing template. 

## View the certificate request

1. In the menu bar, click **Inventory > Certificate Requests**. By default, the
   most recent request should be at the top of the list. 
   
2. If there are default filters set, click **Clear Filters**.

    ![Screenshot of the clear filters button](clear-filters.png)
    
3. Click **Filter** and then enter a piece of information you know about the
   certificate (for example, its domain name or owner).

4. Click Apply.

    The list changes to display certificates with the criteria you specified.
    
5. Click a certificate's tile to see details about it.

