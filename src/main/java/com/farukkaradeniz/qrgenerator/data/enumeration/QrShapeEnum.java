package com.farukkaradeniz.qrgenerator.data.enumeration;

import java.util.Arrays;

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

    public static QrShapeEnum fromValue(String value) {
        return Arrays.stream(QrShapeEnum.values())
                .filter(shape -> shape.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
