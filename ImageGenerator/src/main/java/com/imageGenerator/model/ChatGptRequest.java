package com.imageGenerator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @project ImageGenerator
 * @author Digvijay Singh
 */
public class ChatGptRequest {
    String prompt;

    String size;

    int n;

    public ChatGptRequest(String prompt, String size, int n) {
        this.prompt = prompt;
        this.size = size;
        this.n = n;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
