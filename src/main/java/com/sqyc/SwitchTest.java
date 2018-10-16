package com.sqyc;

public class SwitchTest {
	public static void main(String[] args) {
		// switch1(5);
		// switch2(5);
		switch3(2);
	}

	private static void switch1(int i) {
		switch (i) {
		case 0:
			System.out.println("0");
			break;
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		default:
			System.out.println("default");
			break;
		}
	}

	private static void switch2(int i) {
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		}
	}

	private static void switch3(int i) {
		switch (i) {
		case 0:
			yyp(i);
			break;
		case 1:
		case 2: {
			int a = 10;
			int b = a + i;
			System.out.println(b);
		}
			break;
		default:
			System.out.println("default");
			break;
		}
	}

	private static void yyp(int i) {
		System.out.println(i);
	}

}
