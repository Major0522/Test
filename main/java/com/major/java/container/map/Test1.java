package com.major.java.container.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test1 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}

		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, Integer> next = entries.next();
		}
	}
}