package me.whale.utils.lang;

import java.io.InputStream;

public final class ClassUtil {
    private ClassUtil() {
    }

    public static InputStream getResourceAsStream(String name) {
        return getResourceAsStream(ClassUtil.class, name);
    }

    public static InputStream getResourceAsStream(Class<?> clazz, String name) {
        return clazz.getClassLoader().getResourceAsStream(name);
    }
}
