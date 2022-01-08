package com.jkhan.sparta_easyupload.controller;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import com.jkhan.sparta_easyupload.exception.BusinessException;
import com.jkhan.sparta_easyupload.service.CollectorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CollectorControllerTest
 * @Description CollectorControllerTest
 * @Author hjk
 * @Date 2022/1/7 23:02
 **/
@SpringBootTest
@Slf4j
public class CollectorControllerTest {
    @Autowired
    private CollectorService collectorService;

    @Test
    void testAddCollectors() {
        List<CollectorInfo> collectors = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            CollectorInfo collector = new CollectorInfo(i, "hhh", "test", "test");
            collectors.add(collector);
        }
        try {
            collectorService.insertCollectorList(collectors);
        } catch (BusinessException e) {
            log.error("insert list error: {}", e.getMessage());
        }
    }
}
