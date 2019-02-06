package com.willhester.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.willhester.model.Palindrome;

public class TestPalindromeService {
	
private PalindromeServiceImpl service = new PalindromeServiceImpl();
	

	@Test(expected=IllegalArgumentException.class)
	public void testTooManyPalindromes() {
		String str = "ab";
		int n = 3;
	
		List<Palindrome> palindromes = service.findLongestPalindromes(str, n);
		assertTrue(palindromes.isEmpty());
	}
	
	
	@Test
	public void testFindsLongestOverN() {
		String str = "aba";
		int n = 3;
		
		List<Palindrome> result = service.findLongestPalindromes(str, n);
		
		assertThat(result.size(), equalTo(1));
	  assertThat(result.get(0).getPalindrome(), equalTo("aba"));
	  assertThat(result.get(0).getStartingIndex(), equalTo(0)); 
	  assertThat(result.get(0).getLength(), equalTo(3));
	}
	
	
	@Test
	public void testUniquePalindromesEqualToN() {
		String str = "abc";
		int n = 3;
		
		List<Palindrome> result = service.findLongestPalindromes(str, n);
		
		assertThat(result.size(), equalTo(3));
	  assertThat(result.get(0).getPalindrome(), equalTo("a"));
	  assertThat(result.get(0).getStartingIndex(), equalTo(0)); 
	  assertThat(result.get(0).getLength(), equalTo(1));
	  
	  assertThat(result.get(1).getPalindrome(), equalTo("b"));
	  assertThat(result.get(1).getStartingIndex(), equalTo(1)); 
	  assertThat(result.get(1).getLength(), equalTo(1));
	  
	  assertThat(result.get(2).getPalindrome(), equalTo("c"));
	  assertThat(result.get(2).getStartingIndex(), equalTo(2));
	  assertThat(result.get(2).getLength(), equalTo(1));
	}


	@Test
	public void testMclarenTestCase() {
	  String str = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";
	  int n = 3;
	  
	  List<Palindrome> result = service.findLongestPalindromes(str, n);
	  
	  assertThat(result.size(), equalTo(3));
	  assertThat(result.get(0).getPalindrome(), equalTo("hijkllkjih"));
	  assertThat(result.get(0).getStartingIndex(), equalTo(23));
	  assertThat(result.get(0).getLength(), equalTo(10));
	  
	  assertThat(result.get(1).getPalindrome(), equalTo("defggfed"));
	  assertThat(result.get(1).getStartingIndex(), equalTo(13));
	  assertThat(result.get(1).getLength(), equalTo(8));
	  
	  assertThat(result.get(2).getPalindrome(), equalTo("abccba"));
	  assertThat(result.get(2).getStartingIndex(), equalTo(5));
	  assertThat(result.get(2).getLength(), equalTo(6));
	}
	

	@Test
	public void testIndexOfInitialStringIsPersisted() {
		String str = "hcabbchawhkwlwknnoonpl";
		int n = 3;
	  List<Palindrome> result = service.findLongestPalindromes(str, n);
	  
	  assertThat(result.size(), equalTo(3));
	  assertThat(result.get(0).getPalindrome(), equalTo("kwlwk"));
	  assertThat(result.get(0).getStartingIndex(), equalTo(10));
	  assertThat(result.get(0).getLength(), equalTo(5));
	  
	  assertThat(result.get(1).getPalindrome(), equalTo("noon"));
	  assertThat(result.get(1).getStartingIndex(), equalTo(16));
	  assertThat(result.get(1).getLength(), equalTo(4));
	  
	  assertThat(result.get(2).getPalindrome(), equalTo("bb"));
	  assertThat(result.get(2).getStartingIndex(), equalTo(3));
	  assertThat(result.get(2).getLength(), equalTo(2));
	}
}
