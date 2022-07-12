package com.farukkaradeniz.qrgenerator.data.enumeration.validator;

import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Color;
import com.farukkaradeniz.qrgenerator.util.Utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ColorValidator implements ConstraintValidator<Color, String> {
    @Override
    public void initialize(Color constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return Utils.validateColorHex(value);
    }
}
