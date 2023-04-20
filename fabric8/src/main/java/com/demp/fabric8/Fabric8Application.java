package com.demp.fabric8;

import com.demp.fabric8.Sample.K8sActions;
import com.demp.fabric8.Sample.K8sActionsImpl;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Fabric8Application {



    public static void main(String[] args) {
        final ConfigBuilder configBuilder = new ConfigBuilder();
        KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build();
        K8sActions k8sActions= new K8sActionsImpl();
        NamespaceList namespaceList= k8sActions.getNamespaces(client);
        System.out.println(namespaceList);


    }


}
