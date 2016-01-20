package com.sample.ds;

import java.util.Stack;

public class ParenthesisMatching {
	public static void main(String[] args) {

		String str = "{[({}[])]}";
		System.out.println(isParenthesiMatch(str));
		System.out.println(validate(str));
	}

	public static boolean isParenthesiMatch(String str) {

		Stack<Character> stack = new Stack<Character>();
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (c == '{') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty()) {
					return false;
				} else if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}

	public static boolean validate(String str) {
		Stack<Character> stack = new Stack<Character>();
		char current, previous;
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i);
			if (current == '(' || current == '[' || current == '{') {
				stack.push(current);
			} else if (current == ')' || current == ']' || current == '}') {
				if (stack.isEmpty()) {
					return false;
				} else {
					previous = stack.peek();
					if ((current == ')' && previous == '(') || (current == ']' && previous == '[')
							|| (current == '}' && previous == '{')) {
						stack.pop();
					}
				}
			}
		}
		return stack.isEmpty();
	}
}
