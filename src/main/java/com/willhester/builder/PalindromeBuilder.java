package com.willhester.builder;

import com.willhester.model.Palindrome;

/**
 * Builder class used to abstract the construction
 * of the {@link Palindrome} object away from the implmentation.
 * 
 * @author WillHester
 */
public class PalindromeBuilder {
	
	private String stringToDerivePalindrome;
	private String palindromeString;
	private int index;
	private int length;
	
	
	public PalindromeBuilder withStringToDerivePalindrome(String stringToDerivePalindrome) {
		this.stringToDerivePalindrome = stringToDerivePalindrome;
		return this;
	}

	public PalindromeBuilder withPalindromeString(String palindromeString) {
		this.palindromeString = palindromeString;
		return this;
	}
	
	public PalindromeBuilder withIndex(int index) {
		this.index = index;
		return this;
	}
	
	public PalindromeBuilder withLength(int length) {
		this.length = length;
		return this;
	}
	
	public Palindrome build() {
		return new Palindrome(stringToDerivePalindrome, palindromeString, index, length);
	}
}

