package com.atguigu.maven.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.atguigu.maven.model.User;
import com.atguigu.maven.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class TestMybatis {
	 @Resource
	 private UserService userService;
	 @Test
	 public void test1() {
		User user = userService.getUserById(1);
		System.out.println(JSON.toJSON(user));
	 }

}
