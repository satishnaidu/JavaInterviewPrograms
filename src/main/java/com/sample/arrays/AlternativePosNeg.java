package com.sample.arrays;

import java.util.Arrays;

public class AlternativePosNeg {

	public static void main(String[] args) {
		AlternativePosNeg a = new AlternativePosNeg();
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		System.out.println("Acutal Array: " + Arrays.toString(arr));
		a.rearrange(arr, arr.length);
		int arr2[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		System.out.println("Acutal Array 2: " + Arrays.toString(arr2));
		a.rearrange2(arr2, arr2.length);
	}

	public void rearrange(int[] arr, int n) {

		// process of QuickSort. The idea is to consider 0
		// as pivot and divide the array around it.
		int i = -1, temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Now all positive numbers are at end and negative numbers at
		// the beginning of array. Initialize indexes for starting point
		// of positive and negative numbers to be swapped
		int pos = i + 1, neg = 0;

		// Increment the negative index by 2 and positive index by 1, i.e.,
		// swap every alternate negative number with next positive number
		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}

		System.out.println("Rearranged array: " + Arrays.toString(arr));
	}

	public void rearrange2(int arr[], int n) {
		int outofplace = -1;

		for (int index = 0; index < n; index++) {
			if (outofplace >= 0) {
				// find the item which must be moved into the out-of-place
				// entry if out-of-place entry is positive and current
				// entry is negative OR if out-of-place entry is negative
				// and current entry is negative then right rotate
				//
				// [...-3, -4, -5, 6...] --> [...6, -3, -4, -5...]
				// ^ ^
				// | |
				// outofplace --> outofplace
				//
				if (((arr[index] >= 0) && (arr[outofplace] < 0)) || ((arr[index] < 0) && (arr[outofplace] >= 0))) {
					rightrotate(arr, n, outofplace, index);

					// the new out-of-place entry is now 2 steps ahead
					if (index - outofplace > 2)
						outofplace = outofplace + 2;
					else
						outofplace = -1;
				}
			}

			// if no entry has been flagged out-of-place
			if (outofplace == -1) {
				// check if current entry is out-of-place
				if (((arr[index] >= 0) && (!((index & 0x01) == 0))) || ((arr[index] < 0) && (index & 0x01) == 0)) {
					outofplace = index;
				}
			}
		}
		System.out.println("Rearranged array: 2 " + Arrays.toString(arr));
	}

	// Utility function to right rotate all elements between [outofplace, cur]
	void rightrotate(int arr[], int n, int outofplace, int cur) {
		char tmp = (char) arr[cur];
		for (int i = cur; i > outofplace; i--)
			arr[i] = arr[i - 1];
		arr[outofplace] = tmp;
	}
}
