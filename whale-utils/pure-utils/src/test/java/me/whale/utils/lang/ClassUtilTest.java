package me.whale.utils.lang;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class ClassUtilTest extends BaseTest {

    @Test
    void getPackageClasses() throws IOException, ClassNotFoundException, URISyntaxException {
        Class<?>[] classes = ClassUtil.getPackageClasses("me.whale");
        for (Class<?> clazz : classes) {
            logger.info(clazz.getName());
        }
        logger.info(getClass().getPackageName());
    }
}