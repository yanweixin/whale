package me.whale.utils.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public final class ClassUtil {
    private ClassUtil() {
    }

    public static InputStream getResourceAsStream(String name) {
        return getResourceAsStream(ClassUtil.class, name);
    }

    public static InputStream getResourceAsStream(Class<?> clazz, String name) {
        return clazz.getClassLoader().getResourceAsStream(name);
    }

    public static Class<?>[] getPackageClasses(String packageName)
            throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[0]);
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
//                classes.add(Class.forName(className));
//                classes.add(ClassLoader.getSystemClassLoader().loadClass(className));
                classes.add(Class.forName(className, false, ClassUtil.class.getClassLoader()));
            }
        }
        return classes;
    }
}
