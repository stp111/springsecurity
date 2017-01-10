package com.dcloud.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcloud.model.User;
import com.dcloud.service.UserDBService;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger("UserController");
	
	@Resource
	private UserDBService userDBService;
	
	@RequestMapping(value="/users")
	public String listUser(Model model) {
		logger.info("list users");
		model.addAttribute("num", 5);
		return "userList";
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public String getUser(@PathVariable("id") int id, Model model) {
		logger.info("get user {}",id);
		
		User user = new User();
		user.setUserId(String.valueOf(id));
		user.setUserName("userName"+id);
		user.setEmail("email"+id);
		
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String updateUser(User user) {
		logger.info("update user {}",user);
		return "updateUserSuccess";
	}
	
	
	@RequestMapping(value="getuser/{id}")
	@ResponseBody
	public String findUser(@PathVariable("id") int id) {
		logger.info("find user by id {}",id);
		User user =userDBService.getUser(id);
		return user.toString();
	}
}
