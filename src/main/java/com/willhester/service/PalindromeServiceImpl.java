package com.willhester.service;

import java.util.ArrayList;
import java.util.List;

import com.willhester.builder.PalindromeBuilder;
import com.willhester.model.Palindrome;

/**
 * Implementation of the {@link PalindromeService} interface.
 * 
 * @author WillHester
 */
public class PalindromeServiceImpl implements PalindromeService {

	/**
	 * Required to calculate the starting index if more than one palindrome exists. 
	 */
	private String initialString;
	
	
	/**
	 * @see service.PalindromeService#findLongestPalindromes(String, int)
	 */
	@Override
	public List<Palindrome> findLongestPalindromes(String str, int n) {
		initialString = str;
		
		if (str.toCharArray().length < n) {
			throw new IllegalArgumentException("This string is too short to find " + n + " unique palindromes.");
		}
		
		//ArrayList quicker in most cases and ensures insertion order
		List<Palindrome> results = new ArrayList<>();

		for(int i = 1; i <= n; i++) {
			// Break the loop if a palindrome is found such that we cannot find n palindromes in the string
			if (str.isEmpty()) break;
			
			Palindrome pal = findLongestPalindrome(str);
			str = pal.getInitialString().replace(pal.getPalindrome(), "");
			results.add(pal);
		}
		
		return results;
	}

	
	/**
	 * Given an input string, find the longest palindrome substring and return a
	 * {@link Palindrome} object with it's fields populated. 
	 */
	private Palindrome findLongestPalindrome(String string) {
		int start, end;
		int length = string.toCharArray().length;
		int beginningIndex = 0;
		int maxPalLength = 1;
		
		for(int i = 1; i < length; i++ ) {
			
			// Even length palindromes will begin as two equal neighbouring elements
			start = i - 1; 
      end = i; 
      
      while (start >= 0 && end < length && string.charAt(start) == string.charAt(end)) { 
      	if (end - start + 1 > maxPalLength) { 
      		beginningIndex = start; 
      		maxPalLength = end - start + 1; 
      	} 
      	// Increment outwards
      	--start; 
      	++end; 
      }
      
      // Odd length palindromes will begin as two equal elements seperated by a
      // character
      start = i - 1; 
      end = i + 1; 
      
      while (start >= 0 && end < length && string.charAt(start) == string.charAt(end)) { 
       if (end - start + 1 > maxPalLength) { 
         beginningIndex = start; 
         maxPalLength = end - start + 1; 
       } 
       // Increment outwards
       --start; 
       ++end; 
      } 
	  }
		
		return buildMaxLengthPalindrome(string, beginningIndex, maxPalLength);
	}


	private Palindrome buildMaxLengthPalindrome(String string, int beginningIndex, int maxPalLength) {
		String palindromeString = string.substring(beginningIndex, beginningIndex + maxPalLength);
		
		Palindrome palindrome = new PalindromeBuilder()
			.withStringToDerivePalindrome(string)
		  .withPalindromeString(palindromeString)
		  .withIndex(initialString.indexOf(palindromeString))
		  .withLength(maxPalLength)
		  .build();
		return palindrome;
	}
}
