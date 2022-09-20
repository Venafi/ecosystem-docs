# View total certificate instances

!!! tip inline end
    You can view certificate installations at **Inventory** > **Certificate Installations**.

To view the total number of certificate instances that your organization is
using, click your **Profile Icon** in the top right corner, and then click
**Account**. The **Total Certificate Instances** section shows the number.

## Retrieving an updated count

If you've made changes to your certificates or certificate installations, you
can click **Retrieve** to refresh the count.

## How is the number of certificate instances calculated?

**Total certificate instances** is the sum of the number of certificate
installations plus the number of certificates that have no installations. 
Trusted CA certificates are not counted.

!!! example
    The following scenario would add up to 10 certificate instances.
    
    - One certificate with five installations (5 instances)
    - Three certificates with one installation each (3 instances) 
    - Two certificates with no installations (2 instances)
