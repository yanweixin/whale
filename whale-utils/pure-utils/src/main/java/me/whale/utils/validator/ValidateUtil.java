package me.whale.utils.validator;

public class ValidateUtil {

    public boolean matches(CharSequence value, CharSequence pattern) {
        return false;
    }

    public boolean isValidDate(CharSequence date, CharSequence pattern) {
        return DateTimeValidator.getInstance().isValid(date, pattern);
    }


}
