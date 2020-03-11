package com.huizhi.rpc;

import com.huizhi.rpc.model.IdGenerationRequestDTO;
import com.huizhi.rpc.model.IdGenerationResponseDTO;

/**
 * @author LDZ
 * @date 2020-03-10 18:36
 */
public interface RpcIdGenerationService {

    /**
     * 生成uid
     *
     * @param idGenerationRequestDTO uid 生成请求
     * @return uid
     */
    IdGenerationResponseDTO generateUid(IdGenerationRequestDTO idGenerationRequestDTO);
}
