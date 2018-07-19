package ua.training.model;

public class Record {
    private final String name;
    private final String surname;
    private final String login;

    public static class Builder {
        private String name;
        private String surname;
        private final String login;

        public Builder(String login) { this.login = login; }

        public Builder name(String name) { this.name = name;        return this; }

        public Builder surname(String surname) { this.surname = surname;        return this;}

        public Record build() { return new Record(this); }
    }

    public Record(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.login = builder.login;
    }
}