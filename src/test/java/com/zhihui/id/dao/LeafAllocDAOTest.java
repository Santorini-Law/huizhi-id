package com.zhihui.id.dao;

import com.zhihui.id.entity.LeafAlloc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeafAllocDAOTest {

    @Resource
    LeafAllocDAO dao;

    @Test
    public void get() {
        List<LeafAlloc> allLeafAllocs = dao.getAllLeafAllocs();
        System.out.println(allLeafAllocs.toString());
    }
}