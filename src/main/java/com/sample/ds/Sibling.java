package com.sample.ds;

public class Sibling {

	public static void main(String[] args) {
		Sibling s = new Sibling();
		int N = 57549;
		int result = s.solution(N);
		System.out.println(result);
	}

	public int solution(int N) {
		int num = N;
		int[] digitPlace = new int[10];
		while (num != 0) {
			int val = num % 10;
			digitPlace[val]++;
			num /= 10;
		}

		int fianlNumber = 0;
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < digitPlace[i]; j++) {
				fianlNumber = fianlNumber * 10 + i;
			}
		}
		return fianlNumber;
	}
}
