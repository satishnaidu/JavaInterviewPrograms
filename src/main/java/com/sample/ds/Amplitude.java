package com.sample.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amplitude {

	public static void main(String[] args) {
		Amplitude a = new Amplitude();
		int[] A = new int[6];

		A[0] = 6;
		A[1] = 10;
		A[2] = 6;
		A[3] = 9;
		A[4] = 7;
		A[5] = 8;

		int size = a.solution(A);
		System.out.println(size);
	}

	public int solution(int[] A) {

		List<Integer> inputList = new ArrayList<Integer>();
		for (int i : A) {
			inputList.add(i);
		}
		List<List<Integer>> mainList = powerList(inputList);

		Map<String, List<Integer>> maxList = new HashMap<String, List<Integer>>();
		for (List<Integer> s : mainList) {
			if (s.size() < 2) {
				continue;
			}
			List<Integer> slist = new ArrayList<Integer>(s);
			int max_diff = slist.get(1) - slist.get(0);
			int i, j;
			for (i = 0; i < s.size(); i++) {
				for (j = i + 1; j < s.size(); j++) {
					if (slist.get(j) - slist.get(i) > max_diff) {
						max_diff = slist.get(j) - slist.get(i);
						if (max_diff < 2) {
							maxList.put("MAX_LIST", slist);
						}

					}
				}
			}
		}

		return maxList.get("MAX_LIST").size();
	}

	public static List<List<Integer>> powerList(List<Integer> originalSet) {
		List<List<Integer>> mainList = new ArrayList<List<Integer>>();
		if (originalSet.isEmpty()) {
			mainList.add(new ArrayList<Integer>());
			return mainList;
		}
		Integer head = originalSet.get(0);
		List<Integer> subList = originalSet.subList(1, originalSet.size());
		for (List<Integer> ls : powerList(subList)) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.add(head);
			newList.addAll(ls);
			mainList.add(newList);
			mainList.add(ls);

		}
		return mainList;

	}
}
