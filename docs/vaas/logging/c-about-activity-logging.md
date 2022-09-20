# Overview: event logging

The Event Log shows a list of events logged as a result of either user actions or {{vs}} operational activities. Use event logging as a method for troubleshooting, or as part of your organization's security practices by identifying unusual activity.

Event logging can help you understand who is doing what in your organization's {{vs}} account by classifying information by resource type or the kind of action taken, such as create, read, update and delete (CRUD). To highlight important items from less important items, event logging identifies items as either informational or important.

To help you find important data points in the event log, you can create and save filters, and even set one as your default filter for the next time you visit the event log. To help keep things tidy, delete the filters you no longer need or use.

## What gets logged?

{{vs}} logs both user-driven events, as well as events that occur as part of ongoing {{vs}} operational activities.

## How do filters work?

Filters are a quick way of narrowing logged data to show just the information you need.

[Filters are easy to use](t-create-apply-activityLogging-filter.md). You simply select and combine available filters to reduce all logged items down to a specific set of results.

??? optional-css-class "EXAMPLE: Limit event log to show only failed login attempts"
    Suppose you wanted to identify which users are experience problems logging in to {{vs}}. From the Event Log page, you could create a filter for identifying failed {{vs}} login attempts.

    ![Screenshot of example filter that shows only failed login attempts](img/ss-eventLogging-filtering.png)

    The results of the filter show you which users have experienced login failures, and when those failures occurred.

If you're a developer, you can even [export filter results to either an API endpoint or a file](c-logging-export.md).

## What's next

- [Give it a try!](t-create-apply-activityLogging-filter.md) Filter the list of logged events based on your own criteria.
- [Learn how to create and manage your own filters]()
- If you're writing code, learn how to [export your filter results to use with an API endpoint or to export it as a file](c-logging-export.md).
