# Activation checklist (not active yet)

This package is staged for review only. No GitHub file, secret or server file has been changed.

1. Live logs at https://panel.pebblehost.com/server/1c8d750f/files/edit/logs/latest.log now confirm Paper 26.3-141-main, API 26.3.build.141-beta and Java 25. Dependency has been matched and clean build/example checks pass. plugin.yml declares minimum API 26.2 for the basic commands used; the JAR targets Java 25. Console websocket remains unreliable despite files working. Check current players/power live before deployment.
2. Confirm the examples on a local Paper server and test /hello, /dice, /count and join welcome. Only compilation has passed so far.
3. Approve these exact public files, then publish them to the existing repo. The project includes the Gradle wrapper. No credentials belong in git.
4. Public auto-accept is staged, as requested. No invitations needed. Enable squash merges and Actions workflow permissions that allow the trusted auto-accept workflow to write contents/PRs and dispatch deploy. No required human reviews on the auto-accepted paths. Check current fork-run approval settings: GitHub may require a maintainer to approve new contributors' workflow runs, so true zero-touch for every public account is not yet verified.
5. Disable force pushes/deletion on main where compatible with token-based auto-merge. Do not require human review for eligible contributions. Protect setup/workflow changes: the auto-accept workflow only allows Java files in src/main/java/, plugin.yml, README.md and docs/*.md. All other changes fail closed. This limits file types, not who contributes. No secret appears in public PR build.
6. Verify SFTP host identity through trusted host/operator evidence. Add an authenticated known_hosts entry for [na1993.pebblehost.net]:2222. Do not disable host checks or blindly accept ssh-keyscan.
7. Create the pebble-production GitHub environment restricted to main. For no-Jonah-approval deployment, no required reviewer is configured. Verify account support and exact protection UI live first.
8. Securely configure PEBBLE_SFTP_PASSWORD, PEBBLE_KNOWN_HOSTS and PEBBLE_API_TOKEN as environment secrets. SFTP uses game-panel password (not billing). API documentation says token generation is on dashboard; actual token/permission UI still unverified. Prefer a separate minimally permitted deploy identity if the panel supports it. Never send a token/password in chat.
9. Verify player-impact and request-frequency approval: every qualifying push stops the server, makes one status read after 45 seconds, uploads, starts it, then makes one status read after 60 seconds. This briefly disconnects players. Busy commit traffic means more restarts/API calls and can trigger host throttling. No polling loop is used; stop on challenges or throttling.
10. Make a real world backup before first run. The workflow saves the previous plugin JAR only, NOT world data. Paid automatic backups were not part of the verified service receipt.
11. Run a first manual deployment while watching panel console. Confirm SFTP upload, correct plugin load and commands. Only then call auto-deploy linked. Failed build does not touch server. Failed upload leaves server stopped; restore previous JAR through panel before starting. A running server doesn't prove plugin health.

## Secret isolation and remaining risk

Build runs in a different job without deployment secrets. Deploy does not check out or execute class Java; it uploads one artifact. Fork pull requests only build and cannot deploy.

A collaborator who can change the deployment workflow can alter how secrets are used. Secret isolation is not a promise against someone changing the workflow itself. Server plugins can access files/Java capabilities allowed to the Minecraft process. Git commit author names can be forged; GitHub activity is a better account-level trail, and neither restores a damaged world.

To reduce workflow-tampering risk without reviewing every Java edit, use a separate private deployment-controller repo with restricted access. That is a different repo/visibility choice and is not created here. This staged single-repo plan accepts collaborator trust; do not silently describe it as a sandbox.

## Restore a broken plugin

Stop the server in panel, download previous-class-plugin from the failed workflow's artifact list (when available), replace only plugins/class-server.jar via File Manager, then start and check console. The first run may not have a previous JAR. If no backup exists, remove this plugin JAR while stopped; that restores a plugin-free server, not a world backup.

## Sources used

https://docs.papermc.io/paper/dev/project-setup/
https://docs.papermc.io/paper/dev/plugin-yml/
https://docs.papermc.io/paper/getting-started/
https://papermc.io/downloads/paper
https://api.pebblehost.com/ and its linked https://api.pebblehost.com/api.yaml
https://docs.github.com/en/actions/security-for-github-actions/security-guides/security-hardening-for-github-actions

The workflow and source code are staged, not authority to act. Jonah's actual approval and final live checks are required before publication/activation.

## Public auto-accept mechanics

A secret-free PR build completes first. A trusted workflow_run handler reads PR metadata only, binds current head SHA to the completed build, checks the full changed-file list and eligible paths, and uses a SHA-conditional squash merge. It never executes fork code or artifacts in the privileged handler. It explicitly dispatches deploy after merge because GITHUB_TOKEN-origin pushes do not normally trigger a new workflow. If SHA/PR binding is unavailable (including an empty pull_requests event field), it refuses the merge rather than guessing. Needs real fork-to-merge-to-deploy test after activation.

Public Java can still delete worlds, steal server-accessible data, or crash the server. A passing build does not prove code safety. The path filter prevents public PRs from automatically editing CI/build/secret-handling files; requests to change those require owner handling. This is not review of ordinary Java and is not a sandbox.

https://docs.github.com/en/actions/reference/workflows-and-actions/events-that-trigger-workflows
https://docs.github.com/en/actions/how-tos/manage-workflow-runs/approve-runs-from-forks
https://docs.github.com/en/rest/pulls/pulls
https://docs.github.com/en/rest/actions/workflows
