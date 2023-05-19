package com.dataGrid.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.infinispan.commons.dataconversion.MediaType;
import org.infinispan.commons.io.ByteBuffer;
import org.infinispan.commons.marshall.BufferSizePredictor;
import org.infinispan.commons.marshall.Marshaller;

import java.io.IOException;

/*
 * @project Red-Hat-Data-Grid-Sample
 * @author Digvijay Singh
 */
public class EmployeeMarshaller implements Marshaller {
    @Override
    public byte[] objectToByteBuffer(Object obj, int estimatedSize) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] data = objectMapper.writeValueAsBytes(obj);
        return data;
    }

    @Override
    public byte[] objectToByteBuffer(Object obj) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] data = objectMapper.writeValueAsBytes(obj);
        return data;
    }

    @Override
    public Object objectFromByteBuffer(byte[] buf) throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = objectMapper.readValue(buf, Object.class);
        return obj;
    }

    @Override
    public Object objectFromByteBuffer(byte[] buf, int offset, int length) throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = objectMapper.readValue(buf, Object.class);
        return obj;
    }

    @Override
    public ByteBuffer objectToBuffer(Object o) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ByteBuffer byteBuffer = objectMapper.convertValue(o, ByteBuffer.class);

        return byteBuffer;
    }

    @Override
    public boolean isMarshallable(Object o) throws Exception {
        if (o != null)
            return true;
        else return false;
    }

    @Override
    public BufferSizePredictor getBufferSizePredictor(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        BufferSizePredictor byteBufferSizePredictor = objectMapper.convertValue(o, BufferSizePredictor.class);

        return byteBufferSizePredictor;
    }

    @Override
    public MediaType mediaType() {
        return MediaType.APPLICATION_PROTOSTREAM;
    }
}
