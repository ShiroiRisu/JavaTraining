import java.lang.Math;

public class Model {
    private int number = -1;
    private int[] guesses = new int[100];
    private int tries = 0;
    private int min = 0;
    private int max = 100;

    public int rand(int min, int max) {
        double x = Math.random() / Math.nextDown(1.0);
        double val = (double)min * (1.0 - x) + (double)max * x;
        return (int)val;
    }

    public void setNumber(int val) {
        number = val;
    }

    public int getNumber() {
        return number;
    }

    public void setGuess(int val) {
        guesses[tries] = val;
    }

    public int getTries() {
        return tries;
    }

    public void incTries() {
        ++tries;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setMin(int val) {
        min = val;
    }

    public void setMax(int val) {
        max = val;
    }

    public int[] getGuesses() {
        return guesses;
    }
}