package com.willhester.service;

import java.util.List;

import com.willhester.model.Palindrome;


public interface PalindromeService {
	
	/**
	 * <p>Returns a {@link LinkedList} containing the specified number of unique 
	 * longest {@link Palindrome} objects found in the given input string.</p>
	 * 
	 * <p>Finding the longest palindrome will dominate finding the correct number
	 * of palindromes. Given an input string of "abba" and n = 2, this will return 
	 * "abba" rather than "bb" and "a".</p>
	 * 
	 * @param str the input string for the palindromes to be determined from
	 * @param n the number of palindromes to find in the input string
	 * @return
	 */
	List<Palindrome> findLongestPalindromes(String str, int n);
}
