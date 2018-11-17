package com.sqyc.jodatime;

import java.time.LocalDate;
import java.util.Date;

import org.joda.time.DateTime;

public class JodaTimeTest {
	public static void main(String[] args) {
		DateTime dateTime = new DateTime();
		Date date = dateTime.toDate();
		
		LocalDate now = LocalDate.now();
	}
}
