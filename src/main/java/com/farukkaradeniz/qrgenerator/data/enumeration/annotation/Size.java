package com.farukkaradeniz.qrgenerator.data.enumeration.annotation;

import com.farukkaradeniz.qrgenerator.data.enumeration.validator.SizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SizeValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {
    String message() default "Invalid QR size";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
