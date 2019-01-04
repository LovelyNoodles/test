package com.sqyc.fastjson;

import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
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
		@JSONField(format = "yyyy-MM-dd")
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
