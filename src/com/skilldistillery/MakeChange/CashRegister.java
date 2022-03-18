package com.skilldistillery.MakeChange;

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
	

	  public static void tenderchange(double cost, double tender){
	    int[] money = {2000,1000,500, 100, 25, 10, 5, 1};
	    String[] names = {"Twentys","Tens","Fives","Ones","Quarters","Dimes","Nickels","Pennies"};
	    double changeDue = tender - cost;
	    // Make doubles into ints and to nearest deciml point;
	    int change = (int)(Math.round(changeDue*100)); // this will round change to reduce float point error in answer and round nearest whole
	    // create an array to store the values
	    ArrayList<Integer> dollar = new ArrayList<Integer>();
	    // conditinal statements 
	    if(changeDue == 0){
	      System.out.println("No change needed!");
	    } // if amount less than cost utilizing basic java
	    if(tender < cost){
	      System.out.println("Not Enough Money");
	      System.exit(0);
	    }
	    // for loop that takes the change and divides it by money amount in cents and add it to the array then up date the change
	   // by leaving the remainder as a whole number.
	    else{
	      for(int i : money){ // loop through int values
	        int r = Math.round((int)change/ i); // round to a whole number to get amount in dollars to whole number
	        dollar.add(r);
	        change = change % i; // changes the value so only the remainder is left in the varialbe and will repeat until it is done.
	      }
	    }
	    System.out.print("The amount of change due is: ");
	    System.out.printf("%.2f%n",changeDue);
	    int arryIdx = 0;
	    for(int i = 0; i < names.length; i++){ // match names of dollar amounts to amounts array;
	      System.out.println("The Amount of " + names[i] + ": " + dollar.get(arryIdx));
	      arryIdx +=1;
	    }





	  }
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
	    System.out.print("How much is the cost?: ");
	    double cost = kb.nextDouble();
	    System.out.print("How much is Tendered?: ");
	    double tender = kb.nextDouble();
	    tenderchange(cost,tender);
		
	}

}
