package com.sqyc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestTemp {
	@Test
	public void test1() {
		List list = getList();
		ArrayList<String> arrayList = (ArrayList<String>) list;
		System.out.println(arrayList);
		System.out.println(arrayList == null);
	}


	private List getList() {
		return null;
	}


	@Test
	public void test2() {
		LocalDateTime now = LocalDateTime.now();
		String string = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(now);
		System.out.println(string);
	}
	
	@Test
	public void test3() {
		LocalDate now = LocalDate.now();
		LocalDate birthday = LocalDate.parse("1995年06月04日", DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
//		long between = ChronoUnit.YEARS.between(now, birthday);
//		System.out.println(between);
		System.out.println(birthday.toString());
	}
	
	@Test
	public void test4() {
		String[] DRIVING_LICENSE_TYPES = { "A1", "A2", "A3", "B1", "B2", "C1", "C2", "N", "P" };
//		String[] strings = Arrays.copyOf(DRIVING_LICENSE_TYPES, DRIVING_LICENSE_TYPES.length);
		
		boolean isMatch = Arrays.stream(DRIVING_LICENSE_TYPES).allMatch(type -> type.equals("C1"));
		System.out.println(isMatch);
	}
	
	@Test
	public void test5() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = pattern.format(LocalDateTime.now());
		System.out.println(format);
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		String format2 = pattern.format(localDateTime);
		System.out.println(format2);
	}
	
	@Test
	public void test6() {
		String str = "";
		System.out.println(str.lastIndexOf("."));
		System.out.println(str.substring(str.lastIndexOf(".") + 1));

	}
	
	@Test
	public void test7() {
		int i = 1;
		System.out.println(i+++1);
		i = 1;
		System.out.println(i+++1 + "");
		i = 1;
		System.out.println(++i+1);
		i = 1;
		System.out.println(++i+1 + "");
	}
	
	
	@Test
	public void test8() {
		Set<String> set = new HashSet<>();
		String str = "";
		System.out.println(set.add(str));
		System.out.println(set.add(str));
	}
}
