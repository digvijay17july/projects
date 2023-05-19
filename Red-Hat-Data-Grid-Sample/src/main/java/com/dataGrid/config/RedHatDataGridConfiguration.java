package com.dataGrid.config;

/*
 * @project Red-Hat-Data-Grid-Sample
 * @author Digvijay Singh
 */

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RedHatDataGridConfiguration {

    @Value("${redhatdatagrid.host}")
    private String host;
    @Value("${redhatdatagrid.username}")
    private String username;
    @Value("${redhatdatagrid.password}")
    private String password;
    @Value("${redhatdatagrid.cachename}")
    private String cachename;


}
