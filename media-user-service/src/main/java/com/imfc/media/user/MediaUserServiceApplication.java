package com.imfc.media.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableDubbo
public class MediaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaUserServiceApplication.class, args);
    }

}
