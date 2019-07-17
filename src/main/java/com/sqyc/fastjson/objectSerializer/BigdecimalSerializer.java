package com.sqyc.fastjson.objectSerializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigdecimalSerializer implements ObjectSerializer {

    public static final String FORMAT_TWO_DECIMAL_PLACE_PATTERN = "###################0.##";
    public static final DecimalFormat FORMAT_TWO_DECIMAL_PLACE_FORMAT = new DecimalFormat(FORMAT_TWO_DECIMAL_PLACE_PATTERN);

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object != null && object instanceof BigDecimal) {
            String format = FORMAT_TWO_DECIMAL_PLACE_FORMAT.format(object);
            object = new BigDecimal(format);
        }
        serializer.write(object);
    }
}
