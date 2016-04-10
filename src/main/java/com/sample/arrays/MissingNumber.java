package com.sample.arrays;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumber {
	public static void main(String[] args) {
		// one missing number
		missingNumberWithBitSet(new int[] { 1, 2, 3, 4, 6 }, 6);

		// two missing number
		missingNumberWithBitSet(new int[] { 1, 2, 3, 4, 6, 7, 9, 8, 10 }, 10);

		// three missing number
		missingNumberWithBitSet(new int[] { 1, 2, 3, 4, 6, 9, 8 }, 10);

		// four missing number
		missingNumberWithBitSet(new int[] { 1, 2, 3, 4, 9, 8 }, 10);

		// Only one missing number in array
		int[] iArray = new int[] { 1, 2, 3, 5 };
		int missing = missingNumberAgainstTotalSum(iArray, 5);
		System.out.printf("Missing number in array %s is %d %n", Arrays.toString(iArray), missing);

	}

	public static void missingNumberWithBitSet(int[] numbers, int count) {

		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);

		for (int n : numbers) {
			bitSet.set(n - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers),
				count);

		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {

			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			lastMissingIndex++;
			System.out.println(lastMissingIndex);
		}

	}

	public static int missingNumberAgainstTotalSum(int[] numbers, int count) {
		int expectedSum = count * ((count + 1) / 2);
		int actualSum = 0;
		for (int n : numbers) {
			actualSum += n;
		}
		return expectedSum - actualSum;
	}
}
