package com.farukkaradeniz.qrgenerator.data.enumeration.annotation;

import com.farukkaradeniz.qrgenerator.data.enumeration.validator.ColorValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ColorValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Color {
    String message() default "Invalid color hex code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
