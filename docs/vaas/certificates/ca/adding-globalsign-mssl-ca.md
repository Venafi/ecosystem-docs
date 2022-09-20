# Create a GlobalSign MSSL certificate authority

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete the CA configuration.

* A GlobalSign account. If you don't have an account yet, [go here to get started](https://www.globalsign.com/en/lp/venafi/).
* The GlobalSign Profile you want to use, if you have more than one Profile. 

</div>

## To create the CA

1. {% include 'ca/settings-ca.md' %}
2. Click **New** > **GlobalSign MSSL**.    
3. Enter a **Name** that this CA should be called in {{vs}}.           
4. From the **GlobalSign MSSL Server** drop-down, select either Production or Staging, depending on the purpose of this CA connector.
5. Enter the **Username** and **Password** provided by GlobalSign.
6. Click **Test Connection**. 
7. After a successful connection, GlobalSign returns available profiles. If just one profile is returned, it is shown, and you can click **Create**. 

    If multiple profiles are returned, select the one you want to use, and then click **Create**.
   
## What's Next

{% include 'ca/ca-whats-next.md' %}