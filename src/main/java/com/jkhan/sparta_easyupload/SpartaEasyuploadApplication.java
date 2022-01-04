package com.jkhan.sparta_easyupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jkhan.sparta_easyupload.dao")
public class SpartaEasyuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaEasyuploadApplication.class, args);
    }

}
