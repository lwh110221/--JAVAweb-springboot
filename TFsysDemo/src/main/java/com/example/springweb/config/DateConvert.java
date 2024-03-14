package com.example.springweb.config;

import com.alibaba.druid.util.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date target=null;
        if(!StringUtils.isEmpty(source)){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                target =  format.parse(source);
            } catch (ParseException e) {
                throw new RuntimeException(String.format("parser %s to Date fail", source));
            }
        }
        return target;
    }
}
