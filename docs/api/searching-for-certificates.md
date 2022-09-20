# Searching for certificates

To retrieve information about your certificates, use one of the following
API functions. You can only search for certificates that are associated with
your company account:

| I want information about | Use this search API function |
| ----------- | ----------- |
| Discovered certificates that originate from external domains or from internal networks | certificatesearch |
| Certificate installations for discovered certificates | certificateinstancesearch |

**To search for certificates**

1. If you have not already done so, obtain an [API key](obtaining-api-key.md).

1. Use the `certificatesearch` or `certificateinstancesearch` function. For
   additional help, use the parameter descriptions from {% include
   'sn-Cloud-api-LinktoSwagger.md' %}. For example:
 
	```
    POST https://api.venafi.cloud/outagedetection/v1/certificatesearch
    tppl-api-key: XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
	```
  
1. In the JSON body, use the expression to specify your search criteria:

    | expression | How to use |
    | ----------- | ----------- |
    | expression | The operands parameter that contains an array of search criteria. For each set, specify these values: <ul><li>'field': A certificate field name. For example signatureHashAlgorithm or certificateType. Use the appropriate [search parameters](about-api-search-fields.md).</li><li>operator: One of the following condition operators `EQ`, `LT`, `LTE`, `GT`, `GTE`, `IN`, `MATCH`, `FIND`, `MOD`. Use the appropriate [search operators](about-api-search-fields.md). </li><li>`value` OR `Values` in an array. Use in conjunction with the `IN` operator. Specify a comma separated list of strings in quotes or integers without quotes. </li></ul> |
    | joinexpression (Optional) | The `operator` that allows AND or NOT filtering. |
    | ordering (Optional) | The orders parameter that contains an array of sort parameters. Specify these values: <ul><li>`direction`: A sort order ASC or DESC (ascending or descending).</li><li>`field`: The sort field name.</li></ul> |
    | paging (Optional) | The parameters that dictate the size of the data set to returned When working with a large set of results, the REST API supports paging through the result set. For example, if the query returns 100 results, you can specify pageSize of `10` and 1,2…10 to iterate through all 10 result pages. Specify these values: <ul><li>`pageNumber`: The page from the result set to return.</li><li> `pageSize`: The maximum number of records to return in the response.</li></ul> |

	**Example JSON body**
	```json
	{
		"expression": {
			"operands": [
				{
					"field": "selfSigned",
					"operator": "EQ",
					"value": "false"
				}
			]
		},
		"ordering": {
			"orders": [
				{
					"direction": "DESC",
					"field": "validityEnd"
				}
			]
		},
		"paging": {
			"pageNumber": 0,
			"pageSize": 1
		}
	}
	```   

	**Example response**

	```json
	HTTP 1.1 OK
	{
		"count": 1,
		"certificates": [
			{
				"id": "8a7c4780-8cb2-11eb-9bc7-9d00b8bdf22c",
				"companyId": "b5ed6d60-22c4-11e7-ac27-035f0608fd2c",
				"managedCertificateId": "8ba6bdc0-8cb2-11eb-a5b7-8d11c4beb51f",
				"fingerprint": "62CB1D588CB1E1B9EE56C3D63863D4EAE5C9F293",
				"issuerCertificateIds": [],
				"certificateStatus": "ACTIVE",
				"modificationDate": "2021-03-24T15:06:43.987+0000",
				"validityStart": "2018-06-01T07:15:32.000+0000",
				"validityEnd": "2049-12-31T07:15:32.000+0000",
				"selfSigned": false,
				"signatureAlgorithm": "SHA256_WITH_RSA_ENCRYPTION",
				"signatureHashAlgorithm": "SHA256",
				"encryptionType": "RSA",
				"keyStrength": 2048,
				"serialNumber": "00ACB5C5CCC2C60A3F",
				"subjectDN": "cn=dev.example.com,ou=Engineering,o=Example,c=US,st=CO,l=Denver",
				"subjectCN": [
					"dev.example.com"
				],
				"subjectOU": [
					"Engineering"
				],
				"subjectST": "CO",
				"subjectL": "Denver",
				"subjectC": "US",
				"subjectAlternativeNamesByType": {
					"otherName": [],
					"rfc822Name": [],
					"dNSName": [],
					"x400Address": [],
					"directoryName": [],
					"ediPartyName": [],
					"uniformResourceIdentifier": [],
					"iPAddress": [],
					"registeredID": []
				},
				"issuerDN": "cn=Example CA,ou=Engineering,o=Dev,c=US,st=CO,l=Denver",
				"issuerCN": [
					"Example CA"
				],
				"issuerOU": [
					"Engineering"
				],
				"issuerST": "CO",
				"issuerL": "Denver",
				"issuerC": "US",
				"ocspNoCheck": false,
				"versionType": "CURRENT",
				"totalInstanceCount": 1,
				"totalActiveInstanceCount": 0,
				"instances": [
					{
						"certificateInstanceId": "8a7d58f0-8cb2-11eb-9bc7-9d00b8bdf22c",
						"certificateId": "8a7c4780-8cb2-11eb-9bc7-9d00b8bdf22c",
						"certificateSource": "USER_SCAN",
						"ipAddress": "192.168.1.139",
						"hostname": "192.168.1.139",
						"port": 443,
						"instanceChainValidationStatus": [],
						"sslProtocols": [
							"TLSv1",
							"TLSv1.1",
							"TLSv1.2"
						],
						"lastScanDate": "2021-03-24T15:06:42.027+0000",
						"modificationDate": "2021-03-24T15:06:43.987+0000",
						"applicationIds": [
							"49a054c0-5f2e-11ea-8ae9-933542fd4eb5",
							"48e63cc1-6a14-11ea-afcc-8d379678d42e",
							"a2d18320-8fdf-11ea-92c1-7190ae0b9dca",
							"d61725b0-ab86-11ea-b564-51df0bbad2d4",
							"a0e5cc50-ac05-11ea-baf4-89b92aa342a0",
							"5875c280-ebb2-11ea-8337-0b727cdbf03d",
							"3c567990-409f-11eb-a539-1d69e27dc8c4",
							"a2a0db60-5a70-11eb-b98b-35b9aff61996",
							"f4afe9c0-5c3a-11eb-8297-e1de5ec713ab",
							"24347560-8dca-11eb-99ee-a1e6b77da7a1"
						],
						"deploymentStatus": "SUPERSEDED"
					}
				]
			}
		]
	}
	```    
