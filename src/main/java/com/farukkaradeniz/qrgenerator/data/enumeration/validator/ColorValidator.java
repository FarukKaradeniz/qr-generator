package com.farukkaradeniz.qrgenerator.data.enumeration.validator;

import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Color;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ColorValidator implements ConstraintValidator<Color, String> {
    @Override
    public void initialize(Color constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (!value.startsWith("#") || value.length() != 7) { // Only Expecting 6 Digits Hex Code
            return false;
        }
        return Pattern.compile("[a-fA-F0-9]{6}").matcher(value.substring(1)).matches();
    }
}
