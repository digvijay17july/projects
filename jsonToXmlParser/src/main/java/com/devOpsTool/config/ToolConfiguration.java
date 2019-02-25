package com.devOpsTool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties
public class ToolConfiguration {

private Map<String, String> serverProperties;

    public Map<String, String> getServerProperties() {
        return serverProperties;
    }

    public void setServerProperties(Map<String, String> serverProperties) {
        this.serverProperties = serverProperties;
    }
}
