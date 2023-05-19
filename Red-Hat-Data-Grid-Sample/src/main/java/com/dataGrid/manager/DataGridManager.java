package com.dataGrid.manager;

import com.dataGrid.config.RedHatDataGridConfiguration;
import com.dataGrid.model.Employee;
import com.dataGrid.model.EmployeeMarshaller;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*
 * @project Red-Hat-Data-Grid-Sample
 * @author Digvijay Singh
 */
@Service
public class DataGridManager {

    private RemoteCache<String, Employee> employeeCache;

    RedHatDataGridConfiguration redHatDataGridConfiguration;

    public DataGridManager(RedHatDataGridConfiguration redHatDataGridConfiguration) {
        this.redHatDataGridConfiguration=redHatDataGridConfiguration;
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host(redHatDataGridConfiguration.getHost())
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT)
                .security().authentication()
                .username(redHatDataGridConfiguration.getUsername())
                .password(redHatDataGridConfiguration.getPassword())
                .realm("default")
                .saslMechanism("SCRAM-SHA-512");

        builder.marshaller(new EmployeeMarshaller()).
                addJavaSerialAllowList("com.dataGrid.model.", "com.dataGrid.model.Employee");

        RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
        employeeCache = cacheManager.getCache(redHatDataGridConfiguration.getCachename());

        //insert Dummy employees on start to test
        dummyEmployees();
    }

    public RemoteCache<String, Employee> getEmployeeCache() {
        return employeeCache;
    }

    public void dummyEmployees() {


        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            UUID randomUUId = UUID.randomUUID();
            employee.setName("Employee : " + i);
            employee.setAddress("Employee Address: " + 1);
            employee.setId(randomUUId);
            employeeCache.put(randomUUId.toString(), employee);
        }

    }
}
