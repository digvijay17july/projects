package com.devOpsTool.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParserDaoImpl implements ParserDao {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getDataFromServer() {
        return null;
    }

    @Override
    public String getXmlData(String jsonObject) {
        return null;
    }

    @Override
    public void createXMLFile(String xmlData) {

    }
}
