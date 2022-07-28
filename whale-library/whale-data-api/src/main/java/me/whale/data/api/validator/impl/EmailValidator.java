package me.whale.data.api.validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import me.whale.data.api.validator.annotation.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, CharSequence> {
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return true;
    }
}
