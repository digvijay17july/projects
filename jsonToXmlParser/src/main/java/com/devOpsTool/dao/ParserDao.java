package com.devOpsTool.dao;

public interface ParserDao {
    String getDataFromServer();
    String getXmlData(String jsonObject);
    void createXMLFile(String xmlData);
}
