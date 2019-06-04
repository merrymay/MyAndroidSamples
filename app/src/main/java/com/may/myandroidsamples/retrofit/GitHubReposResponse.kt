package com.may.myandroidsamples.retrofit

import com.google.gson.annotations.SerializedName


class GitHubRepo {
    @SerializedName("id")
    var repoId: Long = 0

    @SerializedName("name")
    var repoName: String? = null


    @SerializedName("full_name")
    var fullName: String? = null

}



/*
[
  {
    "id": 157464936,
    "node_id": "MDEwOlJlcG9zaXRvcnkxNTc0NjQ5MzY=",
    "name": "iOSBasics",
    "full_name": "merrymay/iOSBasics",
    "private": false,
    "owner": {
      "login": "merrymay",
      "id": 9031632,
      "node_id": "MDQ6VXNlcjkwMzE2MzI=",
      "avatar_url": "https://avatars1.githubusercontent.com/u/9031632?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/merrymay",
      "html_url": "https://github.com/merrymay",
      "followers_url": "https://api.github.com/users/merrymay/followers",
      "following_url": "https://api.github.com/users/merrymay/following{/other_user}",
      "gists_url": "https://api.github.com/users/merrymay/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/merrymay/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/merrymay/subscriptions",
      "organizations_url": "https://api.github.com/users/merrymay/orgs",
      "repos_url": "https://api.github.com/users/merrymay/repos",
      "events_url": "https://api.github.com/users/merrymay/events{/privacy}",
      "received_events_url": "https://api.github.com/users/merrymay/received_events",
      "type": "User",
      "site_admin": false
    },
    "html_url": "https://github.com/merrymay/iOSBasics",
    "description": "Samples to study iOS basics ",
    "fork": false,
    "url": "https://api.github.com/repos/merrymay/iOSBasics",
    "forks_url": "https://api.github.com/repos/merrymay/iOSBasics/forks",
    "keys_url": "https://api.github.com/repos/merrymay/iOSBasics/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/merrymay/iOSBasics/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/merrymay/iOSBasics/teams",
    "hooks_url": "https://api.github.com/repos/merrymay/iOSBasics/hooks",
    "issue_events_url": "https://api.github.com/repos/merrymay/iOSBasics/issues/events{/number}",
    "events_url": "https://api.github.com/repos/merrymay/iOSBasics/events",
    "assignees_url": "https://api.github.com/repos/merrymay/iOSBasics/assignees{/user}",
    "branches_url": "https://api.github.com/repos/merrymay/iOSBasics/branches{/branch}",
    "tags_url": "https://api.github.com/repos/merrymay/iOSBasics/tags",
    "blobs_url": "https://api.github.com/repos/merrymay/iOSBasics/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/merrymay/iOSBasics/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/merrymay/iOSBasics/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/merrymay/iOSBasics/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/merrymay/iOSBasics/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/merrymay/iOSBasics/languages",
    "stargazers_url": "https://api.github.com/repos/merrymay/iOSBasics/stargazers",
    "contributors_url": "https://api.github.com/repos/merrymay/iOSBasics/contributors",
    "subscribers_url": "https://api.github.com/repos/merrymay/iOSBasics/subscribers",
    "subscription_url": "https://api.github.com/repos/merrymay/iOSBasics/subscription",
    "commits_url": "https://api.github.com/repos/merrymay/iOSBasics/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/merrymay/iOSBasics/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/merrymay/iOSBasics/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/merrymay/iOSBasics/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/merrymay/iOSBasics/contents/{+path}",
    "compare_url": "https://api.github.com/repos/merrymay/iOSBasics/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/merrymay/iOSBasics/merges",
    "archive_url": "https://api.github.com/repos/merrymay/iOSBasics/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/merrymay/iOSBasics/downloads",
    "issues_url": "https://api.github.com/repos/merrymay/iOSBasics/issues{/number}",
    "pulls_url": "https://api.github.com/repos/merrymay/iOSBasics/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/merrymay/iOSBasics/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/merrymay/iOSBasics/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/merrymay/iOSBasics/labels{/name}",
    "releases_url": "https://api.github.com/repos/merrymay/iOSBasics/releases{/id}",
    "deployments_url": "https://api.github.com/repos/merrymay/iOSBasics/deployments",
    "created_at": "2018-11-14T00:16:41Z",
    "updated_at": "2019-02-27T04:47:06Z",
    "pushed_at": "2019-02-27T04:47:04Z",
    "git_url": "git://github.com/merrymay/iOSBasics.git",
    "ssh_url": "git@github.com:merrymay/iOSBasics.git",
    "clone_url": "https://github.com/merrymay/iOSBasics.git",
    "svn_url": "https://github.com/merrymay/iOSBasics",
    "homepage": null,
    "size": 86,
    "stargazers_count": 0,
    "watchers_count": 0,
    "language": "Swift",
    "has_issues": true,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": false,
    "forks_count": 0,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 0,
    "license": null,
    "forks": 0,
    "open_issues": 0,
    "watchers": 0,
    "default_branch": "master"
  },
 */