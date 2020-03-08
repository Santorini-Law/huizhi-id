package com.zhihui.id.controller;

import com.zhihui.id.service.api.IdGeneration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IdController {

    @Resource
    IdGeneration idGeneration;

    @GetMapping("/{uid}/{businessId}")
    public Long getMemberCardList(@PathVariable Long uid, @PathVariable Integer businessId) {
        return idGeneration.get("ORDER_ID").getId();
    }
}
