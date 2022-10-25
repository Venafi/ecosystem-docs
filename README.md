# docs

#### Quick Reference

Run locally using:
```
mkdocs serve
```

Promote to `gh-pages` branch using:
```
mkdocs gh-deploy
```

##### Variables

Variables are used to make future branding updates or name changes easier. Variable definitions are found in `docs/.variables/general.yml` and can be added to and updated at any point.

> To use a variable on any page, simply include it in two curly braces `{{VARIABLE}}`. 

| Markdown | Renders as: |
| --- | --- |
| Venafi is the leader in **{{mim}}**. | Venafi is the leader in **Machine Identity Management**. |

##### Searching

A search for `.to-do` in the repo should surface all the existing pages that are currently in-progress and not quite ready to be published.