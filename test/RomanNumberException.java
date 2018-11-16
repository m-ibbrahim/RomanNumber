/**
 * 
 */
package com.javaboard.test;

/**
 * This is a user defined exception class to handle the exceptions in class RomanNumber.
 * 
 * @author Mohammad Ibrahim
 *
 */
public class RomanNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RomanNumberException(String s) {
		super(s);
	}

}
