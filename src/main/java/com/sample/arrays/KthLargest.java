package com.sample.arrays;

public class KthLargest {
	public static void main(String[] args) {
		KthLargest klargest = new KthLargest();
		int[] arr = { 1, 2, 3, 9, 4 };
		int k = 2;
		System.out.println(klargest.findKthLargest(arr, k));

	}

	public int findKthLargest(int[] arr, int k) {
		if (k < 1 && arr == null) {
			return 0;
		}
		return kthLargest(arr, k, 0, arr.length - 1);
	}

	public int kthLargest(int[] arr, int k, int start, int end) {
		int pivot = arr[end];

		int left = start;
		int right = end;

		while (true) {

			while (arr[left] < pivot && left < right) {
				left++;
			}

			while (arr[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(arr, left, right);
		}

		swap(arr, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return kthLargest(arr, k, start, left - 1);
		} else {
			return kthLargest(arr, k, left + 1, end);
		}
	}

	public void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
