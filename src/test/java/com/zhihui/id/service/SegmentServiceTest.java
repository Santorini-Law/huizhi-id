package com.zhihui.id.service;

import com.zhihui.id.model.Result;
import com.zhihui.id.service.api.IDGen;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SegmentServiceTest {

    @Autowired
    IDGen idGen;

    @Test
    public void ser() {
        Result order_id = idGen.get("ORDER_ID");
        System.out.println(order_id.getId());
    }
}