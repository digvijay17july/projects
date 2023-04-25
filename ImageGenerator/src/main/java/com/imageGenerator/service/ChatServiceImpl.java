package com.imageGenerator.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.imageGenerator.model.ChatGptRequest;
import com.imageGenerator.model.ChatMessage;
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
 * @project ImageGenerator
 * @author Digvijay Singh
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Value("${chatGPT.token}")
    String token;
    @Value("${chatGPT.url}")
    String endpoint;

    @Value("${chatGPT.defaultImageSize}")
    String defaultImageSize;

    @Value("${chatGPT.defaultGeneratedImagesCount}")
    int defaultGeneratedImagesCount;

    String chatModel="gpt-3.5-turbo";
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public ChatMessage sendMessage(ChatMessage message) throws IOException {
        String response= callChatGptForResponse(message);
        HashMap<String,Object> map=objectMapper.readValue(response, HashMap.class);
        List<Map<String,Object>> responseMap= (List<Map<String, Object>>) map.get("data");
        return  new ChatMessage(objectMapper.writeValueAsString(responseMap),"ChatGPT");
    }

    private String callChatGptForResponse(ChatMessage message) throws IOException{
        URL url = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer "+token);

        ChatGptRequest chatGptRequest=new ChatGptRequest(message.getContent(),defaultImageSize,defaultGeneratedImagesCount);



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
