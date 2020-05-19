package com.yu.service;

import java.util.List;

import com.yu.pojo.Gonggao;
import com.yu.pojo.User;

public interface UserService {
	User userlogin(User user);

	User getUserDetail(Integer id);

	List<Gonggao> getGonggao();

	void insert(Gonggao gonggao);

	int delete(int id);
}
