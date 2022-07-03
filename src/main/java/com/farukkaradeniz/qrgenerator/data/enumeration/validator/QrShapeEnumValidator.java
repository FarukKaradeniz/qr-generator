package com.farukkaradeniz.qrgenerator.data.enumeration.validator;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.QrShape;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QrShapeEnumValidator implements ConstraintValidator<QrShape, String> {

    @Override
    public void initialize(QrShape constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return QrShapeEnum.fromValue(value) != null;
    }
}