package ua.training.controller;

import ua.training.model.*;
import ua.training.view.*;

import java.util.Scanner;

import static ua.training.controller.RegExConstants.*;
import static ua.training.view.TextConstants.*;

public class Controller {
    private final Model model;
    private final View view;
    private Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        model.initRec(inputCheck(INPUT_LOGIN, REGEX_LOGIN),
                inputCheck(INPUT_NAME, REGEX_NAME_LATIN),
                inputCheck(INPUT_SURNAME, REGEX_NAME_LATIN));
    }

    public String inputCheck(String message, String regex) {
        String input;
        view.printMessage(message);
        while(! (scanner.hasNext() && (input = scanner.next()).matches(regex))) {
            view.printMessage(INPUT_ERROR);
        }
        return input;
    }
}