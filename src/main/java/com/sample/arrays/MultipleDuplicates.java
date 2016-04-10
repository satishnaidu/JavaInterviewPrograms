package com.sample.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MultipleDuplicates {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 3, 3, 4, 5, 6, 6 };
		MultipleDuplicates m = new MultipleDuplicates();
		m.duplicateWithBruteForce(array);
		m.duplicateWithSort(array);
		m.duplicateWithSet(array);
		m.duplicateWithHashMap(array);
	}

	public void duplicateWithBruteForce(int[] n) {

		for (int i = 0; i < n.length; i++) {
			for (int j = i + 1; j < n.length; j++) {
				if (n[i] == n[j]) {
					System.out.println("Duplicate found: " + n[i]);
				}
			}
		}
	}

	public void duplicateWithSort(int[] n) {
		Arrays.sort(n);
		int lastDup = -1;
		for (int i = 1; i < n.length; i++) {
			if (n[i] == n[i - 1] && n[i] != lastDup) {
				lastDup = n[i];
				System.out.println("Duplicate with no repetation: " + n[i]);
			}
		}
	}

	public void duplicateWithSet(int[] n) {

		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < n.length; i++) {
			if (set.add(n[i]) == false) {
				System.out.println("Duplicate: " + n[i]);
			}
		}
	}

	public void duplicateWithHashMap(int[] n) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n.length; i++) {

			if (map.get(n[i]) != null) {
				map.put(n[i], map.get(n[i]) + 1);
			} else {
				map.put(n[i], 1);
			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
