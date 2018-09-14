package com.sample.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstRepeatedChar {
	public static void main(String[] args) {
		int[] n = { 1, 1, 2, 3, 4, 4, 5, 6 };
		FirstRepeatedChar f = new FirstRepeatedChar();
		f.withLinkedHashMap(n);
		f.withLikedHashSet(n);
	}

	public int withLinkedHashMap(int[] n) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < n.length; i++) {
			if (map.containsKey(n[i])) {
				map.put(n[i], map.get(n[i]) + 1);
			} else {
				map.put(n[i], 1);
			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry);
				return entry.getKey();
			}
		}
		throw new RuntimeException("Didn't find any repeating char ");
	}

	public int withLikedHashSet(int[] n) {
		Set<Integer> repeat = new HashSet<Integer>();
		List<Integer> norepeat = new ArrayList<Integer>();

		for (int i = 0; i < n.length; i++) {

			int val = n[i];
			if (repeat.contains(val)) {
				continue;
			}
			if (norepeat.contains(val)) {
				norepeat.remove(norepeat.size() - 1);
				repeat.add(val);
			} else {
				norepeat.add(val);
			}
		}
		System.out.println(norepeat.get(0));
		return norepeat.get(0);
	}
}
