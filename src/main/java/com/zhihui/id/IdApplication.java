package com.zhihui.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IdApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdApplication.class, args);
    }

}
