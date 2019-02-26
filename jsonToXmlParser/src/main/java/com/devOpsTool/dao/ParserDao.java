package com.devOpsTool.dao;

public interface ParserDao {
    String getDataFromServer();
    String getXmlData(String jsonObject) throws Exception;
    void createXMLFile (String xmlData) throws Exception;
}
