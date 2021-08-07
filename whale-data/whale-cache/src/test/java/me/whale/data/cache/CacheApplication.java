package me.whale.data.cache;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CacheApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
