package com.sqyc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class TxtTest {

	@Test
	public void test1() throws FileNotFoundException, IOException {
		File file = new File("C:\\Users\\corwu\\Desktop\\phones.txt");

		long start = System.currentTimeMillis();
		try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));) {
			for (int i = 0; i < 50000000; i++) {
				outputStream.write(getTel().getBytes());
				System.out.println("第" + i + "条");
			}
		}
		System.out.println("生成完毕");
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - start) + " ms");

	}

	public int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}

	/**
	 * 返回手机号码
	 */
	private static final String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");

	private String getTel() {
		int index = getNum(0, telFirst.length - 1);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + third + "\n";
	}

	@Test
	public void test2() {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("F:\\phones.txt")).parallel();) {

			System.out.println(lines.isParallel());
			
			Stream<String> parallel = lines.parallel();
			System.out.println(parallel.isParallel());

			long start = System.currentTimeMillis();
//			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();
			lines.forEach(System.out::println);
			long end = System.currentTimeMillis();
			System.out.println("用时：" + (end - start) + " ms");
		} catch (IOException e) {
			System.out.println("异常");
		}
		System.out.println(uniqueWords);
	}
	
	@Test
	public void test3() throws IOException {
		long uniqueWords = 0;
		List<String> lines = Files.readAllLines(Paths.get("F:\\phones.txt"));
			
		long start = System.currentTimeMillis();
//		uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();
		lines.forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - start) + " ms");
		System.out.println(uniqueWords);
	}

}
