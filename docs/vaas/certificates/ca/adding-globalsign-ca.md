# Create a GlobalSign Atlas certificate authority

<div markdown="1" class="prereqs">

You're going to need a few things to complete the CA configuration.

* A GlobalSign account. If you don't have an account yet, [go here to get started](https://www.globalsign.com/en/lp/venafi/).
* Your GlobalSign credentials file. If you don't have this file, contact GlobalSign support.

</div>

1. {% include 'ca/settings-ca.md' %}
1. Click **New** > **GlobalSign**.    
1. Enter a **Name** that this CA should be called in {{vs}}.           
1. Browse to your **Credentials File**.

    ??? question "How do I find my GlobalSign credentials file?"

        GlobalSign supplies the credentials file to you when you create your account.
        
1. Click **Validate**.
   
After you authenticate, we'll show you GlobalSign's validation policy. This is a
list of requirements that your certificate request must comply with before
GlobalSign will issue a certificate for you. We'll also display this
information, in a more readable form, when you start setting up policies for
your organization.

**Example validation policy**

```
{

'validity': {'secondsmin': 60, 'secondsmax': 7776000, 'notBeforeNegativeSkew': 200, 'notBeforePositiveSkew': 200},

'subjectDn': {

  'commonName': {

    'presence': 'REQUIRED',

    'format': '^([a-z0-9-_]+\\.)*(venafi\\.io|vfidev\\.com|thehotelcook\\.com)$'

  },

  'organization': {'presence': 'STATIC', 'format': 'Venafi, Inc.'},

  'organizationalUnit': {'isStatic': false, 'list': ['^.*$'], 'mincount': 0, 'maxcount': 3},

  'country': {'presence': 'STATIC', 'format': 'US'},

  'state': {'presence': 'STATIC', 'format': 'UT'},

  'locality': {'presence': 'STATIC', 'format': 'Salt Lake City'},

  'streetAddress': {'presence': 'FORBIDDEN', 'format': ''},

  'email': {'presence': 'FORBIDDEN', 'format': ''},

  'joiLocalityName': {'presence': 'FORBIDDEN', 'format': ''},

  'joiStateOrProvinceName': {'presence': 'FORBIDDEN', 'format': ''},

  'joiCountryName': {'presence': 'FORBIDDEN', 'format': ''},

  'businessCategory': {'presence': 'FORBIDDEN', 'format': ''}

},

'extendedKeyUsages': {

  'ekus': {

    'isStatic': true,

    'list': ['1.3.6.1.5.5.7.3.2', '1.3.6.1.5.5.7.3.1'],

    'mincount': 2,

    'maxcount': 2

  }, 'critical': false

},

'publicKey': {'keyType': 'RSA', 'allowedLengths': [4096, 3072, 2048], 'keyFormat': 'PKCS10'},

'publicKeySignature': 'FORBIDDEN'

}
```

## What's Next

{% include 'ca/ca-whats-next.md' %}