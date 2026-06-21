package com.example.homeeconomics.economic.validation.annotations;

import com.example.homeeconomics.economic.validation.validators.ValidUsernameOrEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidUsernameOrEmailValidator.class})
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsernameOrEmail {
    String message() default "Must be a valid username or email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}