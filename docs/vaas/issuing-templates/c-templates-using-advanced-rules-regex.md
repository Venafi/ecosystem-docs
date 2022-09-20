---
description: Using regular expressions (regex) in certificate issuing templates
---

# Advanced rule settings using regular expressions

When configuring a new issuing template, you can use regular expressions
(regex), such as `.*` and `[a-z]`, to create complex and powerful patterns in
any of the following fields on the New Issuing Template page:

- Common Name
- DNS SAN
- IP Addresses SAN
- URI SAN
- Email Addresses SAN

## Examples of common uses

**Common Name** example that allows all subdomains of `acme.com`:

```
.*[.]acme[.]com
```

**DNS SAN** example that allows all subdomains except wildcards for `acme.com`:

```
[a-z-A-Z-0-9]*[.]acme.com
```

**IP Addresses SAN** example that ensures the value complies with RFC 1918 (IPv4 private address):
```
^(10|172[.](1[6-9]|2[0-9]|3[0-1])|192[.]168)[.].*
```

**URI SAN** example that allows any subdomain of `acme.com` that starts with `https://`, `ldaps://`, or `spiffe://`:
```
(https|ldaps|spiffe)://.*\.acme\.com
```

**Email Addresses SAN** example that allows all addresses that end in `acme.com`:

```
.*@acme[.]com
```

## Regular expression syntax reference

Syntax | Description | Example | Matches
  :--- | :---------- | :----------- | :------
 `*` | Matches any number of characters including none. | `.*[.]acme[.]com` | site-1.acme.com, www.acme.com, \*.acme.com
 `.` | Matches a single character. | `.?team[.]acme[.]com` | ateam.acme.com, bteam.acme.com, 1team.acme.com
`[abc]` | Matches one character given in the bracket. | `[tmb]ike[.]acme[.]com` | tike.acme.com, mike.acme.com, bike.acme.com
`[a-z]` | Matches one character from the range given in the bracket. | `[w-z]-net[.]acme[.]com` | w‑net.acme.com, x‑net.acme.com, y‑net.acme.com, z‑net.acme.com
`[^0-9]` | Matches one character outside the range given in the bracket. | `[^0-3][yz][.]acme[.]com` | 4y.acme.com, 5z.acme.com, 6y.acme.com