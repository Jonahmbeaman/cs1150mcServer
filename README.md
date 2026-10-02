# The Stone Zone: class Java playground

Add Java Paper plugins here. This is a Paper project, not a Forge/Fabric mod loader or an arbitrary-script runner.

## First change in five minutes

1. Sign in to GitHub and open this repo.
2. Open `src/main/java/io/github/jonahmbeaman/classserver/BeginnerExamples.java`.
3. Click the pencil. Change the greeting in `hello()` from `Hello, ` to your own words. Keep the quotes and semicolon.
4. Write a short commit message, such as `Alex: change hello greeting`.
5. If Jonah has invited you as a collaborator, commit to `main`. After automation is activated, a successful build uploads the JAR and restarts the server automatically. Jonah does not approve every change. All players briefly disconnect during restart.
6. If GitHub makes you fork instead, submit the edit as a pull request. After activation, eligible Java/example/doc edits from anyone are accepted automatically when the build passes, then deployed. No collaborator invitation or Jonah review is needed. Keep setup/workflow/build files unchanged; those are not auto-accepted. GitHub may still require approval before a new contributor's build can run. Merge conflicts or a red build need fixing.
7. Look at the Actions tab for the result. When deployment succeeds, join and type `/hello`.

## Examples

- `/hello`: variables and strings in `BeginnerExamples.java`.
- Join welcome: a Java method called by a player-join event.
- `/dice`: random numbers.
- `/count`: a short loop in `ClassServerPlugin.java`.

Keep edits small. A red build means the previous plugin stays installed. A successful build is only a compile check, not a safety check: bad Java can still crash the server or damage its world. Git history helps trace changes but does not authenticate every author or restore a world.

## Work on your own computer

Install a Java 25 JDK and IntelliJ IDEA Community (or your IDE). Clone the repo, open it as a Gradle project, and allow Gradle to load. For local builds, install Gradle 9.8.0, or let IntelliJ use that Gradle version. The binary wrapper could not be uploaded, so use Gradle directly.

Windows: `gradle clean build`

Mac/Linux: `gradle clean build`

The output is `build/libs/class-server.jar`. Do not commit compiled JARs. Test new behavior on a local Paper server before changing the shared world.

To add a command, add its name in `src/main/resources/plugin.yml`, then add a matching switch case in `ClassServerPlugin.java`. Use a new unique name so you do not overwrite another plugin's command.

## Before the first automatic deployment

This staged project is NOT linked yet. See `docs/ACTIVATION.md`. The target API is Paper 26.3.build.141-beta with Java 25, matching the live server startup log read October 2. The project compiles against that API; server plugin loading still needs a real deployment test.

Automation is staged for public pull requests from anyone, as Jonah requested. Anyone who finds this public repo can propose Java code that runs on the server. Sharing a link does not give direct push access; successful eligible PRs are auto-merged instead. GitHub fork-run approval settings may still require a maintainer action for new accounts.

## Ground rules

Do not commit passwords, API keys, server backups, world/player files, or private data. No infinite loops or blocking sleeps. Coordinate edits to the same file. Only `class-server.jar` is uploaded; other plugins and worlds are not synchronized or deleted.

Donations are optional and do not buy perks. The prepared Ko-fi page still needs Jonah's Stripe onboarding. No working donation checkout is claimed yet.
