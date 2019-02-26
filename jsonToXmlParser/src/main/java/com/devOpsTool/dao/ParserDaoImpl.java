package com.devOpsTool.dao;

import com.devOpsTool.config.ToolConfiguration;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParserDaoImpl implements ParserDao {
    private Logger LOGGER = LoggerFactory.getLogger(ParserDaoImpl.class);
    private RestTemplate restTemplate;
    private ToolConfiguration toolConfiguration;


    public ParserDaoImpl(RestTemplate restTemplate, ToolConfiguration toolConfiguration) {
        this.restTemplate = restTemplate;
        this.toolConfiguration = toolConfiguration;
    }

    @Override
    public String getDataFromServer() {
        LOGGER.info("Entering.. ParserDaoImpl.getDataFromServer");
        String body = "{\n" +
                "\"firstName\":\"mohita\",\n" +
                "\"password\":\"sfsfsf\",\n" +
                "\"lastName\":\"singh\",\n" +
                "\"mobileNo\":9650938605,\n" +
                "\"address\":\"krlgkelrg\",\n" +
                "\"grossSalary\":900000,\n" +
                "\"active\":true,\n" +
                "\"username\":\"digvijay17july\",\n" +
                "\"age\":55.0\n" +
                "}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> responseEntity = restTemplate.exchange(toolConfiguration.getServerProperties().get("url"), HttpMethod.POST, new HttpEntity<String>(body, httpHeaders), String.class);
        LOGGER.info("EXit.. ParserDaoImpl.getDataFromServer");
        return responseEntity.getBody();
    }

    @Override
    public String getXmlData(String jsonObject) throws Exception {
        String xmlData;
        LOGGER.info("Entering.. ParserDaoImpl.getXmlData with Data : ${}", jsonObject);
        try {
            JSONObject json = new JSONObject(jsonObject);
            xmlData = XML.toString(json);
            return xmlData;
        } catch (Exception ex) {
            LOGGER.error("Exception.. ParserDaoImpl.getXmlData with exception : ${} ", ex);
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void createXMLFile(String xmlData) {
        LOGGER.info("Entering.. ParserDaoImpl.createXMLFile with Data : ${}", xmlData);
        try {
            Document document = convertStringToXMLDocument(xmlData);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            String path = toolConfiguration.getServerProperties().get("xmlFilesPath") == null ? toolConfiguration.getServerProperties().get("xmlFilesPath") : System.getProperty("user.dir");
            StreamResult result = new StreamResult(new File(path + "/ScoreDetail.xml"));
            transformer.transform(source, result);
            LOGGER.info("EXit.. ParserDaoImpl.getXmlData");
        } catch (Exception ex) {
            LOGGER.error("Exception.. ParserDaoImpl.createXMLFile with exception : ${} ", ex);
        }
    }

    private Document convertStringToXMLDocument(String xmlString) throws Exception {
        LOGGER.info("Entering.. ParserDaoImpl.convertStringToXMLDocument with Data : ${}", xmlString);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <projects>" + xmlString + "</projects>")));
            LOGGER.info("EXit.. ParserDaoImpl.convertStringToXMLDocument");
            return doc;

        } catch (Exception e) {
            LOGGER.error("Exception.. ParserDaoImpl.convertStringToXMLDocument with exception : ${} ", e);

            throw new Exception(e.getMessage());
        }

    }

}
