# About deleting your last available VSatellite

Before you delete your very last {{vsat}}, you should consider the implications
carefully.

Deleting the *last {{ vsat }}* results in also permanently deleting 
any associated services, as well as the {{vsat}}'s data encryption key (DEK), 
which contains all related keys and credentials. 

## If I delete my last remaining VSatellite, is there a way to recover it and it's DEK and services?

No. Deleting your final VSatellite is a permanent loss of both the {{vsat}}, any 
associated services and the DEK (which contains associated keys and credentials).

## After I delete my final VSatellite, are there any additional steps? 

You should follow the [directions for deleting any VSatellite](t-VSatellite-delete.md), 
which includes [removing the binaries from the server](t-VSatellite-delete.md/#remove-linux) 
where you had installed {{vsat}}.
