package com.sample.fb;

public class GoatLatin {

	public static void main(String[] args) {

		GoatLatin latin = new GoatLatin();
		String s1 = "I speak Goat Latin";
		String s2 = "The quick brown fox jumped over the lazy dog";
		System.out.println(latin.toGoatLatin(s1));
		System.out.println(latin.toGoatLatin(s2));

	}

	public String toGoatLatin(String s) {

		int t = 1;
		StringBuilder builder = new StringBuilder();
		for (String word : s.split(" ")) {
			char ch = word.charAt(0);
			if (isVowel(ch)) {
				builder = builder.append(word);
			} else {
				builder = builder.append(word.substring(1, word.length()));
				builder = builder.append(ch);
			}
			builder.append("ma");
			for (int i = 0; i < t; i++) {
				builder.append("a");
			}
			t++;
			builder.append(" ");
		}
		return builder.toString();
	}

	public boolean isVowel(char ch) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (char vowel : vowels) {
			if (vowel == ch) {
				return true;
			}
		}
		return false;
	}

}
