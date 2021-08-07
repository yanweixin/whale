package me.whale.utils.math;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MurmurHashTest {

    @Test
    void hash() {
        int hash = MurmurHash.hash("7088".getBytes(), 0);
        System.out.println(hash);
        System.out.println(Math.floorMod(hash, 7));
    }
}