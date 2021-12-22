package me.whale.log;

import me.whale.utils.lang.SystemUtil;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weixin
 */
public class TraceId {
    public static final String APP_NAME = System.getenv("APP_NAME");
    public static final AtomicInteger SEQUENCE = new AtomicInteger();

    private TraceId() {
    }

    public static String next() {
        return APP_NAME + "_" +
                OffsetDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyyMMdd.HHmmss.SSS")) + "_" +
                SystemUtil.LOCAL_ADDRESS.getHostAddress() + "_" +
                SystemUtil.PID + "_" + SEQUENCE.incrementAndGet();
    }
}
