package com.dataGrid.model;

/*
 * @project Red-Hat-Data-Grid-Sample
 * @author Digvijay Singh
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter

@NoArgsConstructor
public class Employee implements Serializable {
    @ProtoField(1)
    String name;
    @ProtoField(2)
    String address;
    @ProtoField(3)
    UUID id;

    @ProtoFactory
    public Employee(String name, String address, UUID id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }
}
