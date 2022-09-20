# Backing up your data encryption key (DEK)

The [DEK](what-is-the-data-encryption-key-dek.md) should be backed up immediately after you deploy your 
first {{vsat}}.
<!-- when auto-rotate is deployed...add this to the first paragraph: ", and after every rotation of your DEK." -->

As long as at least one of your {{vsat}}s is functioning, you don't 
need to restore the DEK from a backup copy because it's distributed to 
other {{vsat}}s automatically. However, backing up the DEK can help 
you recover from the scenario in which *all of your {{vsat}}s have become 
permanently inoperable*.

**To back up your DEK**

1. Open a command prompt and connect to the server where a working {{vsat}} is running.
1. Run the following command:

```bash
./vsatctl export --api-key <api-key> --passphrase <secret_passphrase> --file path/to/dek/file.pem
```

!!! tip "Where can I find my API key?"
    In {{vs}}, click your user avatar, then click Preferences. Learn more about [how to get an API key](../../../api/obtaining-api-key).

After running the command, store the DEK in a secure location.

## What's next

If for any reason *all* of your {{vsat}}s have become permanently inoperable,
[use the *import* command to restore the DEK](restoring-the-data-encryption-key.md).