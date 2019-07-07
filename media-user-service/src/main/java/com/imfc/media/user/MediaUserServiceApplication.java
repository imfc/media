package com.imfc.media.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MediaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaUserServiceApplication.class, args);
    }

}
