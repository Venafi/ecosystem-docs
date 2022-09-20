# Finding your Azure Tenant, Subscription, and Application IDs and Client Secret

In order to connect Azure to {{vs}}, you'll need to provide us with your
Azure Tenant ID and Subscription ID. 

??? optional-css-class "To find your Azure Tenant ID"

    !!! Important "Your Azure Tenant ID is the same as your Azure Directory ID."

    1. Log in to your [Azure portal](https://portal.azure.com/).
    1. In Azure's left navigation pane, click **Azure Active Directory**.
    1. Click **Properties**.
        Your Directory ID is displayed on the Properties page.
        ![Find tenant ID](Find_tenant_ID.png)

??? optional-css-class "To find your Azure Subscription ID"

    1. Log in to your [Azure portal](https://portal.azure.com/).
    1. In the Search field, type the word *subscription*.
    1. Click **Subscriptions**.
    1. Find the subscription you want, then copy its Subscription ID.
        ![Find subscription id](Condor_find_subscription_ID.png)

??? optional-css-class "To find your Azure Application ID"
 
    1. Log in to your [Azure portal](https://portal.azure.com/).
    1. In Azure's left navigation pane, click **Azure Active Directory**.

        ![Application registration](Condor_Azure_application_ID.png)

??? optional-css-class "To obtain your Azure Client Secret"

    1. Log in to your [Azure portal](https://portal.azure.com/).
    1. In the left pane, click **Azure Active Directory**.
    1. In the white pane, click **App registrations**.
    1. Click **New application registration**.
    1. Enter the required information, then click **Create**.
    1. Above Display name, click **Settings**.
    1. In the right pane, click **Keys**.
    1. In Passwords, enter the Key description and specify the Duration.
    1. Click **Save**.
        The Client Secret is displayed under Value. 

        ![Locate Client Secret](Condor_Azure_client_secret.png)

    1. Copy the key value (Client Secret).

    !!! important Important 
        You won't be able to retrieve the key value (client secret) after you leave the blade.