# Filtering the certificate inventory

The certificate inventory can grow to thousands of certificates. In order to
help you find the certificate you're looking for, {{vs}} provides robust filtering capabilities.

You can create and save filters for quicker recall of the ones you regularly.

## Open the certificate inventory

Open the certificate inventory by going to **Inventory** > **Certificates**. At
the top of the inventory list, you'll see filtering options:

<div class="vaas-img" markdown="1">
![screenshot of filtering options](search-options.png)
</div>

## Using the free-text filter box

When you enter key words into the free-text filter box and click **Apply**, {{vs}} filters on the following certificate fields:

* Subject DN Common Name
* Subject Alternative Names DNS

<div class="vaas-img" markdown="1">
![screenshot showing the location of the Subject DN Common Name and Subject Alternative Name DNS fields](dncn-sandns-fields.png)
</div>

Click **Add Criteria** to refine your filtered results.

## Using the filter selector

Click the **Filter** button to open the filtering panel.

There are many filtering options available in the filtering panel, allowing you
to get very specific and refined results. The following tips will help you
get the results you want:

!!! tip "Tips for using the filter panel"
    * When you select two criteria values from the same filter, the filter uses the
      OR operator. When you select two or more unique filters, the filters use the
      AND operator. 

        <div class="vaas-img" markdown="1">
        ![Screenshot of certificate inventory filter](Condor_cert_filter_logic-diagram.png)
        </div>

    * **Domain Name** searches both the Common Name and Subject Alternative Name DNS
      fields. 

    * After you click **Apply**, your filter will be shown at the top of the certificate inventory.

        <div class="vaas-img" markdown="1">
        ![Screenshot of search filter location](Condor_cert_filter_verification.png)
        </div>

    * The search box and the filter can be combined into a single search

## Saving a search filter 

Saving search filters is a quick way to run a search without having to re-enter
all the search parameters. 

1. After you've built your search filter, click **Save** next to the search filter summary.
2. Enter a **Name** for the search filter.
3. If you want this filter to be applied by default every time you open the
   certificate inventory, select the **Set as default search** checkbox.
4. Click **Save**.

Your saved search is available from the search type selector button. From here, you can also
select a new default search filter or delete any saved queries.

![Screenshot of saved search](saved-search.png)