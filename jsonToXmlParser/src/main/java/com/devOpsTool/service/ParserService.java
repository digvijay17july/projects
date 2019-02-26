package com.devOpsTool.service;
public interface ParserService {

    String getDataFromServer();
    String getXmlData(String jsonObject)throws Exception;
    void createXMLFile(String xmlData)throws Exception;
}
