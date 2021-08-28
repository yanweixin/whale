package me.whale.wrapper;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

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

    public static Yaml createYaml() {
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setAllowDuplicateKeys(false);
        return new Yaml(new Constructor(loaderOptions), new Representer(),
                new DumperOptions(), loaderOptions);
    }
}
