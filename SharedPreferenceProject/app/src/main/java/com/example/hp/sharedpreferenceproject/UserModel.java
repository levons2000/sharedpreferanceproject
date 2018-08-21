package com.example.hp.sharedpreferenceproject;

public class UserModel {
    private final String name;
    private final String surname;

    UserModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
