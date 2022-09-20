# Overview: Backing up and restoring VSatellites

{{vsat}}s are designed to be light-weight and disposable (stateless). This is so that you can easily add, remove and reconnect them from the {{vsat}}s page ( {{ vs }} > Settings > {{vsat}}s).

To be able to recover from a catastrophic loss of connections between all of your {{vsat}}s and {{vs}}, it's critical that you back up the [data encryption key (DEK)](what-is-the-data-encryption-key-dek.md). The DEK plays a critical role in recovering from just such a scenario.