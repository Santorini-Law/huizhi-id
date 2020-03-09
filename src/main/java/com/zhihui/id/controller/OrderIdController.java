package com.zhihui.id.controller;

import com.zhihui.id.bizservice.api.IOrderIdGeneration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LDZ
 * @date 2020-03-08 10:33
 */
@RestController
@RequestMapping(value = "/id/v1")
@Slf4j
public class OrderIdController {

    @Resource
    IOrderIdGeneration orderIdGeneration;

    @GetMapping("/order/{uid}")
    public Long orderIdGeneration(@PathVariable Long uid) {
        return orderIdGeneration.generateOrderId(uid);
    }

    @GetMapping("/suborder/{uid}/{businessCode}")
    public Long suborderIdGeneration(@PathVariable Long uid, @PathVariable Integer businessCode) {
        return orderIdGeneration.generateSubOrderId(uid, businessCode);
    }

}
