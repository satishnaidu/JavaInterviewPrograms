package com.sample.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllPairsSumEqualsNum {
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
		printPairs(numbers, 7);
		printPairsUsingSet(numbers, 7);
		printPairsWithTwoPointers(numbers, 7);
	}

	public static void printPairs(int[] array, int sum) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i + j == sum) {
					System.out.printf("(%d, %d) %n", i, j);
				}
			}
		}
	}

	public static void printPairsUsingSet(int[] numbers, int sum) {
		if (numbers.length < 2) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>(numbers.length);

		for (int value : numbers) {
			int target = sum - value;
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}

	public static void printPairsWithTwoPointers(int[] numbers, int k) {

		System.out.println("Print pairs using two pointers");
		Arrays.sort(numbers);
		if (numbers.length < 2) {
			return;
		}
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}

	}
}
