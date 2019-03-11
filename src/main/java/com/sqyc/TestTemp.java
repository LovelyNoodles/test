package com.sqyc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestTemp {

	@Test
	public void test1() {
		String str = "abc";
		System.out.println(str.contains("a"));
		System.out.println(str.contains("b"));
		System.out.println(str.contains("c"));
		System.out.println(str.contains("d"));
		
		System.out.println(str.indexOf("a"));
		System.out.println(str.indexOf("b"));
		System.out.println(str.indexOf("c"));
		System.out.println(str.indexOf("d"));
	}
	
	@Test
	public void test2() {
		LocalDate date = LocalDate.parse("2020-02-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate now = LocalDate.now();
		long between = ChronoUnit.YEARS.between(date, now);
		System.out.println(between);

		System.out.println(date.isBefore(now));
		System.out.println(date.isAfter(now));
	}
	
	@Test
	public void test3() {
		String str = "A1、A2、A3、B1、B2、C1、C2、N、P";
		System.out.println(str.contains("A1") && !"A1".contains("、"));
		System.out.println(str.contains("A2、") && !"A2、".contains("、"));
		System.out.println(str.contains("、A2、") && !"、A2、".contains("、"));
	}
	
	@Test
	public void test4() {
		Map<String, Object> param = new HashMap<>();

		Map<String, Object> textParam = new HashMap<>();
		Map<String, Object> atParam = new HashMap<>();

		param.put("msgtype", "text");
		param.put("text", textParam);
		param.put("at", atParam);

		textParam.put("content", "test");

		List<String> mobiles = new ArrayList<>();
		atParam.put("isAtAll", true);
//		if (mobiles.isEmpty()) {
//			atParam.put("atMobiles", mobiles);
//		}

		mobiles.add("15211112222");
		mobiles.add("15211113333");

		System.out.println(JSON.toJSONString(param));
		System.out.println(JSON.toJSONString(param));
		System.out.println(JSON.toJSONString(param));
	}
	
	@Test
	public void test5() {
		String[] DRIVING_LICENSE_TYPES = { "A1", "A2", "A3", "B1", "B2", "C1", "C2", "N", "P" };
		System.out.println(StringUtils.join(DRIVING_LICENSE_TYPES, "|"));
	}

}
