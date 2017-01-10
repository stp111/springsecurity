package com.dcloud.service;

import java.util.List;

import com.dcloud.model.*;

public interface MessageBoardService {


    public List<Message> listMessages();
    public void postMessage(Message message);
    public void deleteMessage(Message message);
    public Message findMessageById(Long messageId);
    
}
