package me.whale.utils.lang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class StringUtil {
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String LF = "\n";
    public static final String CR = "\r";

    public static boolean startWith(String source, List<String> prefixes) {
        return prefixes.stream().anyMatch(source::startsWith);
    }

    public static String decodeBytes(byte[] bytes, String charset) {
        if (charset == null) {
            return decodeBytes(bytes, StandardCharsets.UTF_8);
        } else {
            return decodeBytes(bytes, Charset.forName(charset));
        }
    }

    private static String decodeBytes(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    public static String[] concat(String[] first, String[] second) {
//        Stream.of(first, second).flatMap(Stream::of).toArray(String[]::new);
//        Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(String[]::new);
        String[] both = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, both, first.length, second.length);
        return both;
    }

    public static String[] addPrefix(final String[] strings, final String prefix) {
        Objects.requireNonNull(strings);
        Objects.requireNonNull(prefix, "prefix must not be null.");
        return Arrays.stream(strings).map(prefix::concat).toArray(String[]::new);
    }

    public static <T> String[] toStringArray(List<T> list, Function<T, String> mapper) {
        return list.stream().map(mapper).toArray(String[]::new);
    }

    public static String toString(final InputStream in) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8);
    }

    public static String defaultString(final String str, final String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static String defaultString(final String str) {
        return defaultString(str, EMPTY);
    }

    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }

    public static String capitalize(final String str) {
        if (length(str) == 0) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
