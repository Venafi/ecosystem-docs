# Assigning or reassigning a certificate to an application
Discovery finds and brings into your inventory many certificates that have not
been assigned to an application. {{vs}} allows you to assign these
certificates to their appropriate applications.

## To find unassigned certificates

1. After discovery is complete, in the menu bar, click **Inventory** >
   **Certificates**.
1. Click **Filter**.
1. Set properties, discovery, expiration, and installation filters, as needed.
1. In **Applications**, select **Not assigned to an application**.
1. Click **Apply**.

    A re-filtered certificate list is displayed.

## To assign a certificate to an application

1. Select one or more certificates that you want to assign to one or more
   applications.
1. Click **Assign > Assign Certificates**.
1. In **Assign Certificates**, specify the application(s) to which you want to
   assign the certificate(s).
1. Click Assign.

    You'll see a notification that the certificate was assigned to the application.

??? optional-css-class "Reassign a certificate to a different application"
    1. Click **Filter**.
    1. Set properties, discovery, expiration, and installation filters, as needed.
    1. In **Applications**, select **Assigned to any application**.
    1. Click **Apply**.
        A re-filtered certificate list is displayed.

??? optional-css-class "Remove a certificate's assignment to an application"
    1. Click **Filter**.
    1. Set properties, discovery, expiration, and installation filters, as needed.
    1. In **Applications**, click in the field to open a list of applications.
    1. Select the application(s).
    1. Click **Apply**.
    1. In the certificate list, select the certificate(s) you want to remove from the application(s).
    1. Click **Assign > Clear Assignments**.
    1. Click **Clear**.
        You'll see a notification that the certificate was removed from the application(s).
