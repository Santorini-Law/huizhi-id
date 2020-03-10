package com.zhihui.id.remote.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.huizhi.rpc.RpcIdGenerationService;
import com.huizhi.rpc.model.IdGenerationRequestDTO;
import com.huizhi.rpc.model.IdGenerationResponseDTO;

/**
 * @author LDZ
 * @date 2020-03-10 19:06
 */
@Service
public class RpcIdGenerationImpl implements RpcIdGenerationService {
    @Override
    public IdGenerationResponseDTO generateUid(IdGenerationRequestDTO idGenerationRequestDTO) {
        IdGenerationResponseDTO idGenerationResponseDTO = new IdGenerationResponseDTO();
        idGenerationResponseDTO.setId(10L);
        return idGenerationResponseDTO;
    }
}
