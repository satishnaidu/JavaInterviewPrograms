package com.sample.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	final Map<String, List<String>> lookup = new HashMap<String, List<String>>();

	public Anagrams(final List<String> words) {

		for (final String word : words) {
			final String signature = alphabetize(word);
			System.out.println("Signature word: " + signature);

			if (lookup.containsKey(signature)) {
				lookup.get(signature).add(word);
			} else {
				final List<String> anagramList = new ArrayList<String>();
				anagramList.add(word);
				lookup.put(signature, anagramList);
			}
		}
	}

	public String alphabetize(String word) {

		final byte[] bytes = word.getBytes();
		Arrays.sort(bytes);
		return new String(bytes);
	}

	public List<String> getAnagrams(final String word) {
		final String signature = alphabetize(word);
		final List<String> anagrams = lookup.get(signature);
		return anagrams == null ? new ArrayList<String>() : anagrams;
	}

	public static void main(String[] args) {

		List<String> words = new ArrayList<String>();
		words.add("satish");
		words.add("astish");
		words.add("astihs");
		words.add("rajesh");
		words.add("arjesh");
		Anagrams anagrams = new Anagrams(words);
		List<String> anagramsList = anagrams.getAnagrams(words.get(1));
		for (String anagram : anagramsList) {
			System.out.println("anagram: " + anagram);
		}

	}
}
