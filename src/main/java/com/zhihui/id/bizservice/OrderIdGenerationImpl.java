package com.zhihui.id.bizservice;

import com.zhihui.id.bizservice.api.IOrderIdGeneration;
import com.zhihui.id.enums.Status;
import com.zhihui.id.model.Result;
import com.zhihui.id.service.api.IdGeneration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单生成
 *
 * @author LDZ
 * @date 2020-03-09 10:51
 */
@Service
@Slf4j
public class OrderIdGenerationImpl implements IOrderIdGeneration {


    private final static String ORDER_ID_PREFIX = "1";
    private final static String SUB_ORDER_ID_PREFIX = "2";

    @Resource
    IdGeneration idGeneration;

    @Override
    public Long generateOrderId(Long uid) {
        Result result = idGeneration.get("ORDER_ID");
        if (!result.getStatus().equals(Status.SUCCESS) || result.getId() <= 0L) {
            log.error("生成订单id服务异常 result = {}", result.toString());
            throw new RuntimeException("id生成服务异常");
        }
        // 母订单号规则：1开头+id+uid(后两位)
        String format = String.format("%02d", uid);
        String uidStr = format.substring(format.length() - 2);

        Long orderId = new Long(ORDER_ID_PREFIX + result.getId() + uidStr);
        log.info("生成orderId={}", orderId);
        return orderId;
    }

    @Override
    public Long generateSubOrderId(Long uid, Integer businessCode) {
        Result result = idGeneration.get("SUB_ORDER_ID");
        if (!result.getStatus().equals(Status.SUCCESS) || result.getId() <= 0L) {
            log.error("生成子订单id异常 result = {}", result.toString());
            throw new RuntimeException("id生成服务异常");
        }
        // 子订单号规则：2开头+id+业务id(两位)+uid(后两位)
        String format = String.format("%02d", uid);
        String uidStr = format.substring(format.length() - 2);
        return new Long(SUB_ORDER_ID_PREFIX + result.getId() + String.format("%02d", businessCode) + uidStr);
    }

}
