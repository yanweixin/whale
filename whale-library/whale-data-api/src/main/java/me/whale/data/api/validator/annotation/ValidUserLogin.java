package me.whale.data.api.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = me.whale.data.api.validator.impl.UserLoginValidator.class)
@Documented
public @interface ValidUserLogin {
    String message() default "{me.whale.validator.ValidUserLogin.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
