package com.sample.arrays;

/*
 * Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
 */
public class SmallestInSubsetSum {

	public static void main(String[] args) {
		SmallestInSubsetSum s = new SmallestInSubsetSum();
		int[] arr = { 1, 1, 4, 6, 10, 11, 15 };
		s.findSmallest(arr, arr.length);

	}

	// Returns the smallest number that cannot be represented as sum
	// of subset of elements from set represented by sorted array arr[0..n-1]
	public int findSmallest(int arr[], int n) {
		int res = 1; // Initialize result

		// Traverse the array and increment 'res' if arr[i] is
		// smaller than or equal to 'res'.
		for (int i = 0; i < n && arr[i] <= res; i++)
			res = res + arr[i];

		return res;
	}
}
