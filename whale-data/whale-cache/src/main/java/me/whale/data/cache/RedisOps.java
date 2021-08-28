package me.whale.data.cache;

import me.whale.utils.lang.ClassUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class RedisOps {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisOps.class);
    private static final RedisOps INSTANCE = new RedisOps();
    private final RedissonClient redisson;

    private RedisOps() {
        LOGGER.info("start create redisson client");
        try {
            Config config = Config.fromYAML(ClassUtil.getResourceAsStream("redis-cluster.yml"));
            redisson = Redisson.create(config);
        } catch (IOException e) {
            LOGGER.error("create redisson client error ", e);
            throw new RuntimeException(e.getMessage());
        } finally {
            LOGGER.info("redisson client creation end");
        }
    }

    public static RedisOps getInstance() {
        return INSTANCE;
    }

}
