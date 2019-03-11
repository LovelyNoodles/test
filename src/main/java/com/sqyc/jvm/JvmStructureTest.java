package com.sqyc.jvm;

import org.junit.Test;

public class JvmStructureTest {

	public static void main(String[] args) {
		for (String s : args) {
			System.out.print(s);
		}
		System.out.println();
		System.out.println("-Xmx:" + Runtime.getRuntime().maxMemory());
	}

	public static int count;

	@Test
	public void 测试Java栈深度() {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of calling = " + count);
			e.printStackTrace();
		}
	}

	private void recursion() {
		count++;
//		if (count == 5) {
//			return;
//		}
		recursion();
	}

}
