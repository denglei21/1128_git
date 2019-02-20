package com.atguigu.maven.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.maven.model.User;
import com.atguigu.maven.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(HttpServletRequest request,Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId="+userId);
		User user = null;
		if(userId==1) {
			user= new User();
			user.setAge(11);
			user.setId(1);
			user.setPassword("123");
			user.setUserName("SSMTest");
		}
		logger.debug(user.toString());
		model.addAttribute("user", user);
		return "test";
	}
	
	
	@RequestMapping(value="/showUser1",method=RequestMethod.GET)
	public String showUser1(HttpServletRequest request,Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:"+userId);
		User user = userService.getUserById(userId);
		logger.debug(user.toString());
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping(value="/showUser2",method=RequestMethod.GET)
	public String showUser2(@RequestParam("id") String id,Model model) {
		int userId = Integer.parseInt(id);
		System.out.println(userId);
		User user = userService.getUserById(userId);
		logger.debug(user.toString());
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping(value="/showUser3/{id}",method=RequestMethod.GET)
	public String showUser3(@PathVariable("id")String id,Map<String,Object>model) {
		int userId = Integer.parseInt(id);
		System.out.println(userId);
		User user = userService.getUserById(userId);
		logger.debug(user.toString());
		model.put("user", user);
		return "showUser";
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody User getUserInJson(@PathVariable("id")String id,Map<String,Object>model) {
		int userId = Integer.parseInt(id);
		System.out.println(userId);
		User user = userService.getUserById(userId);
		return user;
	}
	
	@RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> getUserInJson2(@PathVariable("id")String id,Map<String,Object>model){
		int userId = Integer.parseInt(id);
		System.out.println(userId);
		User user = userService.getUserById(userId);
		logger.debug(user.toString());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//文件上传
	@RequestMapping(value="/upload")
	public String showUploadPage() {
		return "upload/file";
	}
	
	

}
