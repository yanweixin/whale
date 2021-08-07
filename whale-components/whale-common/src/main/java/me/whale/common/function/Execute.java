package me.whale.common.function;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Execute {
    private static final int numOfCores = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executor;

    static {
//        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numOfCores * 8);
        executor = Executors.newWorkStealingPool(numOfCores);
    }

    public static Future<?> runnable(Runnable runnable) {
        return executor.submit(runnable);
    }

    public static <T> void function(Consumer<T> consumer, T t) {
        executor.submit(() -> consumer.accept(t));
    }

    public static <T, R> void function(BiConsumer<T, R> consumer, T t, R r) {
        executor.submit(() -> consumer.accept(t, r));
    }

    public static <T, R> Future<R> function(Function<T, R> function, T t) {
        return executor.submit(() -> function.apply(t));
    }

    public static <T, U, R> Future<R> function(BiFunction<T, U, R> function, T t, U u) {
        return executor.submit(() -> function.apply(t, u));
    }

}