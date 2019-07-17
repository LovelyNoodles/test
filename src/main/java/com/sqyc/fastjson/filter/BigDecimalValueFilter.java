package com.sqyc.fastjson.filter;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalValueFilter implements ValueFilter {
    public Object process(Object object, String name, Object value) {
        if (null != value && value instanceof BigDecimal) {
            DecimalFormat format = new DecimalFormat("###################0.##");
            return format.format(value);
        }
        return value;
    }
}
