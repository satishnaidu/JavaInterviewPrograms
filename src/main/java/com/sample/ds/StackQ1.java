package com.sample.ds;

import java.util.LinkedList;

public class StackQ1<T> {

	private LinkedList<T> q1 = new LinkedList<T>();
	private LinkedList<T> q2 = new LinkedList<T>();

	public void push(T t) {
		q1.addFirst(t);
	}

	public T pop() {
		if (q1.isEmpty()) {
			throw new RuntimeException("Can't pop from empty stack");
		}

		while (q1.size() > 1) {
			q2.addFirst(q1.removeLast());
		}

		T popped = q1.pop();
		LinkedList<T> tempQ = q1;
		q1 = q2;
		q2 = tempQ;
		return popped;
	}

	public static void main(String[] args) {
		StackQ1<Integer> stackQ1 = new StackQ1<Integer>();

		stackQ1.push(10);
		stackQ1.push(20);
		stackQ1.push(30);
		stackQ1.push(40);
		stackQ1.push(50);

		System.out.println(stackQ1.pop());
		System.out.println(stackQ1.pop());
		System.out.println(stackQ1.pop());
		System.out.println(stackQ1.pop());
		System.out.println(stackQ1.pop());

	}
}
