package com.sqyc.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializerFeatureTest {

    @Test
    public void json2bean() {
        JSONArray jsonArr = JSON.parseArray(
                "[{\"age\":18,\"email\":\"abc@qq.com\"},{\"age\":19,\"email\":\"abc@qq.com\"},{\"age\":20,\"email\":\"abc@qq.com\"}]\r\n"
                        + "");
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject bean = jsonArr.getJSONObject(i);
            Person person = JSON.toJavaObject(bean, Person.class);
            list.add(person);
        }
        System.out.println(JSON.toJSONString(list));
    }

}
