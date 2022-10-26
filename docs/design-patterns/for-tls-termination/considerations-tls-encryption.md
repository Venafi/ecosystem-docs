# Considerations: TLS Encryption

<!-- .to-do - Please remove this line when this page is considered "ready" -->

##### Questions to guide us:

- What are the absolute **required capabilities**? (MVP)
    1. Ability to use a {{mid}}, an X.509 Certificate in this case, to secure traffic
    1. Ability to install/deploy/upload a {{mid}} to a 
    1. Ability to **validate** that a specific {{mid}} is where we think it is (data either proactively requested by Venafi or periodically reported on by the target consumer of the {{mid}})
    <!-- (.to-do/.q-alan: add tool-tip describing what validation is and why it's important to users) -->
    1. 


- What sets the best solutions apart?
    - Renewal of a {{mid}} should not cause downtime
    - 

##### Topics to include/link:

- Glossary?
- Relevant Venafi blog articles?

<!-- HERE'S WHERE THE REAL CONTENT STARTS -->

### Primers
We think you'll find the following references helpful when developing your solution. **If you've found other articles or tools that you think should be included here, please let us know!**
<!-- .to-do: insert a way for users to let us know. Maybe a simple mailto: link will work for now, or do we suggest they update the page themselves and make a pull request? -->

#### Glossary

The following terms will be used throughout this design pattern, so familiarizing yourself with how they're used in context may be helpful.

- **{{mid}}:** X.509 certificate
- **{{mim}}{{ctrl-plane}}:** The holistic platform/service, along with the cultivation & curation of the vast marketplace of solutions, tools & frameworks offered by Venafi and the ecosystem
- **{{tlspc}}:** Venafi's SaaS offering (formerly known as Venafi as a Service)
- **{{tlspd}}:** Venafi's Datacenter offering (formerly known as Trust Protection Platform)

#### Relevant Reading

- INSERT BLOG HERE