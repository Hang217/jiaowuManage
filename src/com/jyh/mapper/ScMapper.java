package com.yu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yu.pojo.Sc;
import com.yu.pojo.ScKey;

public interface ScMapper {

    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(ScKey key);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
    
    int inserBatch(List<Sc> sclist);
 
}