package com.example.homeeconomics.economic.validation.annotations;


import com.example.homeeconomics.economic.validation.validators.ValidPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidPasswordValidator.class})
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Password must include !, # or % and be at least 7 characters long";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
