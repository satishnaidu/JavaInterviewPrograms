package com.sample.fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTriplet {

	public static void main(String[] args) {

		FindTriplet findTriplet = new FindTriplet();
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int arr_size = A.length;
		int sum = 22;
		findTriplet.find3Numbers(A, arr_size, sum);
		findTriplet.find3NumbersUsingSort(A, arr_size, sum);
		findTriplet.find3NumbersUsingHash(A, arr_size, sum);

	}

	// O(n^3)
	public boolean find3Numbers(int A[], int arr_size, int sum) {

		// Fix the first element as A[1]
		for (int i = 0; i < arr_size - 2; i++) {

			// Fix the second element as A[j]
			for (int j = i + 1; j < arr_size - 1; j++) {

				for (int k = j + 1; k < arr_size; k++) {

					if (A[i] + A[j] + A[k] == sum) {
						System.out.println("Triplet found " + A[i] + " ," + A[j] + " ," + A[k]);
						return true;
					}
				}

			}

		}
		return false;
	}

	// O(n^2)
	public boolean find3NumbersUsingSort(int A[], int arr_size, int sum) {

		int l, r;
		Arrays.sort(A);
		for (int i = 0; i < arr_size - 2; i++) {
			l = i + 1;
			r = arr_size - 1;
			while (l < r) {
				if (A[i] + A[l] + A[r] == sum) {
					System.out.println("Triple found " + A[i] + " ," + A[l] + " , " + A[r]);
					return true;
				} else if (A[i] + A[l] + A[r] < sum) {
					l++;
				} else {
					r--;
				}

			}
		}
		return false;
	}

	// O(n^2)
	public boolean find3NumbersUsingHash(int A[], int arr_size, int sum) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr_size - 2; i++) {

			int curr_sum = sum - A[i];
			for (int j = i + 1; j < arr_size -1; j++) {

				curr_sum = curr_sum - A[j];
				if (map.get(curr_sum) != null) {
					System.out.println("Triple found " + A[i] + " ," +(sum - A[j]) + " , " + curr_sum);
					return true;
				}
				map.put(curr_sum, sum);
			}
		}

		return false;
	}

}
