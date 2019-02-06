package com.willhester.builder;

import org.junit.Test;

import com.willhester.model.Palindrome;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestPalindromeBuilder {
	
	@Test
	public void testBuilder() {
		String stringToDerivePalindrome = "xhaba";
		String palindromeString = "aba";
		int index = 2;
		int length = 3;
		
		Palindrome pal = new PalindromeBuilder()
				.withStringToDerivePalindrome(stringToDerivePalindrome)
				.withPalindromeString(palindromeString)
				.withIndex(index)
				.withLength(length)
				.build();
		
		assertThat(pal.getInitialString(), equalTo(stringToDerivePalindrome));
		assertThat(pal.getPalindrome(), equalTo(palindromeString));
		assertThat(pal.getStartingIndex(), equalTo(index));
		assertThat(pal.getLength(), equalTo(length));
	}
}
