package com.demo.chatbot.controller;

/*
 * @project chatbot
 * @author Digvijay Singh
 */

import com.demo.chatbot.model.ChatMessage;
import com.demo.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage handleMessage(ChatMessage message) throws IOException {
        ChatMessage response=chatService.sendMessage(message);
    return response;
    }

}
