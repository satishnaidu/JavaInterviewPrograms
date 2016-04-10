package com.sample.arrays;

import java.util.Arrays;

public class Intersection {
	public static void main(String[] args) {
		int[] n1 = { 1, 2, 3, 4, 5 };
		int[] n2 = { 0, 1, 4, 5, 6 };
		Intersection i = new Intersection();
		i.intersection(n1, n2);
		i.withBinarySearch(n1, n2);
	}

	public void intersection(int[] n1, int[] n2) {

		int i = 0;
		int j = 0;
		while (i < n1.length && j < n2.length) {
			if (n1[i] == n2[j]) {

				System.out.println("Union element: " + n1[i]);
				i++;
				j++;

			} else if (n1[i] < n2[j]) {
				// System.out.println(n1[i]);
				i++;
			} else if (n1[i] > n2[j]) {
				// System.out.println(n2[j]);
				j++;
			}
		}

	}

	public void withBinarySearch(int[] n1, int[] n2) {

		int[] unique = new int[n1.length];
		int[] notunique = new int[n2.length];
		for (int i = 0; i < n1.length; i++) {
			int pos = Arrays.binarySearch(n2, n1[i]);
			System.out.println(pos);
			if (pos < 0) {
				unique[i] = n1[i];
			} else {
				notunique[i] = n1[i];
			}
		}
		System.out.println(Arrays.toString(unique));
		System.out.println(Arrays.toString(notunique));
	}
}
