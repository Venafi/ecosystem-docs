# Creating new Teams

Creating teams and adding team members is easy. But before you start creating teams, consider the following:

* Who do you want to add as team owners?

* Who do you want to add as team members?

* What role do you plan to assign to your team so that team members can do their work most effectively?

* If you're using SSO, does your SSO solution return additional information (called *claims*) about your users that can be used to assign users to teams?

??? optional-css-class "About role assignments and Teams"

    Within {{vs}}, user roles are assigned to users individually. This can be done either manually by an administrator, or it can be done automatically based on team membership. 

    A user can't be assigned multiple roles within a single {{vs}} product. When a user is added to a team (either automatically or manually), {{vs}} examines the current role assigned to the user. If the user role is different than the role associated with the Team, {{vs}} changes the user's role to the role associated with the team automatically. If the user belongs to multiple Teams, {{vs}} calculates the highest privilege role from the set of Teams to which the user belongs, and then assigns the user to that role.

    For example, suppose you have 2 teams: *TeamA* and *TeamB*. TeamA is configured with the {{rolesPKI}} role while TeamB is configured with the {{rolesRO}} role. Alan is a user in {{vs}} that is currently assigned the {{rolesG}} role. Alan is then added to TeamA and TeamB by each teams' respective owners. The result is that Alan's new role in {{vs}} is a {{rolesPKI}}.

    !!! important "Important"
        Users who are removed from all teams are demoted to the lowest privileged {{rolesG}} role automatically.

## To create a new team

1. Sign in to **{{vs}}**.
1. Click **People** > **Teams**.
1. Click **New**.
1. (Required) On the **New Team** page, type a name for your team in **Team**.
1. (Required) Click **Owner** and select the people who you want to be the team owners.

    Repeat to add more than one owner.

    ??? optional-css-class "About Team Owners"
        Team owners are users who are authorized to edit the team itself. Team owners are not added as team members automatically.

1. (Required) Click **Role** and select the role to assign to team members.

    ??? optional-css-class "About assigning roles to teams"
        When creating a team, you cannot assign a role to the team that is higher privileged than the role assigned to your user account. For example, if Alan is assigned the {{rolesRO}} role, he can't create a team with the {{rolesPKI}} or {{rolesSA}} roles.

1. (Optional) Click **Members** to add users to the Team. 

??? optional-css-class "Team Membership"

    Note: A Team may contain a combination of local users (users who login to {{vs}} with a username/password configured in {{vs}} as well as SSO users. Additionally, new users may be added to a Team by using the 'Invite Team Members' button. This link can be shared with anyone in your organization that does not have a {{vs}} account. Once a user creates a new {{vs}} account using the invitation link, they will automatically be added to the Team.


1. (Conditional) If SSO is enabled, build your team membership rules to organize your users into teams automatically. Team membership rules are optional. 

    You can skip this step and come back to it later, or you can let the team owners specify membership rules.

    !!! important "Important"
        Keep in mind that claim rules are *AND* rules; so if you specify multiple rules, ALL of them must be met in order for a user to meet the criteria and be added to the team.

    ??? optional-css-class "Understanding how SSO claims work with team membership rules"
        SSO claims are used to identify which users should be added to your team. Users whose SSO claims match the conditions you specify are added to the team automatically.

        For example, suppose your organization uses Active Directory with Okta as your SSO. Your team has an AD group called *GroupA* that is synchronized with Okta. If Okta is configured with a *Groups claim expression*, the AD group named *GroupA* will be returned in a claim that contains the list of groups to which the user belongs. To verify your setup, sign in to {{vs}}}, go to **Settings** > **VaaS Platform** > **Single Sign On**, and then click **Test Connection** to make sure the GroupA is returned in the claim:

        ```rest
        {
            "at_hash": "yD62LRYaml6qPbZhB1aW9g",
            "sub": "00uw90kf60mCkrAry0h7",
            "zoneinfo": "America/Los_Angeles",
            "ver": 1,
            "email_verified": true,
            "amr": [
                "pwd"
            ],
            
            ...

            "adGroups": [
            "Everyone",
            "Domain Users",
            "GroupA"
            ],

            ...
        }
        ```

        The following diagram shows you how SSO claims map to Team membership rules.

        [Click here to see a larger version of the image](img/Teams-membershipRules-claims-mapping.png).

        ![Mapping SSO claims to Team Membership Rules](img/Teams-membershipRules-claims-mapping.png)

        Learn more about [SSO configuration](about-sso-integrations.md).

1. Click **Save**.
