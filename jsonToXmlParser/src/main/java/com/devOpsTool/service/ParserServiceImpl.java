package com.devOpsTool.service;

import com.devOpsTool.dao.ParserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Component
public class ParserServiceImpl implements ParserService {
    private Logger LOGGER= LoggerFactory.getLogger(ParserServiceImpl.class);
    @Autowired
    ParserDao parserDao;

    @Override
    public String getDataFromServer() {
        LOGGER.info("Entering.. ParserServiceImpl.getDataFromServer");
        String projectJsonData=parserDao.getDataFromServer();
        LOGGER.info("EXit.. ParserServiceImpl.getDataFromServer");
        return projectJsonData;
    }

    @Override
    public String getXmlData(String jsonObject) throws Exception{
        LOGGER.info("Entering.. ParserServiceImpl.getXmlData with Data : ${}",jsonObject);
        String projectXmlData=parserDao.getXmlData(jsonObject);
        LOGGER.info("EXit.. ParserServiceImpl.getXmlData");
        return projectXmlData;
    }

    @Override
    public void createXMLFile(String xmlData) throws Exception{
        LOGGER.info("Entering.. ParserServiceImpl.createXMLFile with Data : ${}",xmlData);
        parserDao.createXMLFile(xmlData);
        LOGGER.info("EXit.. ParserServiceImpl.createXMLFile");

    }

}
