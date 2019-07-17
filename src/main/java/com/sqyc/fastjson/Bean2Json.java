package com.sqyc.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

public class Bean2Json {
    @Test
    public void test1() {

        Person person = new Person();
        person.setName("yyp");
        person.setAge(18);
        person.setBirthday(new Date());

        String json = JSON.toJSONStringWithDateFormat(person, JSON.DEFFAULT_DATE_FORMAT);
//        String json = JSON.toJSONString(person);
        System.out.println(json);

        Person response = JSON.parseObject(json, Person.class);


    }


}
