package com.willhester.model;

/**
 * Model object for storing information on a palindrome
 * found in a given string.
 * 
 * @author WillHester
 */
public class Palindrome {

	private String initialString;
	private String palindrome;
	private int startingIndex;
	private int length;
	
	public Palindrome(String initialString, String palindrome, int startingIndex, int length) {
		this.initialString=initialString;
		this.palindrome=palindrome;
		this.startingIndex=startingIndex;
		this.length=length;
	}
	
	public String getInitialString() {
		return initialString;
	}
	
	public void setInitialString(String initialString) {
		this.initialString = initialString;
	}
	
	
	public String getPalindrome() {
		return palindrome;
	}
	
	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}
	
	public int getStartingIndex() {
		return startingIndex;
	}
	
	public void setStartingIndex(int startingIndex) {
		this.startingIndex = startingIndex;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * Custom override for the output specified by the test case.
	 */
	@Override
	public String toString() {
		return "Text: " + getPalindrome() + ", Index: " + getStartingIndex() + ", Length: " + getLength();
	}
}