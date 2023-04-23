package com.demo.chatbot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @project chatbot
 * @author Digvijay Singh
 */
public class ChatGptRequest {
    String model;

    List<Map<String,String>> messages;

    public ChatGptRequest() {
        this.messages=new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Map<String, String>> getMessages() {
        return messages;
    }

    public void setMessages(String role,String messages) {
        HashMap<String,String> message=new HashMap<>();
        message.put("role",role);
        message.put("content",messages);
        this.messages.add(message);
    }
}
