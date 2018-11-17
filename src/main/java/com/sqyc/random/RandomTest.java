package com.sqyc.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RandomTest {

	@Test
	public void test1() {
		Random random = new Random();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10;) {
			int number = random.nextInt(1000) + 1;

			// 判断number是否在集合中存在
			if (!list.contains(number)) {
				// 不在集合中，就添加
				list.add(number);
				i++;
			}
		}
		
		System.out.println(list);
	}

}
