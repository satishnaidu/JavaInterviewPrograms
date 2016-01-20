package com.sample.ds;

import java.util.Arrays;

public class MyArrayList {

	private int actSize;
	private Object[] elements;

	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public Object get(int index) {
		if (index < actSize) {
			return elements[index];
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public void add(Object element) {

		if (elements.length - actSize < 5) {
			increaseSize();
		}
		elements[actSize++] = element;
	}

	public void increaseSize() {
		elements = Arrays.copyOf(elements, elements.length * 2);
		System.out.println("new length: " + elements.length);
	}

	public Object remove(int index) {
		if (index < actSize) {
			Object obj = elements[index];
			elements[index] = null;
			int tmp = index;
			while (tmp < actSize) {
				elements[tmp] = elements[tmp + 1];
				elements[tmp + 1] = null;
				tmp++;
			}
			actSize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}

	}

	public int size() {
		return actSize;
	}

	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList();
		mal.add(new Integer(2));
		mal.add(new Integer(5));
		mal.add(new Integer(1));
		mal.add(new Integer(23));
		mal.add(new Integer(14));
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}
		mal.add(new Integer(29));
		System.out.println("Element at Index 5:" + mal.get(5));
		System.out.println("List size: " + mal.size());
		System.out.println("Removing element at index 2: " + mal.remove(2));
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}
	}
}
