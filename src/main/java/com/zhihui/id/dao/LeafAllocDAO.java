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
     * @return
     */
    List<LeafAlloc> getAllLeafAllocs();

    /**
     *
     * @param tag
     * @return
     */
    LeafAlloc getLeafAlloc(@Param("tag") String tag);

    /**
     *
     * @param tag
     * @return
     */
    int updateMaxIdAndGetLeafAlloc(@Param("tag") String tag);

    /**
     *
     * @param leafAlloc
     * @return
     */
    int updateMaxIdByCustomStepAndGetLeafAlloc(LeafAlloc leafAlloc);

    /**
     *
     * @return
     */
    List<String> getAllTags();

}
