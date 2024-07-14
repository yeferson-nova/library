package com.ynova.library.model;

public class Student {

    private String name;
    private String dni;

    public Student(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Student \nname = " + name + "\ndni = " + dni;
    }

}
