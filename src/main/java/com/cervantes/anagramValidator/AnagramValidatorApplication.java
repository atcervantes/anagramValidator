package com.cervantes.anagramValidator;


import com.cervantes.anagramValidator.utils.AnagramValidatorUtils;

public class AnagramValidatorApplication {


	public static final String anagramsFile = "anagram.txt";

	public static void main(String[] args) {

		String [] anagrams = new String[0];
		try {
			anagrams = AnagramValidatorUtils.getStringsFromFile(anagramsFile);
			Boolean isValidAnagram = AnagramValidatorUtils.isAnagram(anagrams[0], anagrams[1]);

			String result = isValidAnagram ? "Valid Anagrams" : "NOT Valid Anagrams";
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
