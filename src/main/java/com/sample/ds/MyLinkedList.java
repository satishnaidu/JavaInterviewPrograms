package com.sample.ds;

import java.util.NoSuchElementException;

public class MyLinkedList {

	private Node head;

	public MyLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(Object item) {
		head = new Node(item, head);
	}

	public Object getFirst() {
		return head.data;
	}

	public void addLast(Object item) {
		if (head == null) {
			addFirst(item);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(item, null);

		}
	}

	public Object getLast() {
		if (head == null) {
			throw new NoSuchElementException();
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void clear() {
		head = null;
	}

	public Object get(int index) {

		if (head == null) {
			throw new IndexOutOfBoundsException();
		}

		Node temp = head;
		for (int k = 0; k < index; k++) {
			temp = temp.next;
		}
		if (temp == null) {
			throw new IndexOutOfBoundsException();
		}
		return temp.data;
	}

	public void remove(Object key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		if (head.data.equals(key)) {
			head = head.next;
			return;
		}

		Node cur = head;
		Node prev = null;

		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		// delete cur node
		prev.next = cur.next;
	}

	class Node {

		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst("p");
		list.addFirst("a");
		list.addFirst("e");
		list.addFirst("h");
		System.out.println(list);

		System.out.println(list.get(0));
		// System.out.println(list.get(4)); //exception

		list.addLast("s");

		System.out.println(list);
		System.out.println(list.getLast());

		System.out.println(list);

		list.remove("p");
		System.out.println(list);
	}
}
