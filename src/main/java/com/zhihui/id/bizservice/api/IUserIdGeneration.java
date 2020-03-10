package com.zhihui.id.bizservice.api;

/**
 * user id
 *
 * @author LDZ
 * @date 2020-03-10 21:13
 */
public interface IUserIdGeneration {

    /**
     * 生成 user id
     *
     * @param mobile 电话号码
     * @return uid
     */
    Long generateUserId(String mobile);
}
