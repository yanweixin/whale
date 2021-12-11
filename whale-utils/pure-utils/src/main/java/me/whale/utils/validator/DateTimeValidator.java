package me.whale.utils.validator;

import java.time.OffsetDateTime;

public class DateTimeValidator extends GenericValidator {
    private static final DateTimeValidator VALIDATOR = new DateTimeValidator();

    public static DateTimeValidator getInstance() {
        return VALIDATOR;
    }

    @Override
    boolean isValid(CharSequence value, CharSequence pattern) {
        return false;
    }

    OffsetDateTime validate(CharSequence value) {
        return OffsetDateTime.now();
    }
}
