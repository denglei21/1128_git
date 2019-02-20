package com.atguigu.maven.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.maven.dao.UserMapper;
import com.atguigu.maven.model.User;
import com.atguigu.maven.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 创建了");
	}

	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
