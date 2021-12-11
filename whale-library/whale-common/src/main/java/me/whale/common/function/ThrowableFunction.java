package me.whale.common.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface ThrowableFunction<T, R> {
    R apply(T t) throws Throwable;

    default <V> ThrowableFunction<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> ThrowableFunction<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> ThrowableFunction<T, T> identity() {
        return t -> t;
    }
}