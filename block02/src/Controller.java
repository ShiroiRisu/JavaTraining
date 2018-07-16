import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        model.setNumber(model.rand(0, 100));
        view.printMessage(View.MESSAGE_WELCOME);
        startGameLoop(scanner);
    }

    private void startGameLoop(Scanner scanner) {
        while(true) {
            view.printInfo(model.getTries(), model.getMin(), model.getMax());
            if (scanner.hasNext("quit")) {
                System.exit(1);
            } else if (!scanner.hasNextInt()) {
                view.printMessage(View.ERROR_INT);
                scanner.next();
            } else {
                int val = scanner.nextInt();
                if (val >= model.getMin() && val <= model.getMax()) {
                    model.setGuess(val);
                    if (val == model.getNumber()) {
                        view.printGuesses(model.getGuesses(), model.getTries());
                        System.exit(0);
                    } else if (val > model.getNumber()) {
                        view.printMessage(View.MESSAGE_LOWER);
                        model.setMax(val);
                    } else {
                        view.printMessage(View.MESSAGE_HIGHER);
                        model.setMin(val);
                    }
                    model.incTries();
                } else {
                    view.printRangeMessage(model.getMin(), model.getMax());
                }
            }
        }
    }
}