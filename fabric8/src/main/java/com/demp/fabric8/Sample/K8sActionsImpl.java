package com.demp.fabric8.Sample;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

/*
 * @project fabric8
 * @author Digvijay Singh
 */
@Service
public class K8sActionsImpl implements K8sActions{
    @Override
    public NamespaceList getNamespaces(KubernetesClient kubernetesClient) {


        return kubernetesClient.namespaces().list();
    }
}
