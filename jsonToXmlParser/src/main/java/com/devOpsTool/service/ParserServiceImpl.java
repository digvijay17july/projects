package com.devOpsTool.service;

import com.devOpsTool.dao.ParserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParserServiceImpl implements ParserService {
    @Autowired
    ParserDao parserDao;

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
