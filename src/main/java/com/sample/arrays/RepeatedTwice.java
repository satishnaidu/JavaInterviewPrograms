package com.sample.arrays;

public class RepeatedTwice {

	public static void main(String[] args) {
		int[] n = { 1, 1, 2, 2, 3, 3, 9, 4, 4, 5, 5 };
		RepeatedTwice r = new RepeatedTwice();
		r.repeatedTwice(n, n.length);
		r.withModule(n, n.length);
		r.withSimpleXOR(n, n.length);
	}

	public int withSimpleXOR(int[] arr, int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = result ^ arr[i];
		}
		System.out.println(result);
		return result;
	}

	// Not working
	public int withModule(int[] arr, int n) {

		// Initialize result
		int INT_SIZE = 32;
		int result = 0;

		int x, sum;

		// Iterate through every bit
		for (int i = 0; i < INT_SIZE; i++) {
			// Find sum of set bits at ith position in all
			// array elements
			sum = 0;
			x = (1 << i);
			for (int j = 0; j < n; j++) {
				if ((arr[j] & x) == 0) {
					sum++;
				}
			}

			// The bits with sum not multiple of 3, are the
			// bits of element with single occurrence.
			if (sum % 3 == 0) {
				result |= x;
			}
		}
		System.out.println("result: " + result);
		return result;
	}

	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public int repeatedTwice(int[] arr, int n) {
		int ones = 0, twos = 0;

		int common_bit_mask;

		// Let us take the example of {3, 3, 2, 3} to understand this
		for (int i = 0; i < n; i++) {
			/*
			 * The expression "one & arr[i]" gives the bits that are there in
			 * both 'ones' and new element from arr[]. We add these bits to
			 * 'twos' using bitwise OR
			 * 
			 * Value of 'twos' will be set as 0, 3, 3 and 1 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			twos = twos | (ones & arr[i]);

			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 * 
			 * Value of 'ones' will be set as 3, 0, 2 and 3 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones = ones ^ arr[i];

			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 * 
			 * Value of 'common_bit_mask' will be set as 00, 00, 01 and 10 after
			 * 1st, 2nd, 3rd and 4th iterations respectively
			 */
			common_bit_mask = ~(ones & twos);

			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 * 
			 * Value of 'ones' will be set as 3, 0, 0 and 2 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones &= common_bit_mask;

			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 * 
			 * Value of 'twos' will be set as 0, 3, 1 and 0 after 1st, 2nd, 3rd
			 * and 4th itearations respectively
			 */
			twos &= common_bit_mask;

			// uncomment this code to see intermediate values
			// printf (" %d %d \n", ones, twos);
		}

		System.out.println(ones);

		return ones;

	}

}
