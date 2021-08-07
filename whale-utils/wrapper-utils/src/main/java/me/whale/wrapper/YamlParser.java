package me.whale.wrapper;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.io.Writer;
import java.util.Map;

public final class YamlParser {
    private YamlParser() {
    }

    public static Yaml construct(Class<?> clazz) {
        return new Yaml(new Constructor(clazz));
    }

    public static Map<String, Object> load(InputStream source) {
        Yaml yaml = new Yaml();
        return yaml.load(source);
    }

    public static Map<String, Object> load(String source) {
        Yaml yaml = new Yaml();
        return yaml.load(source);
    }

    public static <T> T loadAs(InputStream source, Class<T> clazz) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(source, clazz);
    }

    public static void dump(Object data, Writer output) {
        Yaml yaml = new Yaml();
        yaml.dump(data, output);
    }
}
