package com.zhihui.id.bizservice.api;

/**
 * order id
 *
 * @author LDZ
 * @date 2020-03-09 10:46
 */
public interface IOrderIdGeneration {

    /**
     * 生成 order id
     *
     * @param uid uid
     * @return 订单id
     */
    Long generateOrderId(Long uid);

    /**
     * 生成子订单 id
     *
     * @param uid          uid
     * @param businessCode 业务码
     * @return 子订单id
     */
    Long generateSubOrderId(Long uid, Integer businessCode);
}
