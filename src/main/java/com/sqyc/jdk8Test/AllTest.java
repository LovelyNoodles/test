package com.sqyc.jdk8Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec;

public class AllTest {

	@Test
	public void FuncTest() {
		Function<String, Integer> func = t -> Integer.valueOf(t) + 1;
		String t = "2";
		Integer r = func.apply(t);
		t = "3";
		System.out.println(r);

		Function<String, String> func1 = Function.identity();
		String str = func1.apply("hello world...");
		System.out.println(str);
	}

	@Test
	public void doubleColon() {

		// 计算空字符串
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		System.out.println("使用 Java 8: ");
		System.out.println("列表: " + strings);

		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("空字符串数量为: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("字符串长度为 3 的数量为: " + count);

		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("筛选后的列表: " + filtered);

		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);

		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("列表: " + integers);
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		System.out.println("随机数: ");

		// 输出10个随机数
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}
		random.ints().limit(10).sorted().forEach(System.out::println);

		// 并行处理
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("空字符串的数量为: " + count);
	}

	@Test
	public void OptionalTest() {
		Optional<Object> option = Optional.empty();
		System.out.println(option.orElse("string"));
	}

	@Test
	public void FlatMapTest() {
		String[] arr = { "Hello", "world" };
		Stream<String> stream = Arrays.asList(arr).stream();

		Stream<String[]> map = stream.map(s -> s.split(""));
		Stream<String> flatMap = map.flatMap(subArr -> Arrays.stream(subArr));

	}

	@Test
	public void forEach() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		List<Object> list2 = new ArrayList<>();
		list.forEach((e) -> System.out.println(list2.add(e)));

		System.out.println(list2);
	}

	@Test
	public void createRandomString() {
		int limit = 10;

		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		while (builder.length() < limit) {
			int num = random.nextInt(limit);
			if (builder.length() == 0 && num == 0) {
				continue;
			}
			builder.append(num);
		}
		System.out.println(builder);
	}
}
