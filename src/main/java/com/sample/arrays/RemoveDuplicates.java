package com.sample.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {

		RemoveDuplicates r = new RemoveDuplicates();
		int[] n = { 1, 1, 2, 2, 3, 4, 5 };
		r.removeDuplicates(n);
		r.removeDuplicates2(n);
	}

	public int[] removeDuplicates(int[] n) {
		Arrays.sort(n);

		for (int i = 1; i < n.length; i++) {

			if (n[i] == n[i - 1]) {
				n[i] = 0;
			}
		}
		System.out.println(Arrays.toString(n));
		return n;
	}

	public int[] removeDuplicates2(int[] n) {
		Arrays.sort(n);

		int[] result = new int[n.length];
		int previous = n[0];
		for (int i = 1; i < n.length; i++) {

			int val = n[i];
			if (previous != val) {
				result[i] = val;
			}
			previous = val;

		}
		System.out.println(Arrays.toString(result));
		return result;
	}
}
