package com.dcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello() {
		logger.info("hello.....");
		return "hello";
	}
}
