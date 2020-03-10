package com.huizhi.rpc;

import com.huizhi.rpc.model.IdGenerationRequestDTO;
import com.huizhi.rpc.model.IdGenerationResponseDTO;

/**
 * @author LDZ
 * @date 2020-03-10 18:36
 */
public interface RpcIdGenerationService {

    IdGenerationResponseDTO generateUid(IdGenerationRequestDTO idGenerationRequestDTO);
}
