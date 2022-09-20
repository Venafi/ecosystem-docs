# Overview: validating certificates

Certificate validations help ensure that you're installing and using your certificates 
in a way that secures your machine identities. In fact, after certificates are added to 
the certificate inventory, {{ vs }} validates them automatically (every 24 hours).

Why is certificate validation important? Because security, compliance, and technological innovations introduce new criteria for the 
validation of certificates and the servers that host them, {{ vs }} uses validation techniques
to ensure that your certificates remain valid and are being used properly.

{{ vs }} warns you automatically about any certificates that fail validation. 
In addition, a [Machine Identity Digest](./set-up-email-notifications.md) is sent out through 
email notifications to specified recipients so that they can take immediate action.

In addition to validating certificates automatically, you can also run validation on certificates manually using [Validate Now](t-validating-certs-manually-using-ValidateNow.md). And Validate Now can also [sniff out any additional installations of certificates](t-validating-certs-using-ValidateNow-to-discover-installations.md) in your inventory.

## Types of certificate validations

{{vs}} supports two types of certificate validation:

- SSL/TLS validation

- Certificate chain validation

### About SSL/TLS validation

The validation feature in {{ vs }} performs an SSL/TLS validation on each certificate every 24 hours, or you can [run a validation manually](t-validating-certs-manually-using-ValidateNow.md) at any time. The SSL/TLS validation checks that the correct certificate is in use on an application, and that the certificate is properly configured.

<table>
  <colgroup>
    <col/>
    <col/>
    <col/>
    <col/>
  </colgroup>
  <tbody>
    <tr>
      <th>Validation Status</th>
      <th>Description</th>
      <th>Risk level</th>
      <th>Resolution</th>
    </tr>
    <tr>
      <td>Hostname mismatch</td>
      <td>The TLS target presented a certificate, but the common name or SAN of your SSL/TLS certificate does not match the domain where the certificate is installed</td>
      <td>High</td>
      <td>Install the correct version of the certificate associated with the domain. Or reissue a certificate by verifying the CN and SAN.</td>
    </tr>
    <tr>
      <td colspan="1">Old version of certificate found</td>
      <td colspan="1">One of the certificate installations is using older versions of certificates that should be replaced with the newer versions.</td>
      <td colspan="1">High</td>
      <td colspan="1">Install current version of the certificate on the target TLS server installation.</td>
    </tr>
    <tr>
      <td colspan="1">No certificate present</td>
      <td colspan="1">TLS target specificed in the VaaS platform didn't present a certificate on a specified port</td>
      <td colspan="1">Warning</td>
      <td colspan="1">Verify TLS server installation and port number and ensure if the target is valid. If target is valid, investigate why certificate is not present. If the target is no longer valid, remove target from discovery target list or Alternatively, the user just needs to wait until the installation is aged out. Current installation aged out time is 30 days.</td>
    </tr>
    <tr>
      <td colspan="1">Unexpected certificate found</td>
      <td colspan="1">Certificate found on the TLS target contains a different fingerprint than the one that {{ vs }} expected. </td>
      <td colspan="1">Warning</td>
      <td colspan="1">Install the correct certificate on the endpoint.</td>
    </tr>
    <tr>
      <td colspan="1">Unknown error</td>
      <td colspan="1">{{ vs }} encountered an error but could not identify it.</td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <p>When an unknown error occurs, {{ vs }} automatically captures the details of the condition and submits it to Venafi for future enhancement.</p>
        <p>If you have additional questions, contact <a href="https://support.venafi.com" target="_blank">Venafi Support</a>.</p>
      </td>
    </tr>
    <tr>
      <td colspan="1">Pending</td>
      <td colspan="1">The validation process has not yet occurred.</td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <p>When this occurs, try running a manual validation (Validate Now) or waiting until the next automated validation occurs.</p>
        <p>If you have additional questions, contact <a href="https://support.venafi.com" target="_blank">Venafi Support</a>.</p>
      </td>
    </tr>
  </tbody>
</table>

### About certificate chain validation

