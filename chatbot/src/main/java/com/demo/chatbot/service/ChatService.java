package com.demo.chatbot.service;

import com.demo.chatbot.model.ChatMessage;

import java.io.IOException;

/*
 * @project chatbot
 * @author Digvijay Singh
 */
public interface ChatService {

    ChatMessage sendMessage(ChatMessage message) throws IOException;
}
