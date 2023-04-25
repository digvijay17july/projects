package com.imageGenerator.service;



import com.imageGenerator.model.ChatMessage;

import java.io.IOException;

/*
 * @project ImageGenerator
 * @author Digvijay Singh
 */
public interface ChatService {

    ChatMessage sendMessage(ChatMessage message) throws IOException;
}
