package com.sample.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

	public boolean binarySearch(final List<Integer> numbers, final Integer value) {

		if (numbers == null || numbers.isEmpty()) {
			return false;
		}

		int middle = numbers.size() / 2;
		final Integer comparison = numbers.get(middle);
		if (value.equals(comparison)) {
			return true;
		}
		if (value < comparison) {
			return binarySearch(numbers.subList(0, middle), value);
		} else {
			return binarySearch(numbers.subList(middle + 1, numbers.size()), value);
		}

	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(5);
		numbers.add(9);
		numbers.add(6);
		numbers.add(2);
		Collections.sort(numbers);

		boolean status = binarySearch.binarySearch(numbers, 7);
		System.out.println("status : " + status);

	}
}
