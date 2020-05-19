package com.yu.mapper;

import java.util.List;

import com.yu.pojo.Gonggao;
import com.yu.pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);
  

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User userlogin(User user);

	List<Gonggao>  selectGonggao();

	void insertGonggao(Gonggao gonggao);
    
}