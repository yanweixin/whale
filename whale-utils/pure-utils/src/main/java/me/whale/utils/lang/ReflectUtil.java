package me.whale.utils.lang;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ReflectUtil {
    private ReflectUtil() {
    }

    public static enum MethodType {
        /**
         * getter method
         */
        GETTER,
        /**
         * setter method
         */
        SETTER
    }

    public static <T> List<Field> getAllFields(T base) {
        return getAllFieldsExcept(base, Object.class);
    }

    public static <T, R extends Class<?>> List<Field> getAllFieldsExcept(T base, R exclude) {
        final List<Field> fields = new ArrayList<>();
        Class<?> supperClass;
        if (base instanceof Class<?>) {
            supperClass = (Class<?>) base;
        } else {
            supperClass = base.getClass();
        }
        if (!exclude.isAssignableFrom(supperClass)) {
            throw new IllegalArgumentException(exclude.getName() + " must be supper class of " + supperClass.getName());
        }
        while (supperClass != null && supperClass != exclude) {
            Collections.addAll(fields, supperClass.getDeclaredFields());
            supperClass = supperClass.getSuperclass();
        }
        return fields;
    }

    public static <T> String[] getAllFieldsName(T base) {
        return getAllFieldsNameExcept(base, Object.class);
    }

    public static <T, R extends Class<?>> String[] getAllFieldsNameExcept(T base, R exclude) {
        return StringUtil.toStringArray(getAllFieldsExcept(base, exclude), Field::getName);
    }

    @SuppressWarnings("unchecked")
    public static <T, A extends Annotation> String[] getAnnotationFields(T source, Class<A>... annotationClasses) {
        final List<String> annotationFields = new ArrayList<>();
        for (Field field : getAllFields(source)) {
            for (Class<A> clazz : annotationClasses) {
                if (field.getAnnotation(clazz) != null) {
                    annotationFields.add(field.getName());
                }
            }
        }
        return annotationFields.toArray(String[]::new);
    }

    public static <T> Map<String, Method> getMethodMap(Class<T> clazz, Predicate<Method> filter) {
        final Map<String, Method> methodMap = new HashMap<>();
        for (Method method : Arrays.stream(clazz.getDeclaredMethods())
                .filter(filter)
                .collect(Collectors.toList())) {
            methodMap.put(method.getName(), method);
        }
        return methodMap;
    }

    public static <T> Method getMethod(MethodType methodType, Class<T> clazz, Field field) throws NoSuchMethodException {
        Objects.requireNonNull(methodType);
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(field);
        if (methodType == MethodType.GETTER) {
            return clazz.getDeclaredMethod("get" + StringUtil.capitalize(field.getName()));
        } else if (methodType == MethodType.SETTER) {
            return clazz.getDeclaredMethod("set" + StringUtil.capitalize(field.getName()), field.getType());
        } else {
            throw new NoSuchMethodException();
        }
    }
}
