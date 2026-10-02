package io.github.jonahmbeaman.classserver;

// No game server needed. These checks run as part of Gradle build.
public final class ExampleChecks {
    public static void main(String[] args) {
        if (BeginnerExamples.hello("Alex") == null) {
            throw new AssertionError("hello must return text");
        }
        if (BeginnerExamples.welcome("Alex") == null) {
            throw new AssertionError("welcome must return text");
        }
        for (int i = 0; i < 100; i++) {
            int roll = BeginnerExamples.rollDice();
            if (roll < 1 || roll > 6) {
                throw new AssertionError("dice must return 1 through 6");
            }
        }
        System.out.println("Example checks passed.");
    }
}
