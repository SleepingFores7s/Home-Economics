package com.example.homeeconomics.economic.validation.annotations;

import com.example.homeeconomics.economic.validation.validators.ValidUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidUsernameValidator.class})
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {

    String message() default "Must be between 4-12 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
