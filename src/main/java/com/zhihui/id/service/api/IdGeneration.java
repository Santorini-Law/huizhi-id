package com.zhihui.id.service.api;

import com.zhihui.id.model.Result;

/**
 * 发号器
 *
 * @author LDZ
 * @date 2020-03-08 15:43
 */
public interface IdGeneration {

    /**
     * 业务标签
     *
     * @param tag 业务标签
     * @return 发号器结果
     */
    Result get(final String tag);
}
