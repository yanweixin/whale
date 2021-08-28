package me.whale.utils.lang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.math.BigDecimal;
import java.math.RoundingMode;

class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void test() {
        BigDecimal b = new BigDecimal("2133");
        logger.info(b.setScale(2, RoundingMode.HALF_UP).toPlainString());
    }
}