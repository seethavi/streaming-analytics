package com.paras;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


public class LightningEventDeserializationSchema implements DeserializationSchema<LightningEvent> {

    @Override
    public TypeInformation<LightningEvent> getProducedType() {
        return TypeInformation.of(LightningEvent.class);
    }

    @Override
    public LightningEvent deserialize(byte[] value) throws IOException {
        //deserialise the kafka event into the LightningEvent object
        String strValue = new String(value, "UTF-8"); // convert the byte array to string
        LightningEvent event = deserializeFromJson(strValue);
        return event;
    }

    @Override
    public boolean isEndOfStream(LightningEvent event) {
        return false;
    }

    private LightningEvent deserializeFromJson(String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, LightningEvent.class);
 
    }
}
