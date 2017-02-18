package com.wrigglegriggle.infrastructure.web;

import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.map.deser.StdKeyDeserializer;
import org.codehaus.jackson.map.ser.SerializerBase;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class UrlEncodedStringDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonToken curr = jsonParser.getCurrentToken();
        String value = null;
        // Usually should just get string value:
        if (curr == JsonToken.VALUE_STRING) {
            value = jsonParser.getText();
        }

        if(value != null) return URLDecoder.decode(value);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}


