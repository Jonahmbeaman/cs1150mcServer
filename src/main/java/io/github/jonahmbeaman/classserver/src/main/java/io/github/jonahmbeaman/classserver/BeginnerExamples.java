package io.github.jonahmbeaman.classserver;

import java.util.concurrent.ThreadLocalRandom;

// Start here. These are ordinary Java methods, not a separate scripting language.
public final class BeginnerExamples {
    private BeginnerExamples() { }

    // Example 1: a string variable and a return statement.
    public static String hello(String name) {
        String greeting = "Hello, " + name + "!";
        return greeting;
    }

    // Example 2: string joining. Runs when someone joins the server.
    public static String welcome(String name) {
        return "Welcome, " + name + "! Try /hello, /dice, and /count.";
    }

    // Example 3: a random integer from 1 to 6.
    public static int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    // Challenge: add an if/else in hello() for a friend's name.
    // Challenge: change the loop in ClassServerPlugin to count by twos.
    // Keep loops bounded. Never use while(true), Thread.sleep, or file deletion.
}
