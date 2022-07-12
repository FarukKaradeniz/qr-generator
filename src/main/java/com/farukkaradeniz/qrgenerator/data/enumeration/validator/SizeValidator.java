package com.farukkaradeniz.qrgenerator.data.enumeration.validator;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Size;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class SizeValidator implements ConstraintValidator<Size, String> {
    @Override
    public void initialize(Size constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(QrSizeEnum.values()).anyMatch(sz -> sz.getValue().equals(s));
    }
}
