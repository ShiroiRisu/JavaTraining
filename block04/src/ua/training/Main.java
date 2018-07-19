package ua.training;

import ua.training.model.*;
import ua.training.view.*;
import ua.training.controller.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.start();
    }
}