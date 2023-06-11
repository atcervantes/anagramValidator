package com.cervantes.anagramValidator.utils;

import java.io.*;

public class AnagramValidatorUtils {

	public static String[] getStringsFromFile(String filePath) throws Exception {
		StringBuilder content = new StringBuilder();

		try (InputStream inputStream = AnagramValidatorUtils.class.getClassLoader().getResourceAsStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


		String [] result = content.toString().split("=");

		if (result.length != 2)
			throw new Exception("Invalid File");

		return result;
	}

	public static boolean isAnagram(String textA, String textB) {

		if ( textA.equals(textB) )
			return true;

		textA = sanitizeText(textA);
		textB = sanitizeText(textB);

		if(textA.length() != textB.length()) {
			return false;
		}

		int[] charArray = new int[26];

		for ( char c : textA.toLowerCase().toCharArray()) {
			if(c >= 'a' && c <= 'z')
				charArray[c - 'a']++;
		}
		for ( char c : textB.toLowerCase().toCharArray()) {
			if(c >= 'a' && c <= 'z')
				charArray[c - 'a']--;
		}

		for (int numberOfOccurrences : charArray){
			if(numberOfOccurrences != 0)
				return false;
		}

		return true;

	}

	private static String sanitizeText(String text) {
		return text.replaceAll("[^a-zA-Z]","");
	}

}
