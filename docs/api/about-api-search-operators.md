# About API search operators
As part of a search expression, operators filter data on a
`certificatesearch`, `certificateinstancesearch`, or `managedcertificatesearch`.

You can find certificates or certificate instance information more quickly by
using the appropriate expression operator in the JSON body.

**Example expression operator that appears in a JSON body**
```json

  "expression": {
    "operands": [
      {
        "field": "sslProtocols",
        "operator": "FIND"
        "values":["TLS","SSL"]
      }
    ]
  },    ...
```
The following table shows the set of operators for filtering data. You can use
the examples in this table  in the JSON body of the `certificatesearch` or
`certificateinstancesearch` API calls. To search for certificates, enclose
parameters in quotes unless otherwise specified. 

| Operator | Name |	Description and Usage |
| ----------- | ----------- | ----------- | 
| EQ | Equal operator |	The search result is equal to the specified value. Valid for numeric or Boolean fields. For example, to find certificates that are not self-signed, specify  `"field": "selfSigned", "operator": "EQ",         "value": false`. |
| FIND | Find operator | The search result is based on the value of all or part of one or more strings. You can also use Regular Expressions (regex). For example, to find certificates that use any version of Transport Layer Security, specify `"field": "sslProtocols", "operator": "FIND", "value":"TLS"`. |
| GT | Greater than relational operator |	The search result has a higher numeric value than the specified value. For example, to find certificates that are valid for a period that is longer than ten days, specify `"field": "validityPeriodDays", "operator": "GT", "value": 10`. |
|GTE |Greater than or equal to relational operator	| The search result is equal or has a higher numeric value than the specified value. For example, to find certificates that are valid for a period of ten or more days, specify `"field": "validityPeriodDays", "operator": "GTE", "value": 10`. |
| IN | In clause | The search result matches one of the supplied list of parameters that are enclosed in parentheses. Valid for strings. You can also use regex. For example, to find subject CNs, use wild cards. `"field":"subjectCN","operator":"MATCH","values":[".*venafi[.]com",".*venafi[.]net"]}`. |
| LT | Less Than relational operator | The search result has a lower value than the specified value. For example, to find certificates that are valid for a period that is less than ten days, specify `"field": "validityPeriodDays",      "operator": "LT",  "value": 10`.|
| LTE | Less than or equal to relational operator |	The search result is equal or less than the specified value. For example, to find certificates that are valid for a period of ten days or less, specify `"field": "validityPeriodDays", "operator": "LTE", "value": 10`. |
| MATCH | Match operator |The search result includes a string value from the supplied list. You can also use regex for your search. <ul><li>To match one property, specify value and a string in quotes. For example,  `"field": "cipherSuitesSecurityStatus", "operator": "MATCH", "value": "DEPRECATED"`.</li><li>To match multiple properties, specify values and an array of comma separated strings in quotes. For example,  `"field": "cipherSuitesSecurityStatus", "operator": "MATCH", "values": ["DEPRECATED", "UNKNOWN"]`.</li></ul> | 
<!-- 
| MOD	Modulus operator | The search result from the modulus of a numeric field. Specify values and an array of the Modulus and expected remainder that makes the result true.  ![Linux mascot](Cloud_API_Modulus.png)

For example, `"field": aaa, "operator": "MOD", "values": [ 10, 1]` means if field aaa divided by 10 has a remainder of 1, return the corresponding data or result.
-->
