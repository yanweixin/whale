package me.whale.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.kotlin.KotlinFeature;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Objects;

public final class JacksonUtil {
    private final static JsonMapper JSON_MAPPER;
    private final static JsonFactory JSON_FACTORY;

    static {
        KotlinModule kotlinModule = new KotlinModule.Builder()
                .configure(KotlinFeature.StrictNullChecks, true)
                .build();
        JSON_MAPPER = JsonMapper.builder()
                .addModule(new GuavaModule())
                .addModule(new JavaTimeModule())
                .addModule(kotlinModule)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .build();
//        JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        JSON_FACTORY = JsonFactory.builder()
                .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS)
                .build();
    }

    private JacksonUtil() {
    }

    public static void writeValue(final Object value, final OutputStream outputStream) {
        if (value != null) {
            try {
                JSON_MAPPER.writeValue(outputStream, value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T deSerialize(final String content, final Class<T> valueType) {
        if (StringUtils.isNotBlank(content)) {
            try {
                return JSON_MAPPER.readValue(content, valueType);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String serialize(final Object value) {
        if (Objects.nonNull(value)) {
            try {
                if (value instanceof CharSequence) {
                    return value.toString();
                } else {
                    return JSON_MAPPER.writeValueAsString(value);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T readTree(final String value, final String path) {
        if (StringUtils.isNotBlank(value)) {
            try {
                JsonNode jsonNode = JSON_MAPPER.readTree(value);
                if (path != null) {
                    jsonNode = jsonNode.findValue(path);
                }
                return JSON_MAPPER.convertValue(jsonNode, new TypeReference<T>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JsonMapper getJsonMapper() {
        return JSON_MAPPER;
    }

    public static JsonParser createJsonParser(String content) {
        try {
            return JSON_FACTORY.createParser(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonGenerator createGenerator(OutputStream outputStream) {
        try {
            return JSON_FACTORY.createGenerator(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonGenerator createGenerator(Writer writer) {
        try {
            return JSON_FACTORY.createGenerator(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
