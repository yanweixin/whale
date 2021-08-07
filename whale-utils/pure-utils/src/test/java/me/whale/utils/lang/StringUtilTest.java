package me.whale.utils.lang;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @Test
    void startWith() {
    }

    @Test
    void decodeBytes() {
    }

    @Test
    void concat() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "start", "", "\n"})
    void addPrefix(String prefix) {
        String[] strings = StringUtil.addPrefix(new String[]{"1", "2", "3"}, prefix);
        assertThat(strings).allMatch(it -> it.startsWith(prefix));
    }

    @Test
    void toStringArray() {
    }

    @Test
    void testToString() {
    }

    @Test
    void defaultString() {
    }

    @Test
    void testDefaultString() {
    }

    @Test
    void length() {
    }

    @Test
    void capitalize() {
    }
}