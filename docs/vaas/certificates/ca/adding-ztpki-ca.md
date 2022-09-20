---
article: a
caname: Venafi Zero Touch PKI
---

# Adding a Venafi Zero Touch PKI certificate authority

<div markdown="1" class="prereqs">

## Before you begin

You're going to need a few things to complete the CA configuration.

**{{hid}} account**

Venafi Zero-Touch PKI relies on the {{hid}} PKI service. If you don't already have
an account, you'll need to set that up first. To get started, go to the [Venafi Marketplace](https://marketplace.venafi.com/ui/xchange-marketplace-app/620d2d6ed419fb06a5c5bd36/solution/62aa21af15769f6ffe69b866) to get started.

To set up this CA, you'll need the following from {{hid}}:

- Zero Touch PKI URL
- API Key ID
- API Key

</div>

## To set up the CA

### Set up the connection

1. {% include 'ca/settings-ca.md' %}
1. Click **New** > **Venafi Zero Touch PKI**.
1. Enter a **Name** that this CA should be called in {{vs}}.
1. In the **Server URL** field, select the URL provided by {{hid}}.
1. Enter the **API Key ID** and **API KEY** provided by {{hid}}.
1. Click **Test Connection**.

## What's Next

{% include 'ca/ca-whats-next.md' %}