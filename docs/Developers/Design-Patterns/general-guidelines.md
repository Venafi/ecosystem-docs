# General Guidelines & Best Practices

The following guidelines apply generically to all solutions to Venafi, regardless of solution type, and should be referenced as the solution is developed & tested, and as new features or enhancements are added.

## Naming Conventions

A standard naming convention should be adopted to avoid any collisions when objects (applications, certificates, devices, etc.) are created. Collisions can occur when the name you define already exists in Venafi. You can use the same prefix or suffix, and then add something unique to the name.

## Debug Logging

It's **strongly encouraged** to build in debug logging that can be enabled by end users when troubleshooting issues in their environments. 