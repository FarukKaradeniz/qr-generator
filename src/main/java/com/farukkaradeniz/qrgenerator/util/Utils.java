package com.farukkaradeniz.qrgenerator.util;

import java.util.regex.Pattern;

public class Utils {

    public static int parseColorHexInteger(String color) {
        if (!validateColorHex(color)) {
            throw new IllegalArgumentException("Invalid color value");
        }

        return Integer.parseUnsignedInt("FF" + color.substring(1), 16);
    }

    public static boolean validateColorHex(String color) {
        if (color == null || !color.startsWith("#") || color.length() != 7) { // Only Expecting 6 Digits Hex Code
            return false;
        }
        return Pattern.compile("[a-fA-F0-9]{6}").matcher(color.substring(1)).matches();
    }
}
