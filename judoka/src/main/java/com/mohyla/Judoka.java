package com.mohyla;

public class Judoka {
    private String name;
    private int age;

    public Judoka(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return "Judo";
    }
}

