package me.whale.data.api.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {
    private final static Validator VALIDATOR = Validation.byDefaultProvider().configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory().getValidator();

    @Test
    void test() {
        UserLogin userLogin = new UserLogin();
        Set<ConstraintViolation<UserLogin>> constraintViolationSet = VALIDATOR.validate(userLogin);
        assertTrue(constraintViolationSet.size() > 1, "not valid");
    }

}