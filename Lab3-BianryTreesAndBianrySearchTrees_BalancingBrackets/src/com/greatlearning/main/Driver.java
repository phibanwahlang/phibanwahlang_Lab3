package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.main.service.balancingBrackets;

public class Driver {
	public static void main(String[] args) {
		String expression;
		balancingBrackets expr = new balancingBrackets();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression to be checked ");
		expression = sc.next();
		if (expr.areBracketsBalanced(expression)) {
			System.out.println("The entered string has balanced brackets");
		} else
			System.out.println("The entered string do not contain balanced brackets");
		sc.close();
	}
}
