package com.carl.breakfast.dao.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author Carl
 * @date 2017/2/9
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class CustomDoubleSerialize extends JsonSerializer<Float> {

    private DecimalFormat df = new DecimalFormat("##.00");

    @Override
    public void serialize(Float value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {

        jgen.writeString(df.format(value));
    }
}
