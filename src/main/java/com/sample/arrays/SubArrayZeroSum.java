package com.sample.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayZeroSum {
	public static void main(String[] args) {
		SubArrayZeroSum s = new SubArrayZeroSum();
		int arr[] = { 4, 2, -3, 1, 6 };
		System.out.println(s.printZeroSumSubarray(arr));

	}

	public Boolean printZeroSumSubarray(int[] arr) {
		// Creates an empty hashMap hM
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];
			System.out.println(sum);
			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || map.get(sum) != null)
				return true;

			// Add sum to hash map
			map.put(sum, i);
			System.out.println(map);
		}

		// We reach here only when there is no subarray with 0 sum
		return false;
	}
}
