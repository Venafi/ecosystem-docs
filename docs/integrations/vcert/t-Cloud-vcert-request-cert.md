# Using VCert to request certificates

{{vcert}} is a command line utility designed to generate keys and simplify
certificate acquisition by eliminating the need to write code to interact with
the REST API.

{{vcert}} is most applicable to DevOps applications that need to obtain certificates
for virtual machines, containers, and/or applications as it spins them up, and
it is available in 32- and 64-bit versions for Linux, Windows, and MacOS.

{{vcert}} performs key generation locally, which is helpful in cases where you need
to limit private key access

If you're using APIs when you work with {{vs}}, the {{vcert}} utility can be used to
request a certificate. The utility can be used to register for a new API user
account and to request a certificate.

* To register a new user, launch the {{vcert}} utility with the ‘register’ command.

    * You will be prompted to supply an email address.

Once the account is created, {{vs}} sends an email to the registered user to
confirm activation of the account. The activation email contains links to
activate the registered user account.

* Click the first link in the email to activate the account.
  
    * The API key for the user account is displayed at the bottom of the licensing and registration email.

## To request a certificate using {{vcert}}

[Use your DevOps toolkit to request certificates](t-integrations-project-details-viewing.md)

