package com.sample.ds;

public class MergeSort {

	private int[] numbers;

	private int length;
	private int[] helper;

	public static void main(String[] args) {
		int[] numbers = { 11, 2, 0, 18, 13, 8, 9, 3, 11, 9 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(numbers);
		for (int i : numbers) {
			System.out.print(i);
			System.out.print(" ");
		}

	}

	public void sort(int inputArr[]) {
		this.numbers = inputArr;
		this.length = inputArr.length;
		this.helper = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			helper[i] = numbers[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

}