Each certificate in {{ vs }} shows that certificate's chain. A certificate chain starts with the end-entity certificate and proceeds through a number of intermediate certificates up to a trusted root certificate. Root certificates are typically issued by a trusted certificate authority (CA), but you can [upload additional root certificates](adding-a-certificate-authority.md) if needed, such as for an internal CA. Certificate chain validation makes sure a given certificate chain is well-formed, valid, properly signed, and trustworthy. Any error in the certificate chain could cause an outage.

To help avoid chain-related outages, {{ vs }} continuously monitors all certificates in the chain.

!!! tip "What is a certificate chain?"
    If you are unfamiliar with certificate chains, read through <a href="https://www.venafi.com/blog/how-do-certificate-chains-work" target="_blank">How do Certificate Chains Work</a> for background.

Following are the possible certificate chain validation states, their descriptions, and resolution actions.

<table>
  <colgroup>
    <col/>
    <col/>
    <col/>
    <col/>
  </colgroup>
  <tbody>
    <tr>
      <th>Validation Status</th>
      <th colspan="1">Description</th>
      <th colspan="1">Risk level</th>
      <th>Resolution</th>
    </tr>
    <tr>
      <td>Chain expiring soon</td>
      <td colspan="1">One or more of the CA certificates in the trust chain expires before the end-entity does, or is expiring soon.</td>
      <td colspan="1">High</td>
      <td>
        <p>Identify the expiring or about to expire CA certificate from end entity certificate, download and install the current chain.</p>
        <p>If the current chain is not available, renew the certificate, download and install end-entity and chain certificates.</p>
      </td>
    </tr>
    <tr>
      <td>Chain building failed</td>
      <td colspan="1">
        <p>One or more intermediate or root CA certificates is missing, and a complete chain can't be constructed.</p>
        <p>This means VC can build the chain for the certificate independent of the CA certificates returned by the server.</p>
      </td>
      <td colspan="1">Warning</td>
      <td>Install the missing intermediate CA certificate(s) on the TLS server target.</td>
    </tr>
    <tr>
      <td colspan="1">Incomplete chain</td>
      <td colspan="1">
        <p>The chain returned by the endpoint did not include a sufficient number of valid intermediate certificates to build a complete chain anchored by a root CA.</p>
        <p>If you miss installing the intermediate certificate or upload the wrong one, then it can not be chained back and the browsers will not trust the certificate and may generate a broken chain or similar sort of warnings.</p>
      </td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <p>Check if your intermediate certificate is invalid due to revocation or expiration.</p>
        <p>Download and install your end entity certificate along with proper intermediate certificate(s) that form its trust chain.</p>
      </td>
    </tr>
    <tr>
      <td colspan="1">Chain not trusted</td>
      <td colspan="1">The chain returned by the target cannot be used to form a Trusted chain</td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <a href="../../vaas/certificates/ca/working-with-trusted-ca-certificates/#add-a-trusted-ca-certificate-using-a-base64-encoded-text-file">Add the missing CA certificate</a> to the Trusted CA Certificate inventory</td>
    </tr>
    <tr>
      <td colspan="1">Unknown error</td>
      <td colspan="1">{{ vs }} encountered an error but could not identify it.</td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <p>When an unknown error occurs, {{ vs }} automatically captures the details of the condition and submits it to Venafi for future enhancement.</p>
        <p>If you have additional questions, contact <a href="https://support.venafi.com" target="_blank">Venafi Support</a>.</p>
      </td>
    </tr>
    <tr>
      <td colspan="1">Pending</td>
      <td colspan="1">The validation process has not yet occurred.</td>
      <td colspan="1">Warning</td>
      <td colspan="1">
        <p>When this occurs, try running a manual validation (Validate Now) or waiting until the next automated validation occurs.</p>
        <p>If you have additional questions, contact <a href="https://support.venafi.com" target="_blank">Venafi Support</a>.</p>
      </td>
    </tr>
  </tbody>
</table>

## What's next?

- Learn more about [using Validate Now to find additional certificate installations](t-validating-certs-using-ValidateNow-to-discover-installations.md).
- Learn more about [finding certificates in your inventory](finding-certificates.md).
- Learn more about [downloading certificates](requesting-downloading-installing-certificates.md).