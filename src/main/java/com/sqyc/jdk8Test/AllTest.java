package com.sqyc.jdk8Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

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
		System.out.println(flatMap);
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

	@Test
	public void count() {
		Integer[] intArr = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		List<Integer> list = Arrays.asList(intArr);

		List<Integer> collect2 = list.stream().sorted(Comparator.comparingInt(Integer::intValue))
				.collect(Collectors.toList());
		// System.out.println(collect2);

		Map<Integer, List<Integer>> group = list.stream().collect(Collectors.groupingBy(a -> a));
		// System.out.println(group);

		Map<Integer, List<Integer>> frequently = group.entrySet().stream().filter(e -> e.getValue().size() > 4)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		// System.out.println(frequently);

		if (frequently.size() > 3) {
			System.out.println(frequently);
		} else {
			Map<Integer, Integer> finalMap = new LinkedHashMap<>();
			Comparator<Entry<Integer, List<Integer>>> comparator = Comparator.comparingInt(e -> e.getValue().size());
			group.entrySet().stream().sorted(comparator.reversed()).limit(20)
					.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue().get(0)));
			System.out.println(finalMap);
		}

	}

	@Test
	public void count2() {
		Map<Integer, Integer> result = new HashMap<>();
		result.put(2, 1);
		result.put(3, 3);
		result.put(5, 6);
		result.put(7, 4);
		result.put(3, 3);
		result.put(4, 8);
		result.put(6, 6);
		result.put(8, 4);

		Map<Integer, Integer> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		Comparator<Entry<Integer, Integer>> comparator = Comparator.comparingInt(e -> e.getKey());
		result.entrySet().stream().sorted(comparator.reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		// Map<Integer, Integer> collect =
		// result.entrySet().stream().sorted(comparator.reversed()).collect(Collectors.toMap(e
		// -> e.getKey(), e -> e.getValue()));

		System.out.println(finalMap);
		// System.out.println(collect);

	}

	@Test
	public void dateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.plusMonths(2));
		System.out.println(now.minusMonths(1));
	}

	@Test
	public void filter() {
		List<String> list = new ArrayList<>();
		list.add("asldfk");
		list.add("asdf");
		list.add("avsdf");
		list.add("sdfgsdd");
		list.add("wyrjr");
		list.add("dftgr");
		list.add("jgfhjfg");
		list.add("hjkl");
		list.add(null);

		List<String> list2 = list.stream().filter(str -> str != null && str.contains("sd"))
				.collect(Collectors.toList());
		System.out.println(list2);

	}

	@Test
	public void create() {
		String zipFilePath = "C:\\Users\\corwu\\Desktop\\test\\dd.zip";// 生成压缩文件的存放路径及名称
		List<String> fileList = new ArrayList<String>();// 要压缩的文件集合
		fileList.add("C:\\Users\\corwu\\Desktop\\test\\1.txt");
		fileList.add("C:\\Users\\corwu\\Desktop\\test\\2.txt");
		File file = new File(zipFilePath);
		if (file.exists()) {
			file.delete();
		}
		try {
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			ZipOutputStream zos = new ZipOutputStream(fos);
			ArrayList<File> files = new ArrayList<File>();
			for (String fileName : fileList) {
				files.add(new File(fileName));
			}
			for (int i = 0; i < files.size(); i++) {
				FileInputStream fis = new FileInputStream(files.get(i));
				zos.putNextEntry(new ZipEntry(files.get(i).getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Test
	public void write() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		File file = new File("C:\\Users\\corwu\\Desktop\\test\\1.txt");
		if (file.exists()) {
			file.delete();
		}
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
			for (String str : list) {
				bos.write((str + "\r\n").getBytes());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// bos.write("final".getBytes());
			file.delete();
		}
	}

	@Test
	public void iotest() {
    }


}
