package me.whale.wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    void print(String left, String right) {
        LevenshteinDistance distance = LevenshteinDistance.getDefaultInstance();
//        CosineDistance distance = new CosineDistance();
        System.out.println(distance.apply(left, right));
    }
}
