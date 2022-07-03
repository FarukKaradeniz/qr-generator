package com.farukkaradeniz.qrgenerator.data.enumeration;

public enum QrColorEnum {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    BLACK("#000000");


    private final String value;

    QrColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
