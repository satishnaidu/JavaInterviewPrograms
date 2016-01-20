package com.sample.ds;

public class StringInPlace {

	public static void main(String[] args) {

		String input = "Hi Satish";
		String result = inPlaceString(input);
		System.out.println(result);
	}

	public static String reverse(String str) {

		StringBuilder builder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			char charAtI = str.charAt(i);
			builder.append(charAtI);

		}
		return builder.toString();
	}

	public static String inPlaceString(String str) {

		StringBuilder builder = new StringBuilder(str);
		for (int i = 0; i < builder.length() / 2; i++) {
			final char charAtI = str.charAt(i);
			final int otherEnd = builder.length() - i - 1;
			builder.setCharAt(i, builder.charAt(otherEnd));
			builder.setCharAt(otherEnd, charAtI);
		}
		return builder.toString();
	}
}
