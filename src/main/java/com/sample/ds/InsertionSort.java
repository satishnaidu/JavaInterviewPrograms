package com.sample.ds;

public class InsertionSort {

	public static void main(String[] args) {
		int[] sort = insertionSort();
		for (int i : sort) {
			System.out.print(i);
		}
	}

	public static int[] insertionSort() {
		int[] n = { 5, 2, 4, 6, 1, 3 };
		for (int j = 1; j < n.length; j++) {
			int key = n[j];
			int i = j - 1;
			while (i > -1 && n[i] > key) {
				n[i + 1] = n[i];
				i = i - 1;
			}
			n[i + 1] = key;

		}

		return n;
	}
}
