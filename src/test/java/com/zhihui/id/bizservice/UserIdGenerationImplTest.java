package com.zhihui.id.bizservice;

import com.zhihui.id.bizservice.api.IUserIdGeneration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIdGenerationImplTest {

    @Resource
    IUserIdGeneration userIdGeneration;

    @Test
    void generateUserId() {
        Long aLong = userIdGeneration.generateUserId("18629670402");
        System.out.println(aLong);
    }
}