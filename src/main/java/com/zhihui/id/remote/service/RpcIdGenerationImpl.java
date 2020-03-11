package com.zhihui.id.remote.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.huizhi.rpc.RpcIdGenerationService;
import com.huizhi.rpc.model.IdGenerationRequestDTO;
import com.huizhi.rpc.model.IdGenerationResponseDTO;
import com.zhihui.id.bizservice.api.IUserIdGeneration;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author LDZ
 * @date 2020-03-10 19:06
 */
@Service
@Slf4j
public class RpcIdGenerationImpl implements RpcIdGenerationService {

    @Resource
    IUserIdGeneration userIdGeneration;

    @Override
    public IdGenerationResponseDTO generateUid(IdGenerationRequestDTO idGenerationRequestDTO) {
        log.info("id generation request param = {}", idGenerationRequestDTO.toString());
        String mobile = Optional.of(idGenerationRequestDTO).map(IdGenerationRequestDTO::getMobile).orElseThrow(() -> new RuntimeException("请求参数错误！"));
        Long userId = userIdGeneration.generateUserId(mobile);
        IdGenerationResponseDTO idGenerationResponseDTO = new IdGenerationResponseDTO();
        idGenerationResponseDTO.setId(userId);
        log.info("id generation response = {}", idGenerationResponseDTO.toString());
        return idGenerationResponseDTO;
    }
}
