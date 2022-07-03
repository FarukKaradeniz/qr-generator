package com.farukkaradeniz.qrgenerator.data.enumeration;

public enum QrShapeEnum {
    CIRCLE("CIRCLE"),
    SQUARE("SQUARE");

    private final String value;

    QrShapeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
