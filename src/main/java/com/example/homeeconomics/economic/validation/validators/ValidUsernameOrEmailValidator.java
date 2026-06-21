package com.example.homeeconomics.economic.validation.validators;


import com.example.homeeconomics.economic.validation.annotations.ValidUsernameOrEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameOrEmailValidator implements ConstraintValidator<ValidUsernameOrEmail, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }

        if (value.contains("@")) {
            // validate as email
            return value.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        } else {
            // validate as username
            return value.matches("^[A-Za-z0-9_]{3,20}$");
        }
    }
}

