package com.sqyc.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class SerializerFeatureTest {

	private static SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.QuoteFieldNames,
			SerializerFeature.SortField, SerializerFeature.DisableCircularReferenceDetect };

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("a", "yyp");
		map.put("b", "");
		map.put("c", null);
		map.put("d", "123");
		map.put("e", null);
		map.put("f", null);

		System.out.println(new String(JSON.toJSONBytes(map, features)));
	}
}
