package com.sample.ds;

import java.util.HashMap;
import java.util.Map;

public class CachedFibN {

	private Map<Integer, Integer> fibCache = new HashMap<Integer, Integer>();

	public int cacheFibN(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}

		fibCache.put(0, 0);
		fibCache.put(1, 1);
		return recursiveCacheFibN(n);
	}

	public int recursiveCacheFibN(int n) {
		if (fibCache.containsKey(n)) {
			return fibCache.get(n);
		}
		int value = recursiveCacheFibN(n - 1) + recursiveCacheFibN(n - 2);
		fibCache.put(n, value);
		return value;
	}

	public static void main(String[] args) {
		CachedFibN cachedFibN = new CachedFibN();
		int res = cachedFibN.cacheFibN(10);
		System.out.println("res : " + res);
	}
}
