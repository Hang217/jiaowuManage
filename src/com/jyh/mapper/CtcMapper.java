package com.yu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yu.pojo.CtcKey;

public interface CtcMapper {

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);
   
    void  insertBatch(List<CtcKey> ctclist);
}