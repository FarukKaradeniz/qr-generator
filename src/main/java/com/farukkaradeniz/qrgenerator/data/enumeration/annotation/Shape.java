package com.farukkaradeniz.qrgenerator.data.enumeration.annotation;

import com.farukkaradeniz.qrgenerator.data.enumeration.validator.ShapeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ShapeValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Shape {
    String message() default "Invalid QR shape parameter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
