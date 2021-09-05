package me.whale.data.dbms;

import me.whale.data.dbms.config.DataConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DataConfiguration.class)
public class RdbmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RdbmsApplication.class, args);
    }
}
