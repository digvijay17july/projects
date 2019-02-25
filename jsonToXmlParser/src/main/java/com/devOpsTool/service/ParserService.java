package com.devOpsTool.service;
public interface ParserService {

    String getDataFromServer();
    String getXmlData(String jsonObject);
    void createXMLFile(String xmlData);
}
