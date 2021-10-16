package me.whale.utils.code;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegExpUtilTest {

    @Test
    void asRegex() {
        String reg = RegExpUtil.asRegex("org.apache.xmlbeans*");
        System.out.println(reg);
        System.out.println(Pattern.compile(reg).matcher("org.apache.xmlbeans.reg.class").matches());
        reg = RegExpUtil.asRegex("xmlbeans");
        System.out.println(reg);
        System.out.println(Pattern.compile(reg).matcher("org.apache.xmlbeans").matches());
    }
}