package ua.training.model;

public class Model {
    private Record rec = null;

    public void initRec(String nickname, String name, String surname) {
        rec = new Record.Builder(nickname).name(name).surname(surname).build();
    }
}