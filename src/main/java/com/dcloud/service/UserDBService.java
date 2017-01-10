package com.dcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcloud.dao.UserDAO;
import com.dcloud.model.User;

public class UserDBService {

	//
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDAO userDao;
	
	
	public UserDAO getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDAO userDao) {
		logger.info("set user-dao for user-db-service.");
		this.userDao = userDao;
	}


	public User getUser(int id) {
		logger.info("---- get user with id {}",id);
		return userDao.findById(id);
	}
}
