/**
 * 
 */
package com.distillery.palindrome.max;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Adolfo Miguel Iglesias Chaviano
 *
 */
public class MaxPalindromeTest {
	
	
	/**
	 * When text is null or empty then No Palindrome
	 */
	@Test
	@DisplayName("there is no palindrome word")
	public void whenNoTextThenNoPalindrome() {
		
		//Case 1: "Text empty"
		String text = "";
		String actual = MaxPalindrome.findMaxPalindrome(text);
		
		String expected = "there is no palindrome word";
		assertEquals(expected, actual);
		
		//Case 2: "Text null"
		text = null;
		actual = MaxPalindrome.findMaxPalindrome(text);
		assertEquals(expected, actual);
	}
	
	/**
	 * When all characters are different then only one character is palindrome. the first one
	 */
	@Test
	@DisplayName("asdfgrtyuijko -> a")
	public void whenAllCharactersAreDifferentThenMaxPalindromeIsOnlyOneCharacter() {
		
		String text = "asdfgrtyuijko";
		String actual = MaxPalindrome.findMaxPalindrome(text);
		
		String expected = "a";
		assertEquals(expected, actual);
		
	}
	
	/**
	 * When each characters of the text has pair value then all characters 
	 * are in inside of palindrome text 
	 */
	@Test
	@DisplayName("abwrtyyqqtrwba -> abwrtyqqytrwba")
	public void whenEachCharacterHasPairValueThenAllareInPalindromeText() {
		
		String text = "abwrtyyqqtrwba";
		String actual = MaxPalindrome.findMaxPalindrome(text);
		
		String expected = "abwrtyqqytrwba";
		assertEquals(expected, actual);
		
	}
	
	/**
	 * When not each characters of the text has pair value then all characters 
	 * with pair value will be of palindrome text and 
	 * plus in the middle the first character without pair 
	 */
	@Test
	@DisplayName("abwrctyyqqtrwba | abwrctyyqqdlotrwba -> abwrtyqcqytrwba ")
	public void whenNotEachCharacterWithPairValueMoreOneWithoutPairValueThenAllWithPairValuePlusOneCharacterWithoutPair() {
		
		String text = "abwrctyyqqtrwba";
		String actual = MaxPalindrome.findMaxPalindrome(text);
		
		String expected = "abwrtyqcqytrwba";
		assertEquals(expected, actual);
		
	}

}
