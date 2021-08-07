package me.whale.data.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import me.whale.data.api.model.UserLogin;
import org.apache.commons.lang3.StringUtils;

public class UserLoginValidator implements ConstraintValidator<ValidUserLogin, UserLogin> {
    @Override
    public void initialize(ValidUserLogin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLogin value, ConstraintValidatorContext context) {
        boolean valid = value != null && !StringUtils.isAllBlank(value.getUserNo(), value.getEmail(), value.getPhone());
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userNo,email,phone can not all be null.")
                    .addConstraintViolation();
        }
        return valid;
    }

}
