package com.willhester;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.willhester.model.Palindrome;
import com.willhester.service.PalindromeServiceImpl;

@SpringBootApplication
public class MaclarenPalindromesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaclarenPalindromesApplication.class, args);
		System.out.print("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.print("Enter the number of palindromes to find: ");
		int n = scanner.nextInt();
		
		List<Palindrome> result = new PalindromeServiceImpl().findLongestPalindromes(string, n);
		
		System.out.print("The " + n + " longest unique palindromes are: ");
		System.out.println("");
		for(Palindrome p: result) {
		 System.out.println(p.toString());
		}
		scanner.close();
	}
}

