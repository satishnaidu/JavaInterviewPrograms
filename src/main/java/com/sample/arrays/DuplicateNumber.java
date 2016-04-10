package com.sample.arrays;

import java.util.Arrays;

public class DuplicateNumber {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 3, 4, 5,6, 6 };
		removeDuplicates(array, 8);
	}

	public static int[] removeDuplicates(int[] array, int count) {

		Arrays.sort(array);
		int[] result = new int[count];
		int previous = array[0];

		result[0] = previous;
		int finalCount = 0;
		for (int i = 1; i < array.length; i++) {
			if (previous != array[i]) {
				result[i] = array[i];
				previous = array[i];
			} else {
				finalCount++;
			}
		}
		System.out.println(Arrays.toString(result));
		System.out.println("duplicate count "+finalCount);

		return result;
	}

	

}
