---
use_secret: 'PAULS_PASS'
---

# Using the HSM Validation Utility

!!! warning "Q3 2023 Update!"

    Venafi has changed the behavior of the 'Key Export' functionality.

    - Prior to v23.3 Venafi used RSA as the key transport mechanism for the AES Wrapping Key 
    - We have now added support for ECDH as an option to create the AES Wrapping Key

    **Our preferred order of support is:**
    
    - ECDH using ANSI X9.63
    - RSA using OEAP

## Requirements and Utility Output

This tool has two dependencies:

1. Working PKCS11 client provided by the Vendor
2. .Net 4.8 on the Windows workstation where it is being run.

This utility has the code logic we use within TPP embedded into it.
It will generate the following files:

- `Pkcs11Validation.log` – A running log that captures the output you see on screen
- `Pkcs11 Validation Summary {Date}.txt` – Provides a summary of the tests run and the results
- `(Optional) PKCS11 Trace File` - Will capture PKCS11 calls between Venafi and the HSM client
- `Pkcs11Validation.json` – Will capture the parameters of the last run. If PKCSValidationTool.exe is run without any parameters, it will load this file if it exists and load what it needs to run

!!! danger "Saved Password"

    The HSM password will be recorded in the above files.
    The assumption is this is a test environment and it does not matter.
    If this is a concern, the password should be scrubbed post run and the `.json` file should be deleted.

## Arguments

| Arguments/Options | Description | Required |
| --- | --- | --- |
| -dll:`<fullpath>` | The path and filename of the cryptoki/pkcs11 dll to use | ✔️️ |
| -label:`<label>` | The label to use for the test | |
| -serial:`<serial>` | The serial to use for the test | |
| -pin:`<pin>` | The pin to use for token authentication | |
| -type:`<id>` | The account type to use for session creation (0 = officer, 1 = user) | |
| -testall | Performs all available tests | |
| -testsym | Performs 'SecretStore (symmetric encryption)' tests | |
| -testasym | Performs 'key generation and use on the token' tests | |
| -testexport | Performs 'key generation and export to TPP' tests | |
| -testderivation | Performs 'key derivation' tests | |
| -testreconnect | Perform 'connection lost' tests | |
| -testperformance | Performs 'load/performance' tests | |
| -testrng | Performs 'random number generator' tests | |
| -dumpinfo | Dumps the slot information | |
| -trace:`<fullpath>` | Enables integrated PKCS#11 API tracing to file `<fullpath>` | |
| -reconnectwait:`<x>` | Waits `<x>` seconds after disconnect before re-enabling interface | |
| -name:`<text>` | The name of the token being tested | |
| -interface:`<ifname>` | The name of the network interface to shut down for reconnect tests | |
| -description:`<text>` | A description for the token being tested | |
| -outdir:`<dir>` | The directory to store log file | |
| -config:`<fullpath>` | If provided, configuration is loaded from the specified json file | |

## Example Runs

``` doscon title="Simple Run"
PKCSValidationTool.exe -dll:c:\GemaltoHSM\cryptoki.dll -pin:newPassw0rd! -label:HSMLABEL
```

The following test is only necessary if you want to test performance and reconnect logic.

``` doscon title="Comprehensive Run"
PKCS11ValidationTool.exe -dll:c:\GemaltoHSM\cryptoki.dll -pin:newPassw0rd! -label:HSMLABEL -testall -interface:Ethernet -trace:c:\temp\p11.log
```

!!! warning "Be sure to identify the correct network interface for reconnect tests"

    The reconnect test will disable the network interface during part of the run.
    Please use `ipconfig` to determine the correct network interface to specify when running the reconnect test.

    ![Example ipconfig](../../assets/images/Tools/HSM/ipconfig.png)