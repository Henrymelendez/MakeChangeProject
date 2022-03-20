package com.skilldistillery.MakeChange;

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {

	/*
	 * This method always returns correct amount of change, in the highest amounts
	 * possible
	 *
	 * @param cost a cost given by the user
	 * 
	 * @param tender the amount given by the user
	 * 
	 * @return the change is return in the highest amount
	 * 
	 */

	public static void tenderchange(double cost, double tender) {
		// a List created to hold the dollar amount in change for modulus division
		int[] money = { 2000, 1000, 500, 100, 25, 10, 5, 1 };
		// a list for the names of dollar amount to match to display to user.
		String[] names = { "Twentys", "Tens", "Fives", "Ones", "Quarters", "Dimes", "Nickels", "Pennies" };
		// make sure the change is in double to account for change.
		double changeDue = tender - cost;

		/* round change to the nearest whole number
		 change will store the change due rounded to the nearest whole number and type
	     cast to an int */
		int change = (int) (Math.round(changeDue * 100)); // this will round change to reduce float point error in
															// answer

		// an array to store the remainder value in each dollar amount.
		ArrayList<Integer> dollar = new ArrayList<Integer>();
		// conditional statements to check if amount provided is at or below zero
		if (changeDue == 0) {
			System.out.println("No change needed!");
		} // if amount less than cost utilizing basic java
		if (tender < cost) {
			System.out.println("Not Enough Money");
			System.exit(0);
		}
		// for loop that will the can
		else {
			for (int i : money) { // loop through int values
				int r = Math.round((int) change / i); // round to a whole number to get amount in dollars to whole
														// number
				dollar.add(r);
				change = change % i; // changes the value so only the remainder is left in the varialbe and will
										// repeat until it is done.
			}
		}

		// 
		System.out.print("The amount of change due is: ");
		// used printf to get it to a 2 point decimal number 
		System.out.printf("%.2f%n", changeDue);
		
		System.out.print("Amount: " + cost + ", " + "Tendered: " + tender + ", " + "Result: ");
		// for loop to loop through names and dollar amounts in array
		for (int i = 0; i < names.length; i++) {
			// used get to and a conditional to check if the amount in the array was greater than 1
			if (dollar.get(i) > 0) {
				System.out.print(names[i] + ": " + dollar.get(i) + " ");
				
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		System.out.print("What is the price of the item ?: ");
		double cost = kb.nextDouble();
		System.out.print("How much is Tendered by customer ?: ");
		double tender = kb.nextDouble();
		tenderchange(cost, tender);
		kb.close();

	}

}
