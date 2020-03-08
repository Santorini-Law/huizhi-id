package com.zhihui.id.dao;

import com.zhihui.id.entity.LeafAlloc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
@Slf4j
class LeafAllocDAOTest {

    @Resource
    LeafAllocDAO dao;

    @Resource
    @Qualifier("update")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void get() {

        threadPoolTaskExecutor.execute(() -> {
            List<LeafAlloc> allLeafAllocs = dao.getAllLeafAllocList();
            log.info(allLeafAllocs.toString());
        });

    }
}