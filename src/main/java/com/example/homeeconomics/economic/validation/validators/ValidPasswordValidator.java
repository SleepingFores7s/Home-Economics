package com.example.homeeconomics.economic.validation.validators;

import com.example.homeeconomics.economic.validation.annotations.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("^(?=.*[!#%])[A-Za-z0-9!#%]{7,64}$");
    }
}
