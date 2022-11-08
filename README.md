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

##### Snippets

To use a snippet in a topic, create the snippet in 'docs/.snippets' or a subfolder in that directory as a .md file. Then, in the topics where you want to include the snippet, **you can reference it with the following:**

{% include 'snippet-name<span></span>.md' %}

**To include a snippet in a subfolder, use**

{% include 'folder-name/snippet-name.md' %}

##### Searching

A search for `.to-do` in the repo should surface all the existing pages that are currently in-progress and not quite ready to be published.

##### External Links

Include the following immediately after the (link in parenthesis):
`{: target="_blank" }`
