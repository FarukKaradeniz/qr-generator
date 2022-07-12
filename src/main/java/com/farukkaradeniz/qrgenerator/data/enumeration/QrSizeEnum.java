package com.farukkaradeniz.qrgenerator.data.enumeration;

public enum QrSizeEnum {
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");

    private final String value;

    QrSizeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
