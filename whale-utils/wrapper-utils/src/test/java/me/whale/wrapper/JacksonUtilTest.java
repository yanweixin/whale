package me.whale.wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JacksonUtilTest {

    @Test
    void writeValue() {
        JacksonUtil.writeValue("123", System.out);
    }

    @Test
    void deSerialize() {
    }

    @Test
    void serialize() {
        assertNull(JacksonUtil.serialize(null));
        assertNotNull(JacksonUtil.serialize(""));
        Date now = new Date();
        assertEquals(String.valueOf(now.getTime()), JacksonUtil.serialize(now));
        System.out.println(JacksonUtil.serialize(LocalDateTime.now()));
    }

    @Test
    void readTree() {
    }

    @Test
    void getObjectMapper() throws JsonProcessingException {
        assertEquals("null", JacksonUtil.getObjectMapper().writeValueAsString(null));
    }
}