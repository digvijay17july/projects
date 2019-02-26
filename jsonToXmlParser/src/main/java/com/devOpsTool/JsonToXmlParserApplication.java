package com.devOpsTool;

import com.devOpsTool.service.ParserService;
import com.devOpsTool.service.ParserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@SpringBootApplication
public class JsonToXmlParserApplication {
	private Logger LOGGER= LoggerFactory.getLogger(JsonToXmlParserApplication.class);
	@Autowired
	ParserService parserService;

	public static void main(String[] args) {
		SpringApplication.run(JsonToXmlParserApplication.class, args);
	}

	@Scheduled(cron = "0/20 * * * * ?")
	public void performAction()
	{
		LOGGER.info("Entering.. JsonToXmlParserApplication.performAction");
		try {
			String projectData = parserService.getDataFromServer();
			String xmlProjectData=parserService.getXmlData(projectData);
			parserService.createXMLFile(xmlProjectData);
		}catch (Exception ex)
		{
			LOGGER.error("Exception .. JsonToXmlParserApplication.performAction ${} ", ex.getMessage());
		}
		LOGGER.info("Exit.. JsonToXmlParserApplication.performAction");
	}
}
