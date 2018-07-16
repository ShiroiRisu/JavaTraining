public class View {
    public static final String MESSAGE_WELCOME = "-----------------------------------------------------------\n" +
            "Welcome to the ultimate Java Guesser. I want to play a game\n" +
            "I've chosen a random int value in range [0,100] (square brackets means including edge values ofc)\n" +
            "Try to guess what is it, preferably faster then from 99th try. I promise not to change it LUL\n" +
            "=============TO EXIT TYPE 'EXIT'=============\n" +
            "literally, yeah, who would've guessed, right?\n";
    public static final String MESSAGE_HIGHER = "My number is higher than your current guess.";
    public static final String MESSAGE_LOWER = "My number is lower than your current guess.";
    public static final String ERROR_INT = "Dude, ffs, its not an integer. Or 'quit'. Pls behave and reenter";
    public static final String MESSAGE_SUCCESS = "You've guessed it! Performing subaru right now >_<";

    public void printInfo(int turn, int min, int max) {
        System.out.printf("--------TURN %d--------\n" +
                          "-GUESS RANGE:[%d,%d]-\n", turn + 1, min, max);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRangeMessage(int i1, int i2) {
        System.out.printf("Woah Nelly, that's not in [%d,%d] range\n", i1, i2);
    }

    public void printGuesses(int[] guesses, int tries) {
        printMessage(MESSAGE_SUCCESS);
        System.out.printf("It took you %d turns to guess. All guesses in order:\n", tries + 1);
        for (int i = 0; i <= tries; ++i) {
            System.out.printf("%d ", guesses[i]);
        }
    }
}