package com.sqyc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class TestTemp {

	@Test
	public void test1() {
		System.out.println(LocalDate.parse("6-04-03", DateTimeFormatter.ofPattern("y-M-d")));
		System.out.println(LocalDate.parse("2016-4-3", DateTimeFormatter.ofPattern("y-M-d")));

		System.out.println(LocalDate.parse("2016-04-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(LocalDate.parse("2016-4-3", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

	@Test
	public void test() {

		A a = new A();
		a.setName("adf");
		a.setBirthday(new Date());

		String jsonString = JSON.toJSONStringWithDateFormat(a, JSON.DEFFAULT_DATE_FORMAT);
		JSONObject json = (JSONObject) JSONObject.parse(jsonString);
		Map<String, Object> paramMap = json.getInnerMap();
		System.out.println(paramMap);
		String jsonString1 = JSON.toJSONStringWithDateFormat(a, "yyyy-MM-dd");
		JSONObject json1 = (JSONObject) JSONObject.parse(jsonString1);
		Map<String, Object> paramMap1 = json1.getInnerMap();
		System.out.println(paramMap1);
	}

	static class A {
		private String name;

		private Integer age;

		private Date birthday;

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

	}

	@Test
	public void test3() {
		A a1 = new A();
		a1.setName("yyp");
		a1.setAge(1);
		a1.setBirthday(new Date());
		A a2 = new A();
		a2.setName("yyp");
		a2.setAge(2);
		a2.setBirthday(new Date());
		A a3 = new A();
		a3.setName("abc");
		a3.setAge(3);
		a3.setBirthday(new Date());
		A a4 = new A();
		a4.setName("asd");
		a4.setAge(4);
		a4.setBirthday(new Date());

		List<Object> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);

	}

}
