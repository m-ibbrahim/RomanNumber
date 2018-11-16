package com.javaboard.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.mockito.Mock;

public class RomanNumberTest {

	@Mock
	RomanNumber r;

	@Test
	public void testRomanNumber() throws RomanNumberException {

		assertEquals("X", new RomanNumber(10).convert());
		assertEquals("C", new RomanNumber(100).convert());
		assertNotEquals("C", new RomanNumber(101).convert());
	}

}
