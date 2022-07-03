package com.farukkaradeniz.qrgenerator.data.enumeration.validator;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Shape;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QrShapeEnumValidator implements ConstraintValidator<Shape, String> {

    @Override
    public void initialize(Shape constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return QrShapeEnum.fromValue(value) != null;
    }
}