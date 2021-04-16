package com.company;

public enum SpareParts {
    HEAD("HEAD"),
    BODY("BODY"),
    LEFTARM("LEFTARM"),
    RIGHTARM("RIGHTARM"),
    LEFTLEG("LEFTLEG"),
    RIGHTLEG("RIGHTLEG"),
    CPU("CPU"),
    RAM("RAM"),
    HDD("HDD");

    private String value;

    SpareParts(String value) {
        this.value = value;
    }
}
