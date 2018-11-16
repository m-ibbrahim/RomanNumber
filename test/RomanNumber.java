/**
 * @Copyright XYZ 2018
 * 
 */
// Review comment: Add copyright 
package com.javaboard.test;

/**
 * The codes intent is to have a class that takes a number and returns the roman numberal string.
 * 
 * @author Mohammad Ibrahim
 */

// Review comment: Add Class level comments
public class RomanNumber {

	// Represents the number that needs to be converted to Roman character(s)
	private int itsNumber; // Review comment: variable 'number' renamed to 'itsNumber' as it is class level variable; add line level comment wherever required

	// The max value that could be converted to equivalent Roman character(s)
	private static final int MAX_VALUE = 3000; // Review comment: Static fields should be capital case

	public RomanNumber(int argNumber) throws RomanNumberException { // Review comment: number should be named as argNumber so that it be identifiable

		if (argNumber > MAX_VALUE) { // Review comment: Wrap the block with-in { } for better readability
			throw new RomanNumberException("RomanNumber only supports numbers upto 3000"); // Review comment: Write a User defined Exception class which will handle all the exceptions for this class
		}
		this.itsNumber = argNumber;
	}

	// Review comment: Dead code as the variable is already initialized in the constructor. TODO: Below method could be removed.
	public void setNumber(String argNumber) throws RomanNumberException {

		this.itsNumber = Integer.parseInt(argNumber);

		if (this.itsNumber > MAX_VALUE) {
			throw new RomanNumberException("RomanNumber only supports numbers upto 3000"); // Throws RomanNumberException
		}
	}

	/**
	 * This method converts the input integer number to its equivalent Roman number.
	 * 
	 * @return String representing the Roman Characters of the input number.
	 */
	// Review comment: Add method level java-docs
	public String convert() {
		String result = "";

		try {
			int thousands = (this.itsNumber / 1000); // Review comment: Surround in () for better readability of the arithmetic expression
			result += times(thousands, "M");

			int hundreds = ((this.itsNumber / 100) % 10); // Review comment: Surround in () for better readability of the arithmetic expression
			result += times(hundreds, "C", "D", "M");

			int tens = ((this.itsNumber / 10) % 10); // Review comment: Surround in () for better readability of the arithmetic expression
			result += times(tens, "X", "L", "C");

			int ones = ((this.itsNumber % 10)); // Review comment: Surround in () for better readability of the arithmetic expression
			result += times(ones, "I", "V", "X");

		} catch (RomanNumberException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/**
	 * This method returns the roman character of a particular number.
	 * 
	 * @param argNumber
	 * @param argCharacter
	 * @return
	 */
	private String times(int argNumber, String argCharacter) {
		String result = "";

		for (int i = 0; i < argNumber; i++) {
			result += argCharacter;
		}
		return result;
	}

	/**
	 * This method returns the roman character of a particular number.
	 * 
	 * @param argNumber
	 *            number which needs to converted to roman
	 * @param o
	 * @param f
	 * @param t
	 * @return
	 * @throws RomanNumberException
	 */
	private String times(int argNumber, String o, String f, String t) throws RomanNumberException { // TODO: Rename the arg to more appropriate names
		switch (argNumber) {
		case 0:
			return "";
		case 1:
		case 2:
		case 3:
			return times(argNumber, o);
		case 4:
			return o + f;
		case 5:
		case 6:
		case 7:
		case 8:
			return f + times(argNumber - 5, o);
		case 9:
			return o + t;
		default:
			throw new RomanNumberException("Only single digits allowed. Not - " + argNumber);
		}
	}
}
