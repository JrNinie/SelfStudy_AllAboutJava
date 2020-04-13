package com.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自定义字符转日期的类，需要实现Converter接口
public class StringToDate implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        if(source == null){
            throw new RuntimeException("请输入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
    }
}
