# Export an event log filter as an API endpoint

The API export feature gives you quick examples in several languages that you can use when working with the Venafi API.

From the Event log screen in {{vs}}, you simply create and apply a filter and then use the Export As option to get basic example code formatted in your selected language. Your required {{vs}} API key is added for you to the sample code. So all you need to do is run the example.

By customizing the attributes in the sample, you can control which (and how many) filter results are retrieved, per request.

![Screenshot of sample cURL code with attributes highlighted](img/ss-eventLogging-exportAPIendpoint-cURL-attributes.png)

Here's a quick attributes reference:

Attribute  | Use to... | Example
:------------ | :------------- | :--------------
pageSize | Indicates how many of the total filtered log entries you want the endpoint to return, per request. | <code>pageSize:10</code>
pageNumber | Specify which page of results you want to retrieve.<br /><br />For example, suppose that your filtered results include 100 total log entries and the pageSize attribute is set to 10. If you request page number *0*, you’ll get log items 1 through 10; if you request page number *1*, you’ll get log items 11 through 20, and so forth. | <code>pageNumber:2</code><br /><br />This example returns items 21 through 30, assuming your filter returns at least 30 total results.

For example, you could define filter criteria that returns all successful {{vs}} logins. You then export as cURL code and run it from the command prompt. You could then use it to create a feed in your application that returns the same values specified in your filter.

![Screenshot of cURL response to example export](img/ss-eventLogging-exportAPIendpoint-cURL-example.png)

!!! tip "Tip"
    Give it a try on [api.venafi.cloud](https://api.venafi.cloud/webjars/swagger-ui/index.html?urls.primaryName=activitylog-service){:target="_blank"}. Be sure to select **activitylog-service** from the **Select a definition** drop-down list.

## To export an event log filter as an API endpoint

1. Log in to {{vs}}.
1. Click **Settings** > **Event log**.
1. Create the filter you want to export.
1. Click **Export as** > **API Endpoint**.
1. Select your target language, and then click **Copy Code**.
1. Paste the code in your target tool. 
1. (Optional) Edit attribute values to control paging.
1. Run the copied code to retrieve results.

# Export an event log filter as a file
In addition to exporting event log filters as API endpoints, you can also export them in either JSON or CSV file format. 

!!! note "NOTE"
    Keep in mind that the number of entries is limited to no more than 10,000 event log entries per file. 

## To export an event log filter as a Json file or CSV file

1. Log in to {{vs}}.
1. Click **Settings** > **Event log**.
1. Create the filter you want to export.
1. Click **Export as** > **JSON/CSV**.

