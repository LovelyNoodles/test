package com.sqyc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestTemp {

	@Test
	public void test1() {
		System.out.println(LocalDate.parse("6-04-03", DateTimeFormatter.ofPattern("y-M-d")));
		System.out.println(LocalDate.parse("2016-4-3", DateTimeFormatter.ofPattern("y-M-d")));

		System.out.println(LocalDate.parse("2016-04-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(LocalDate.parse("2016-4-3", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

}
