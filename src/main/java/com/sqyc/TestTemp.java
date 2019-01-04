package com.sqyc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestTemp {

	@Test
	public void test1() {
		List<Object> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println(JSON.toJSONString(list));
	}

}
