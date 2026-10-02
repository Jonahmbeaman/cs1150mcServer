# The Stone Zone


you can upload code through here and it will ship to the server and update asap
generally try to make sure ur code works before you send it because every update causes a restart. too many restarts at once and bad things happen
theoretically you can delete the server through, so please dont if ppl are building stuff. honor system type shi yk?

## 1. Join the server
IP:
   ```text
   51.161.0.7:25573
   ```

If Minecraft says the version is incompatible, use the Minecraft version shown for the server. If it is restarting, wait a few minutes and try again.

## 2. Try the examples

Once you are in the game, press **T** to open chat. Type one command, then press **Enter**:

- `/hello` gives you a greeting.
- `/dice` rolls a number from 1 to 6.
- `/count` prints the numbers 1 to 5.
- `/speed` gives your own player Speed III for 5 hours of game time.

These examples are already installed. The greeting is a good place to make your first change.

## 3. lil tutorial step by step so yk how it all works

You need a free GitHub account. You do not need to install a code editor for this example.

1. Sign in at [github.com](https://github.com/).
2. Open [this project's page](https://github.com/Jonahmbeaman/cs1150mcServer).
3. Open [BeginnerExamples.java](src/main/java/io/github/jonahmbeaman/classserver/BeginnerExamples.java). This is the file containing the greeting.
4. Click the **pencil** above the code. GitHub may ask you to **Fork this repository**. A fork is your own copy where you can make changes. Continue with that option.
5. Find this line:

   ```java
   return "Hello, " + name + "!";
   ```

6. Change only the words inside the first pair of quotes. For example:

   ```java
   return "Welcome, " + name + "!";
   ```

   Keep the quotes, `+` signs, and semicolon. Leave the other lines unchanged.

7. Click **Commit changes...**.
8. In the commit message box, write what you changed. For example: `Change hello greeting`.
9. Save the change. If GitHub offers **Propose changes**, use that option.
10. Open a **pull request**. This asks the shared project to use your change. If GitHub shows **Compare & pull request**, click it. Otherwise, open the **Pull requests** tab in your fork and click **New pull request**.
11. Check that the destination is `Jonahmbeaman/cs1150mcServer`, branch `main`, and that the comparison is your changed branch.
12. Click **Create pull request**, add a short description, then click **Create pull request** again to submit it.

If you already have permission to save directly to the shared `main` branch, GitHub may let you skip the fork and pull request steps. Most contributors will use a pull request.

## 4. Wait for the checks, then test

1. Open your pull request. GitHub checks whether the Java code builds.
2. If the check fails, open its details, fix your code in the same file, and save again. You do not need another pull request.
3. If your GitHub account is new, the first check may say it needs approval. Ask the me to approve on the discord or smt and i will.
4. Changes to the example Java files are set up to merge automatically after a successful check. A conflict or a change to protected setup files can stop the merge.
5. Open the shared project's **Actions** tab. Look for **Deploy class changes automatically** and wait for a green check.
6. The server briefly disconnects players while it restarts. Rejoin, open chat, and type `/hello`.
7. You should see your new greeting.

The GitHub-to-server deployment and the three example commands have been tested. The first contribution from an outside fork still needs a live test, so report a pull request that passes its check but does not merge.

## 5. Add more Java code

This server uses **Paper plugins**. It does not run a loose `.txt`, `.py`, or `.js` script, and it does not load Forge or Fabric mods.

For another small change, edit [BeginnerExamples.java](src/main/java/io/github/jonahmbeaman/classserver/BeginnerExamples.java) using the same steps above.

To add a new command, two files need to agree:

- [plugin.yml](src/main/resources/plugin.yml) lists the command name.
- [ClassServerPlugin.java](src/main/java/io/github/jonahmbeaman/classserver/ClassServerPlugin.java) contains the code that runs for that command.

Use an existing command as an example. Pick a new command name. Adding a Java file alone does not make a command run in the game.

### Example: the /speed command

Join the server, press **T**, type `/speed`, and press **Enter**. Your player gets Speed III. It lasts 5 hours of game time unless removed earlier, for example by drinking milk or dying.

To find the code:

1. Open [ClassServerPlugin.java](src/main/java/io/github/jonahmbeaman/classserver/ClassServerPlugin.java).
2. Find `case "speed"`. That block runs when a player uses `/speed`.
3. Find `int durationTicks = 5 * 60 * 60 * 20;`. The numbers mean 5 hours, 60 minutes per hour, 60 seconds per minute, and 20 game ticks per second.
4. Find `int amplifier = 2;`. Minecraft counts from zero here: `0` is Speed I, `1` is Speed II, and `2` is Speed III.
5. For a small test, change only the `5` to `1`. Save it and open a pull request using the steps above. After deployment, `/speed` will apply a 1-hour effect.

The command affects only the player who uses it. Running it from the server console returns a reminder to use it in-game. On a lagging server, game time can take longer than clock time.

GitHub builds the code into one plugin file and sends it to the server. Do not upload compiled `.jar` files or zip files to this repository.

## Keep the server usable

- Make one small change at a time. Each accepted code change restarts the server.
- Wait for a deployment to finish before sending another change. Do not spam commits.
- Avoid endless loops and code that makes the server wait.
- A green build checks compilation, not safety. Code can still crash the server or damage the world.
- A manual world snapshot exists. It is not a continuous backup.



## Optional donations

[Donate through Ko-fi](https://ko-fi.com/majinta). The minimum is $1. Donations do not buy perks. Processing fees apply, and funds go to the owner's Stripe account and bank, not directly to the hosting company.

[Deployment and recovery notes](docs/ACTIVATION.md)
