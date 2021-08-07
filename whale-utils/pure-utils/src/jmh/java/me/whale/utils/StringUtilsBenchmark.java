package me.whale.utils;

import me.whale.utils.lang.StringUtil;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringUtilsBenchmark {
    @Benchmark
    public void isEmptyTest() {
        StringUtil.defaultString("");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringUtil.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
