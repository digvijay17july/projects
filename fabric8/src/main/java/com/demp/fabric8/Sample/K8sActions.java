package com.demp.fabric8.Sample;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.KubernetesClient;

/*
 * @project fabric8
 * @author Digvijay Singh
 */
public interface K8sActions {

    NamespaceList getNamespaces(KubernetesClient kubernetesClient);
}
