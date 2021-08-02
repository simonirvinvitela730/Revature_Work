package practice;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Welcome to the calculator app!");
		System.out.println("Select an option by pressing the corresponding number!");
		System.out.println("1 - Add");
		System.out.println("2 - Subtract");
		System.out.println("3 - Multiply");
		System.out.println("4 - Divide");
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		switch(input) {
		
			case 1:System.out.println("You've seleced Addition!");
				   
			System.out.println("Please enter two numbers followed by enter each time to complete your addition!");
			
			double number1 = in.nextDouble();
			double number2 = in.nextDouble();
			
			double output = (number1 + number2);
			
			System.out.println("Your first number: "+number1+" plus your second number: "+ number2 +" = "+output);
			System.out.println("Run the program again to perform another calculation! Goodbye.");
			break;
			
			case 2:System.out.println("You've seleced Subtraction!");
			
			System.out.println("Please enter two numbers followed by enter each time to complete your subtraction!");
			
			double number3 = in.nextDouble();
			double number4 = in.nextDouble();
			
			double output2 = (number3 - number4);
			
			System.out.println("Your first number: "+number3+" subtracted by your second number: "+ number4 +" = "+output2);
			System.out.println("Run the program again to perform another calculation! Goodbye.");
			break;
			
			case 3:System.out.println("You've seleced Multiplication!");
			
			System.out.println("Please enter two numbers followed by enter each time to complete your multiplication!");
			
			double number5 = in.nextDouble();
			double number6 = in.nextDouble();
			
			double output3 = (number5 * number6);
			
			System.out.println("Your first number: "+number5+" multiplied by your second number: "+ number6 +" = "+output3);
			System.out.println("Run the program again to perform another calculation! Goodbye.");
			break;
			
			case 4:System.out.println("You've seleced Divide");
			
			System.out.println("Please enter two numbers followed by enter each time to complete your division!");
			
			double number7 = in.nextDouble();
			double number8 = in.nextDouble();
			
			double output4 = (number7 * number8);
			
			System.out.println("Your first number: "+number7+" divided by your second number: "+ number8 +" = "+output4);
			System.out.println("Run the program again to perform another calculation! Goodbye.");
			break;
		}
	}
}
