package com.huizhi.rpc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LDZ
 * @date 2020-03-10 18:36
 */
@Data
public class IdGenerationRequestDTO implements Serializable {

    /**
     * 手机号
     */
    private String mobile;

}
