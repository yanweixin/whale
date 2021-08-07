package me.whale.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public final class JacksonUtil {
    private final static ObjectMapper OBJECT_MAPPER;

    static {
        KotlinModule kotlinModule = new KotlinModule.Builder()
                .strictNullChecks(true)
                .build();
        OBJECT_MAPPER = JsonMapper.builder()
                .addModule(new GuavaModule())
                .addModule(new JavaTimeModule())
                .addModule(kotlinModule)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .build();
//        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }

    private JacksonUtil() {
    }

    public static void writeValue(final Object value, final OutputStream outputStream) {
        if (value != null) {
            try {
                OBJECT_MAPPER.writeValue(outputStream, value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T deSerialize(final String content, final Class<T> valueType) {
        if (StringUtils.isNotBlank(content)) {
            try {
                return OBJECT_MAPPER.readValue(content, valueType);
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
                    return OBJECT_MAPPER.writeValueAsString(value);
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
                JsonNode jsonNode = OBJECT_MAPPER.readTree(value);
                if (path != null) {
                    jsonNode = jsonNode.findValue(path);
                }
                return OBJECT_MAPPER.convertValue(jsonNode, new TypeReference<T>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

}
