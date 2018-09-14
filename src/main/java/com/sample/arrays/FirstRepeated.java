package com.sample.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstRepeated {
	public static void main(String[] args) {
		FirstRepeated f = new FirstRepeated();
		int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
		System.out.println(f.firstRepeated(arr));
		System.out.println(f.repeatedWithSorting(arr));
	}

	// Time complexity: O(n)
	public int firstRepeated(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();

		int min = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (set.contains(arr[i])) {
				min = arr[i];
			} else {
				set.add(arr[i]);
			}
		}

		return min;
	}

	// Time Complexity: O(n2)
	public int repeatedWithTwoloops(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return arr[i];
				}
			}
		}

		return -1;
	}

	// Time complexity: O(nlogn)
	public int repeatedWithSorting(int[] arr) {
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		Arrays.sort(temp);

		// This user defined class will count the number of occurrences each
		// item in array
		CountOccurences c = new CountOccurences();
		for (int i = 0; i < arr.length - 1; i++) {
			int count = c.count(temp, arr[i], temp.length);
			if (count > 1) {
				return arr[i];
			}
		}
		return -1;
	}
}
