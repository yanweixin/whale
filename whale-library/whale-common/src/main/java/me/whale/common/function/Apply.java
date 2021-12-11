package me.whale.common.function;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Apply {
    public static <T, R> R when(T t, Predicate<T> predicate, Function<T, R> function) {
        return predicate.test(t) ? function.apply(t) : null;
    }

    public static <T> void when(T t, Predicate<T> predicate, Consumer<T> consumer) {
        if (predicate.test(t)) {
            consumer.accept(t);
        }
    }

    public static <T, R> R orElse(Function<T, R> function, T t, R r) {
        return t == null ? r : function.apply(t);
    }

    public static <T, R> R orElseNull(Function<T, R> function, T t) {
        return orElse(function, t, null);
    }

    public static <T, R> R notNull(T t, Function<T, R> function) {
        return when(t, Objects::nonNull, function);
    }

    public static <T> void notNull(T t, Consumer<T> consumer) {
        when(t, Objects::nonNull, consumer);
    }

    public static <T, R extends List<T>> Stream<T> getStream(Supplier<R> supplier) {
        return Optional.ofNullable(supplier.get()).stream().flatMap(Collection::parallelStream);
    }
}
