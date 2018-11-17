package com.sqyc.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class SerializerFeatureTest {

	private static SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.QuoteFieldNames,
			SerializerFeature.SortField, SerializerFeature.DisableCircularReferenceDetect };

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

	@Test
	public void bean2json() {

		List<Person> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Person person = new Person();
			person.age = 18 + i;
			person.email = "abc@qq.com";

			list.add(person);
		}

		String json = JSON.toJSONString(list);
		System.out.println(json);
	}

}
