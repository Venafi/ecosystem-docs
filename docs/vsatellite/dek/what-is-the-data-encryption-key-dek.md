# What is the Data Encryption Key (DEK)?

The Data Encryption Key (DEK) serves a number of important security 
functions for {{vs}}. Some of the critical functions of the DEK include:

- Encrypting stored credentials for your VaaS integrations
- Encrypting private key material for certificates issued with VaaS generated private keys
- Providing a mechanism to comply with encryption compliance standards
- Providing the ability to restore private key material in the case of catastrophic 
  network failures or loss of VSatellites

The DEK is generated when you install your first {{vsat}}. That DEK is then
shared with all {{vsat}}s that are subsequently installed in your network
so that all {{vsat}}s use the same DEK.

The DEK is never stored in {{vs}} in the cloud. 

!!! important "Important"
    Copies of the DEK reside in your VSatellites and are never stored in {{vs}} 
    in the cloud. This means that if you delete all of your VSatellites, the DEK is lost.

**Next Steps**

- [Back up your existing DEK](backing-up-the-data-encryption-key.md)
<!-- - Rotate your DEK -->
