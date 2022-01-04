package com.jkhan.sparta_easyupload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description helloController
 * @Author hjk
 * @Date 2021/12/31 9:46
 **/
@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String hellWorld() {
        log.info("****** call hello api ******");
        return "hello world";
    }
}
