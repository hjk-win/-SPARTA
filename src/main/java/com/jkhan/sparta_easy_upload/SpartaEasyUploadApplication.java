package com.jkhan.sparta_easy_upload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jkhan.sparta_easy_upload.dao")
public class SpartaEasyUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaEasyUploadApplication.class, args);
    }

}
