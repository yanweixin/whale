package me.whale.data.api.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserLoginValidator.class)
@Documented
public @interface ValidUserLogin {
    String message() default "{me.whale.message.valid.user.login}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
