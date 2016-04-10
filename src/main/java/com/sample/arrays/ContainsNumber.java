package com.sample.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContainsNumber {
	public static void main(String[] args) {
		Integer[] input = new Integer[] { 1, 2, 3, 4, 5 };
		int val = binarySearch(Arrays.asList(input), 3);
		System.out.println(val);
	}

	public <T> boolean isExists(T[] array, T v) {
		return Arrays.asList(array).contains(v);
	}

	public static <T> boolean contains(T[] array, T v) {
		for (T e : array) {
			if (e == v || e.equals(v)) {
				return true;
			}
		}
		return false;
	}

	public static int binarySearch(List<Integer> list, int v) {

		Collections.sort(list);
		int middleIndex = list.size() / 2;
		Integer middle = list.get(middleIndex);

		if (middle.equals(v)) {
			return middle;
		} else if (middle < v) {
			return binarySearch(list.subList(0, middle), v);
		} else if (middle > v) {
			return binarySearch(list.subList(middle + 1, list.size()), v);
		}
		return -1;
	}
}
