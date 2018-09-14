package com.sample.fb;

public class EquilibriumIndex {

	public static void main(String[] args) {
		EquilibriumIndex index = new EquilibriumIndex();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		int n = arr.length;
		int r = index.equlibrium(arr, n);
		System.out.println(index.equilibrium2(arr, n));
		System.out.println("Equilibrium index " + r);
	}

	// O(n^2)
	public int equlibrium(int arr[], int n) {

		int i, j;
		int leftSum, rightSum;
		for (i = 0; i < n; ++i) {
			// get left sum
			leftSum = 0;
			for (j = 0; j < i; j++) {
				leftSum += arr[j];
			}

			rightSum = 0;
			// get right sum
			for (j = j + 1; j < n; j++) {
				rightSum += arr[j];
			}

			if (leftSum == rightSum) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public int equilibrium2(int arr[], int n) {
		int sum = 0;
		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		for (int j = 0; j < arr.length; j++) {

			sum = sum - arr[j];
			if (leftSum == sum) {
				return j;
			}
			leftSum += arr[j];

		}

		return -1;
	}
}
