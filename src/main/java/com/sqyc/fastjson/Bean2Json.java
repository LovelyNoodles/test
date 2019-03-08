package com.sqyc.fastjson;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class Bean2Json {
	@Test
	public void test1() {
		A a = new A();
		a.setName("yyp");
		a.setAge(12);
		a.setBirthday(new Date());

		String str1 = JSON.toJSONString(a);
		// String str2 = JSON.toJSONStringWithDateFormat(a, JSON.DEFFAULT_DATE_FORMAT,
		// new SerializerFeature[0]);

		System.out.println(str1);
		// System.out.println(str2);
	}

	@Test
	public void test2() {
		A a = new A();
		a.setName("adf");
		a.setBirthday(new Date());

		String jsonString = JSON.toJSONStringWithDateFormat(a, JSON.DEFFAULT_DATE_FORMAT);
		System.out.println(jsonString);
		JSONObject json = (JSONObject) JSONObject.parse(jsonString);
		Map<String, Object> paramMap = json.getInnerMap();
		paramMap.put("abc", 123);
		System.out.println(paramMap);
		
		String string = JSON.toJSONString(paramMap);
		System.out.println(string);
		String msg = JSON.toJSONString(string);
		System.out.println(msg);
		
//		String jsonString1 = JSON.toJSONStringWithDateFormat(a, "yyyy-MM-dd");
//		JSONObject json1 = (JSONObject) JSONObject.parse(jsonString1);
//		Map<String, Object> paramMap1 = json1.getInnerMap();
//		System.out.println(paramMap1);

	}

	@Test
	public void test3() {
		String jsonString = "{\r\n" + "    \"msg\": \"上传成功\",\r\n" + "    \"code\": \"1\",\r\n" + "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "            \"path\": \"https://test-www-api-img.01zhuanche.com/public/cb/cc/f404f52466bc599c6fb168c1f9f8/28589.pdf\",\r\n"
				+ "            \"filedName\": \"pdf\",\r\n" + "            \"fileId\": \"28589\"\r\n" + "        }\r\n"
				+ "    ]\r\n" + "}";

		JSONObject parse = (JSONObject) JSONObject.parse(jsonString);
	}

	/**
	 * @ClassName: A
	 * @Description: TODO
	 * @author: yanyunpeng
	 * @date: 2018年12月17日 下午4:02:01
	 * 
	 */
	static class A {
		private String name;
		private Integer age;
		private Date birthday;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		@Override
		public String toString() {
			return "A [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
		}

	}
}
