package com.dcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcloud.model.Message;
import com.dcloud.service.MessageBoardService;

import org.springframework.ui.Model;

import java.util.List; 


@Controller
@RequestMapping("/messageList*")
public class MessageController {

//	@Autowired
    private MessageBoardService messageBoardService;

    // Wire service in constructor, available in application context 
    @Autowired
    public MessageController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }
    

    // Controller will always look for a default GET method to call first, irrespective of name
    // In this case, named setupForm to ease identification
    @RequestMapping(method = RequestMethod.GET)
	public String generateList(Model model) {
	// Create an empty messages list 
	List<Message> messages = java.util.Collections.emptyList();
	messages = messageBoardService.listMessages();
	// Update model to include reservations
	model.addAttribute("messages", messages);
        return "messageList";
    }
}