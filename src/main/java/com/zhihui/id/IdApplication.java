package com.zhihui.id;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableDubbo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IdApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdApplication.class, args);
    }

}
