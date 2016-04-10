package com.sample.arrays;

import java.util.Arrays;

public class LargestAndSmallest {
	public static void main(String[] args) {
		largestAndSmallest2(new int[] { -20, 34, 21, -87, 92, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 10, Integer.MIN_VALUE, -2 });
		largestAndSmallest(new int[] { Integer.MAX_VALUE, 40, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 1, -1, 0 });

	}

	public static void largestAndSmallest(int[] array) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;

		for (int i : array) {
			if (i > largest) {
				largest = i;
			}
			if (i < smallest) {
				smallest = i;
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("largest " + largest + " smallest " + smallest);

	}

	public static void largestAndSmallest2(int[] array) {

		int previous = array[0];
		int max = previous;
		int min = previous;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("max " + max + " min " + min);
	}

}
