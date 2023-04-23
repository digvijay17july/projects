package com.demo.chatbot.service;

import com.demo.chatbot.model.ChatGptRequest;
import com.demo.chatbot.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @project chatbot
 * @author Digvijay Singh
 */
@Service
public class ChatServiceImpl implements  ChatService{

    @Value("${chatGPT.token}")
    String token;
    @Value("${chatGPT.url}")
    String endpoint;

    String chatModel="gpt-3.5-turbo";
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public ChatMessage sendMessage(ChatMessage message) throws IOException {
        String response= callChatGptForResponse(message);
        HashMap<String,Object> map=objectMapper.readValue(response, HashMap.class);
        List<Map<String,Object>> choices= (List<Map<String, Object>>) map.get("choices");
        String messages=((HashMap<String,String>)choices.get(0).get("message")).get("content");
        String role=((HashMap<String,String>)choices.get(0).get("message")).get("role");
        return  new ChatMessage(messages,role);
    }

    private String callChatGptForResponse(ChatMessage message) throws IOException{
        URL url = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer "+token);

        ChatGptRequest chatGptRequest=new ChatGptRequest();
        chatGptRequest.setModel(chatModel);
        chatGptRequest.setMessages("user",message.getContent());


        String postData=objectMapper.writeValueAsString(chatGptRequest);
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(postData);
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response += inputLine;
        }
        in.close();
        return response;
    }
}
