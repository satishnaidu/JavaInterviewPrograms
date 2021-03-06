package com.sample.ds;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = new int[] { 33, 6, 21, 12, 19, 29, 38, 22, 14, 40 };
		for (int i : a) {
			System.out.print(i + ", ");
		}
		System.out.println();
		quick_sort(a);
		System.out.println();
		for (int i : a) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	// Below partition is using Hoare's algorithm
	public static int partition(int[] arr, int low, int high) {
		int pivotValue = arr[0];
		int i = low;
		int j = high;

		while (i < j) {
			while (i <= high && arr[i] <= pivotValue) {
				i++;
			}
			while (arr[j] > pivotValue) {
				j--;
			}
			if (i < j) {
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

			arr[low] = arr[j];
			arr[j] = pivotValue;

		}

		return j;
	}

	public static void quickSortRec(int[] arr, int low, int high) {

		if (high > low) {
			int pivotIndex = partition(arr, low, high);
			quickSortRec(arr, low, pivotIndex - 1);
			quickSortRec(arr, pivotIndex + 1, high);
		}
	}

	public static void quick_sort(int[] arr) {
		quickSortRec(arr, 0, arr.length - 1);
	}
}
