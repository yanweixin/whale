package me.whale.utils.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * @author weixin
 */
public class SystemUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(SystemUtil.class);
    public static final long PID = getPid();
    public static final InetAddress LOCAL_ADDRESS = getLocalAddress();

    private SystemUtil() {
    }

    /**
     * under Java 9 use following code
     * <pre><code>
     * String name = ManagementFactory.getRuntimeMXBean().getName();
     * pid = Long.parseLong(name.substring(0, name.indexOf("@")));
     * </code></pre>
     *
     * @return
     */
    private static long getPid() {
        long pid = 0;
        try {
            return ProcessHandle.current().pid();
        } catch (Throwable throwable) {
            LOGGER.error("Get current process id error", throwable);
        }
        return pid;
    }

    private static InetAddress getLocalAddress() {
        InetAddress localAddress = InetAddress.getLoopbackAddress();
        try {
            localAddress = InetAddress.getLocalHost();
        } catch (Throwable throwable) {
            LOGGER.error("Get local host error", throwable);
        }
        return localAddress;
    }
}
