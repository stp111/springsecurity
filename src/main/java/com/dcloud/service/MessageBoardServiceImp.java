package com.dcloud.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.dcloud.model.Message;

public class MessageBoardServiceImp implements MessageBoardService {


    private Map<Long, Message> messages = new LinkedHashMap<Long, Message>();
    

    public List<Message> listMessages() {
        return new ArrayList<Message>(messages.values());
    }

    @Transactional
//    @Secured("ROLE_USER")
    public synchronized void postMessage(Message message) {
        message.setId(System.currentTimeMillis());
        messages.put(message.getId(), message);
       
    }

    @Transactional
    //@Secured({"ROLE_ADMIN", "IP_LOCAL_HOST"})
//    @Secured("ACL_MESSAGE_DELETE")
    public synchronized void deleteMessage(Message message) {
        messages.remove(message.getId());
	
    }

    public Message findMessageById(Long messageId) {
        return messages.get(messageId);
    }
    
}
