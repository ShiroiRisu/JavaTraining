package ua.training.view;

import java.util.ResourceBundle;

public class View {
    private static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);

    public void printMessage(String message) { System.out.println(bundle.getString(message)); }
}