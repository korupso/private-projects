package ch.meccariello.calculator;

import java.math.BigInteger;

public class Calculator {
	/* Multiplication */																									// Comment to indicate the functionality of the method
	/**
	 * This method multiplies two integers. It explains it's calculation in a console output.
	 * @param x The integer to multiply.
	 * @param y The multiplicand.
	 * @return The product of the two integers.
	 */
	public static BigInteger multiply(Object x, Object y) {																	// Static method for easy use; Takes two Objects
		BigInteger a = new BigInteger(x.toString());																		// Convert the Object "x" to BigInteger
		BigInteger b = new BigInteger(y.toString());																		// Convert the Object "y" to BigInteger
		boolean[] negative = new boolean[] {false, false};																	// Initialization of the boolean array "negative"
		if (a.compareTo(new BigInteger("0")) < 0) {																			// Checks if a is negative
			a = new BigInteger(a.toString().substring(1));																	// Replaces a with it's positive
			negative[0] = true;																								// Set negative[0] to true
		}																													// The end of the if statement
		if (b.compareTo(new BigInteger("0")) < 0) {																			// Checks if b is negative
			b = new BigInteger(b.toString().substring(1));																	// Replaces b with it's positive
			negative[1] = true;																								// Set negative[1] to true
		}																													// The end of the if statement
		BigInteger result = new BigInteger("0");																			// Initialization of the integer "result"
		System.out.print(x.toString() + " * " + y.toString() + " = " + (b.compareTo(new BigInteger("0")) == 0 ? " " : a));	// The printing of the original expression and the beginning of the multiplication
		for (BigInteger i = new BigInteger("0"); i.compareTo(b) < 0; i = i.add(new BigInteger("1"))) {						// For loop, that repeats the code for b amount of times
			result = result.add(new BigInteger(a + ""));																	// Variable a is added to the result
			if (i.compareTo(new BigInteger("0")) != 0) {																	// Checks if the variable i is not equal to zero
				System.out.print(" + " + a);																				// The printing of an addition
			}																												// The end of the if statement
		}																													// The end of the for loop
		if (negative[0] != negative[1]) {																					// Checks if one and only one of the numbers is negative
			result = new BigInteger("-" + result);																			// Replaces the result with it's negative
		}																													// The end of the if statement
		System.out.print(" = " + result);																					// The printing of the result
		return result;																										// The return of the result
	}																														// The end of the method
																															// Empty space between methods
	/* Exponentiation */																									// Comment to indicate the functionality of the method
	/**
	 * This method raises x to the power of y. It explains it's calculation in a console output.
	 * @param x The base.
	 * @param y The power.
	 * @return The product of the x to the power of y.
	 */
	public static BigInteger pow(Object x, Object y) {																		// Static method for easy use; Takes two Objects
		BigInteger a = new BigInteger(x.toString());																		// Convert the Object "x" to BigInteger
		BigInteger b = new BigInteger(y.toString());																		// Convert the Object "y" to BigInteger
		BigInteger result = new BigInteger(a + "");																			// The variable "result" is initialized with the value of a
		for (BigInteger i = new BigInteger("1"); i.compareTo(b) < 0; i = i.add(new BigInteger("1"))) {						// For loop, that repeats the code for b - 1 amount of times
			result = multiply(result, new BigInteger(a + ""));																// Multiply the variable "result" with the value of a using the multiply method
			if (i.compareTo(b.subtract(new BigInteger("1"))) != 0) {														// Checks if the variable i is not equal to b - 1
				System.out.println(" | * " + a);																			// The printing of the calculation steps
			}																												// The end of the if statement
		}																													// The end of the for loop
		System.out.println("\n" + a + "^" + b + " = " + result);															// The printing of the calculation and the result
		return result;																										// The return of the result
	}																														// The end of the method
																															// Empty space between methods
	/* Factoration */																										// Comment to indicate the functionality of the method
	/**
	 * This method calculates the product of all integers leading up to x.
	 * @param x The upper limit until where the integers get multiplied.
	 * @return The product of all integers leading up to x.
	 */
	public static BigInteger factorial(Object x) {																			// Static method for easy use; Takes two Objects
		BigInteger a = new BigInteger(x.toString());																		// Convert the Object "x" to BigInteger
		BigInteger result = new BigInteger("1");																			// Initialization of the integer "result"
		for (BigInteger i = new BigInteger("2"); i.compareTo(a) <= 0; i = i.add(new BigInteger("1"))) {						// For loop, that repeats the code for a amount of times
			result = multiply(result, i);																					// Multiply the result with i
			if (i.compareTo(a) != 0) {																						// Checks if the variables i and a have the same value
				System.out.println(" | * " + i.add(new BigInteger("1")));													// The printing of the calculation steps
			}																												// The end of the if statement
		}																													// The end of the for loop
		System.out.println("\n" + a + "! = " + result);																		// The printing of the calculation and the result
		return result;																										// The return of the result
	}																														// The end of the method
	
}
