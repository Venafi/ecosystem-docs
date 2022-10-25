The most common use cases a Venafi customer has for Ecosystem can be captured in the flow graphs below.

**Use Case 1**: You need to know whether we already have an integration with a different technology.
``` mermaid
flowchart TB
  B[Go to Venafi Marketplace and search for the technology in question.] --> C{Solution on Marketplace};
  C --> |Yes| D{Solution is what you were looking for};
  D --> |No| E[Contact your Venafi account manager];
  D --> |Yes| F[Yes]
  C --> |No| E
```

**Use Case 2**: You have a suggestion and a nice idea for an integration with a technology, please provide all the details necessary on Venafi ideas [community](https://community.venafi.com/) channel.