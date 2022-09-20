# About user roles
<!--need to figure out how to remove blank rows-->

{{vs}} is built around role-based access. If you need to elevate or decrease a
user's permissions, simply change the role assigned to her or his user account.

!!! tip "Tip" 
    {{vs}} assigns the {{rolesSA}} role to the first three (3)
    enrolled users automatically. Subsequent users are assigned the Guest role.
    This ensures that there is more than one user account with the {{rolesSA}}
    role assigned to it when your company account is first created. And it also provides administrator account redundancy. At least one user account
    must have the {{rolesSA}} role.

User roles available today include the following:

* **{{rolesSA}}**: the Administrator has full permissions to all features and
  functionality in the product. This user has access to system-level settings
  and can create Issuing Templates. This role has rights to everything as well
  as access to {{vs}} APIs.

* **{{rolesPKI}}**: This person has access to manage PKI-related resources such
  as creating Issuing Templates, setting up CA accounts, and managing user
  roles.

* **{{rolesRO}}**: This person has system-wide read-only access to all resources
  in the system but has read/write/delete permission for resources that he or
  she owns. Resource owners have the ability to approve operations on resources
  they own.

    ??? info "Learn more about the {{rolesRO}} role"
        {{vs}} empowers {{rolesRO}}s to manage their own applications and associated certificates, while limiting access to resources that are beyond their scope of responsibility.

  

        ### {{rolesRO}} permissions

        <div class="bullet-list-table" markdown="1">
  
        | VaaS Page | Permissions |
        | --- | --- |
        | Dashboard | <ul><li>View consolidated statistics for all certificates</li></ul> |
        | Inventory > Certificates | <ul><li>Import new certificates and assign them to Applications owned by the {{rolesRO}}</li><li>Assign existing certificates that are not assigned to any Application</li><li>Assign and reassign existing certificates that are assigned to at least one Application owned by the {{rolesRO}}</li><li>Clear certificate assignments from Applications owned by the {{rolesRO}}</li><li>Retire certificates that are assigned to an Application owned by the {{rolesRO}}</li><li>View and download all certificates</li><li>Download certificates and private key (keystores) if VaaS has generated the private key and if the certificate is assigned to an Application owned by the {{rolesRO}}</li></ul>
        | Inventory > Certificate Installations | <ul><li>View certificate installations</li></ul> |
        | Inventory > Trusted CA Certificates | <ul><li>View and download CA certificates</li></ul> |
        | Inventory > Certificate Requests | <ul><li>Create new requests. Must specify an application they own and assign the certificate to this application.</li><li>View certificate requests for all applications</li></ul> |
        | Applications | <ul><li>Create new applications</li><li>Edit applications they own, including adding additional owners</li><li>Remove themselves as owner (provided the application has at least one additional owner)</li><li>Delete applications they own</li><li>Invite new users into VaaS and make them owners of applications they own</li><li>View applications they don't own</li></ul>
        | Settings > Issuing Templates | <ul><li>View certificate issuing templates</li></ul>
        | Settings > Users | <ul><li>View existing users</li><li>Invite new users</li></ul>
        | Settings > Teams | <ul><li>View existing teams</li><li>Create new teams</li></ul>
        | Settings > Event Log | <ul><li>View, filter, and export the event log</li></ul>

        </div>

* **{{rolesG}}**: This user has read-only access to items such as certificates,
  certificate requests, installations, applications, and activity logs.  
