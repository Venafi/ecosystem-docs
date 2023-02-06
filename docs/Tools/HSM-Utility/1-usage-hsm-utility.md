---
use_secret: 'PAULS_PASS'
---

# Using the HSM Validation Utility

This tool has two dependencies: 

1. Working PKCS11 client provided by the Vendor 
2. .Net 4.7.2 on the Windows workstation where it is being run. 

This utility has the code logic we use within TPP embedded into it.
It will generate three files: 

- `Pkcs11Validation.log` – A running log that captures the output you see on screen. 
- `Pkcs11 Validation Summary {Date}.txt` – Provides a summary of the tests run and the results. 
- `Pkcs11Validation.json` – Will capture the parameters of the last run. If PKCSValidationTool.exe is run without any parameters, it will load this file if it exists and load what it needs to run. 

!!! danger "Saved Password"

    The HSM password will be recorded in the above files. The assumption is this is a test environment and it does not matter. If this is a concern, the password should be scrubbed post run and the `.json` file should be deleted.
