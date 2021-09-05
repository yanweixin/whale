package me.whale.utils.lang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Pattern;

class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void test() {
        logger.info("start log:" + new String(Base64.getEncoder().encode("123".getBytes(StandardCharsets.UTF_8))));
        logger.info("end log:" + new String(Base64.getDecoder().decode("MTIz")));
//        logger.info(String.valueOf(Pattern.compile("^-?\\d+(\\.\\d+)?$").matcher("***").matches()));
    }
}