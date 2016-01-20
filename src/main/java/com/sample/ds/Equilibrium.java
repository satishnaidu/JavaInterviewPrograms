package com.sample.ds;

import java.util.ArrayList;
import java.util.List;

public class Equilibrium {

	public static void main(String[] args) throws Exception {

		Equilibrium equilibrium = new Equilibrium();
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		List<Integer> result = equilibrium.getIndex(a);
		for (Integer i : result) {
			System.out.print(i+ " ");
		}
	}

	public List<Integer> getIndex(int a[]) throws Exception {

		List<Integer> list = new ArrayList<Integer>();
		long leftSum = 0;
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		for (int i = 0; i < a.length; i++) {

			sum = sum - a[i];
			if (leftSum == sum) {
				list.add(i);
			}
			leftSum += a[i];
		}
		return list;
	}

}
