# About API search fields

As part of a search expression, the field is a certificate property or field
name to use for a `certificatesearch`, `certificateinstancesearch`, or
`managedcertificatesearchfunction` function. If you need the field names, you
can customize and run one of the search examples found in this section and then
gather the field names from the response.

Example of using a field in a search request 

```json
{
   "expression":{
      "operands":[
         {
            "field":"poodleVulnerable",
            "operator":"EQ",
            "value":"true"
         }
      ]
   }
}, ...
```
   
## Common search parameters
  
The following table shows commonly used field search parameters. You can use the
`certificatesearch`, `certificateinstancesearch`, or
`managedcertificatesearchfunction`. To search for certificates, enclose
parameters in quotes unless otherwise specified. 

  |Retrieve Certificates&nbsp;by | Field and predefined<br> search values | Example search expression |
  | ----------- | ----------- | ----------- |
| Certificate validity period | validityPeriodDays | "field": "validityPeriodDays","operator": "LT","value": 10 |
| Cipher suites security status | cipherSuitesSecurityStatus and one or more values: <ul><li>UNKNOWN</li><li>DEPRECATED</li><li>LEGACY</li><li>STRONG</li></ul>| "field": "cipherSuitesSecurityStatus", "operator": "MATCH", "values": ["DEPRECATED", "UNKNOWN"] |
| Expiration date | validityEnd |"field": "validityEnd", "operator":"MATCH", "value":"2018-01-25T17:01:32.000+0000"|
| Fingerprint | fingerprint | "field": "fingerprint", "operator": "FIND", "value": "b4358d2c8f6567080b9cb0d58b0bcfaa64630752" |
| Issuer Common Name (CN) |issuerCN |{"field":"issuerCN","operator":"MATCH","values":["traininglab-Root-CA","Acme"]} |
| Signature hash algorithm | signatureHashAlgorithm and one or more values:  <ul><li>GOSTR3411_94</li><li>MD2</li><li>MD5</li><li>SHA1</li><li>SHA224</li><li>SHA256</li><li>SHA384</li><li>SHA512</li><li>UNKNOWN</li></ul>| "field":"signatureHashAlgorithm","operator":"EQ","value":"SHA1" |
| Subject Alternative Name DNS |  subjectAlternativeNamesByType and one or more values: <ul><li><span class>otherName</span></li><li><span class>rfc822Name</span></li><li><span class>dNSName</span></li><li><span class>x400Address</span></li><li><span class>directoryName</span></li><li><span class>ediPartyName</span></li><li><span class>uniformResourceIdentifier</span></li><li><span class>iPAddress</span></li><li><span class>registeredID</span></li></ul> | "field": "subjectAlternativeNamesByType", "operator":"MATCH", "values":["dNSName", "directoryName"] |