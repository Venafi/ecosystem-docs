# Restoring the data encryption key (DEK)

Because your [DEK](what-is-the-data-encryption-key-dek.md) contains key 
material shared among your {{vsat}}s, the ability to restore it from a 
backup is critical.

You should only restore your DEK in cases where *none* of your {{vsat}}s are 
operable. If you have at least one remaining and functioning {{vsat}}, you
don't need to restore the DEK because it's distributed to other {{vsat}}s automatically.  

So if you have no remaining and functioning {{vsat}}s, use the 
*import* command to restore the DEK. However, you can only restore 
DEKs for which you've [created a backup](backing-up-the-data-encryption-key.md).

<!-- UA RAW NOTES: use case: in most cases, you probably won't want or need to use import; so you'd likely only use import in a scenario where you had key material that probably was tied to a VSAT that died; only around the case where the DEK hadn't been distributed to other VSATs, or wasn't distributable in the first place. So import is there to help you get back to a state where you can recover from a failure (e.g. a hyperdrive running your vsat completely dies and is unrecoverable). VSAT stores that private key material and we cannot decrypt it
-->

**To restore a DEK**

1. Deploy a new {{vsat}}. 
1. From a command prompt, connect to the server where your new {{vsat}} is running.
1. Run the following command:

```bash
./vsatctl import --api-key <api-key> --file path/to/dek/file.pem --passphrase <secret_passphrase> 
```

After running the command, the DEK is redistributed to the functioning {{vsat}} and your DEK is restored.
