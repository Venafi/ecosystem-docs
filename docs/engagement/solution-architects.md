The most common use cases for a Venafi solution architect to engage with Ecosystem can be captured in the following flow graphs.

**Use Case 1**: You need to know whether we already have a solution with a different technology.

<replace this with a infographic picture>
``` mermaid
graph LR
  A[Here] --> B[Go to marketplace.venafi.com and search for the technology in question];
  B --> C{Marketplace has results};
  C --> |Yes| D{integration is expected};
  C --> |No| E[Submit a new use case below];
  D --> |Yes| F[Yes];
  D --> |No| E;
```

<replace this with a infographic picture>
**Use Case 2**: Your account asks for a solution with another technology provider] --> B[Go to marketplace.venafi.com and search for the technology in question.
``` mermaid
graph TD
  A[Here] --> B[Go to marketplace.venafi.com and search for the technology in question];
  B --> C{Marketplace has results};
  C --> |Yes| D{Solution is expected};
  C --> |No| E{Customer paying for license of the other technology};
  D --> |Yes| F[Send listing to customer];
  D --> |No| E;
  E --> |Yes| G[Go back to the customer and ask for their referral to the other technology provider];
  E --> |No| H[Gather detailed use case from customer regarding the desired integration, evaluate the value for Venafi to pursue the integration, provide supporting data for the case, and submit a new use case below ];
```
<replace this with a infographic picture>
**Use Case 3**: You have a suggestion and a nice idea for an integration with a technology.
``` mermaid
graph TD
  A[Here] --> B[Please provide all the details including the use case, value for Venafi, value for customers, value for the community, etc necessary on Venafi ideas community channel];
```