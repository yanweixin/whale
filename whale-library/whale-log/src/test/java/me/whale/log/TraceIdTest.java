package me.whale.log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraceIdTest {

    @Test
    void next() {
        System.out.println(TraceId.next());
    }
}