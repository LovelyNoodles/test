package com.sqyc.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < 83; i++) {
			list.add(i);
		}
		System.out.println(list);

		
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (list.size() < 10) {
			result.add(list);
		}
		
		for (int l = 0; l < list.size(); l = l + 10) {
			int r = l + 10;
//			if (r > list.size()) {
//				r = list.size();
//			}
			result.add(list.subList(l, r));
		}
		
		
		for (List<Integer> list2 : result) {
			System.out.println(list2);
		}
	}
}
