package me.whale.utils.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemUtilTest {

    @Test
    void getPid() {
        assertEquals(ProcessHandle.current().pid(), SystemUtil.PID);
    }
}