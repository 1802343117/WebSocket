package com.soft1851.devoted;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.soft1851.devoted.mapper")
public class DevotedApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevotedApplication.class, args);
    }

}
