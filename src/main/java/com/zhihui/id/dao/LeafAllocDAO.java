package com.zhihui.id.dao;

import com.zhihui.id.entity.LeafAlloc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * leaf alloc dao
 *
 * @author LDZ
 * @date 2020-03-08 11:28
 */
@Mapper
public interface LeafAllocDAO {

    /**
     * 获取所有分配规则
     *
     * @return 所有分配规则
     */
    List<LeafAlloc> getAllLeafAllocList();

    /**
     * 根据业务标签获取分配规则
     *
     * @param tag 业务标签
     * @return 分配规则
     */
    LeafAlloc getLeafAlloc(@Param("tag") String tag);

    /**
     * 按步长更新 max id
     *
     * @param tag 业务标签
     * @return 更新个数
     */
    int updateMaxIdByTag(@Param("tag") String tag);

    /**
     * 按步长更新 max id
     *
     * @param leafAlloc 分配规则
     * @return 更新个数
     */
    int updateMaxIdByLeafAlloc(LeafAlloc leafAlloc);

    /**
     * 获取所有业务标签
     *
     * @return 业务标签
     */
    List<String> getAllTags();

}
