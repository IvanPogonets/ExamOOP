package com.exam.app;

public enum Industry {
    FINANCE("Finance"),
    TECH("Tech"),
    LOGISTICS("Logistics");

    private final String name;

    Industry(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

