package com.sample.arrays;

import java.util.Arrays;

public class TopTwoNumbers {
	public static void main(String[] args) {
		int[] arr = { 20, 34, 21, 87, 92, Integer.MAX_VALUE };
		TopTwoNumbers t = new TopTwoNumbers();
		t.findTopTwo(arr);
		t.findTopTwo2(arr);
	}

	public void findTopTwo(int[] arr) {

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}
		}

		System.out.println("Arrays: " + Arrays.toString(arr));
		System.out.println("Max 1: " + max1 + " Max 2: " + max2);
	}

	public void findTopTwo2(int[] arr) {
		int max1 = -1;
		int max2 = -1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}
		}

		System.out.println("Arrays: " + Arrays.toString(arr));
		System.out.println("Max 1: " + max1 + " Max 2: " + max2);
	}
}
