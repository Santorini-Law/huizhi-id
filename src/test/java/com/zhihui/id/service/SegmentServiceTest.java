package com.zhihui.id.service;

import com.zhihui.id.model.Result;
import com.zhihui.id.service.api.IdGeneration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SegmentServiceTest {

    @Autowired
    IdGeneration idGeneration;

    @Test
    public void ser() {
        Result order_id = idGeneration.get("ORDER_ID");
        System.out.println(order_id.getId());
    }
}