package me.whale.wrapper;

import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BaseTest {

    @Test
    void test() {
        print("nh", "你好");
        print("hello", "hello world");
        print("你好", "你");
        print("世界", "你好，世界");

    }

    void print(String left, String right) {
        LevenshteinDistance distance = LevenshteinDistance.getDefaultInstance();
//        CosineDistance distance = new CosineDistance();
        System.out.println(distance.apply(left, right));
    }
}
