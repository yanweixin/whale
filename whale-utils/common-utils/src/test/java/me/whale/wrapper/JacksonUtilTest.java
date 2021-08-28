package me.whale.wrapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JacksonUtilTest extends BaseTest {

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
        assertEquals("null", JacksonUtil.getJsonMapper().writeValueAsString(null));
    }

    @Test
    void test() throws IOException {
        Writer stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = JacksonUtil.createGenerator(stringWriter);
        if (jsonGenerator == null) {
            return;
        }
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeNumberField("111", new BigDecimal("10000").setScale(2, RoundingMode.HALF_UP));
//        jsonGenerator.writeEndObject();
        jsonGenerator.writeNumber(new BigDecimal("10000").setScale(2, RoundingMode.HALF_UP));
        jsonGenerator.flush();
        logger.info(stringWriter.toString());
    }
}