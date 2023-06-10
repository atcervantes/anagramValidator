package com.beyonnex.anagramValidator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramValidatorUtilsTest {

    @Test
    public void testGetStringsFromFile_ValidFilePath_ReturnsExpectedResult() throws Exception{
        String filePath = "validFile.txt";

        String[] expectedResult = { "The British Royal Family", "If Harry: \"Abolish my title.\"" };

        String[] result = AnagramValidatorUtils.getStringsFromFile(filePath);
        Assertions.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void testGetStringsFromFile_InvalidFilePath_ThrowsException() {
        String filePath = "invalidFile.txt";

        Assertions.assertThrows(Exception.class, () -> {
            AnagramValidatorUtils.getStringsFromFile(filePath);
        });
    }

    @Test
    public void testGetStringsFromFile_NullFilePath_ThrowsException() {
        String filePath = null;

        Assertions.assertThrows(Exception.class, () -> {
            AnagramValidatorUtils.getStringsFromFile(filePath);
        });
    }

    @Test
    public void testIsAnagram_ValidAnagrams_ReturnsTrue() {
        String textA = "listen";
        String textB = "silent";

        boolean expectedResult = true;

        boolean result = AnagramValidatorUtils.isAnagram(textA, textB);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAnagram_ValidNonAnagrams_ReturnsFalse() {
        String textA = "listen";
        String textB = "alone";

        boolean expectedResult = false;

        boolean result = AnagramValidatorUtils.isAnagram(textA, textB);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAnagram_ValidAnagramsDifferentCases_ReturnsTrue() {
        String textA = "LiStEn";
        String textB = "sIlEnT";

        boolean expectedResult = true;

        boolean result = AnagramValidatorUtils.isAnagram(textA, textB);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAnagram_DifferentLengths_ReturnsFalse() {
        String textA = "listen";
        String textB = "silentt";

        boolean expectedResult = false;

        boolean result = AnagramValidatorUtils.isAnagram(textA, textB);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAnagram_EmptyStrings_ReturnsTrue() {
        String textA = "";
        String textB = "";

        boolean expectedResult = true;

        boolean result = AnagramValidatorUtils.isAnagram(textA, textB);

        Assertions.assertEquals(expectedResult, result);
    }

}