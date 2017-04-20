package com.godyo.mathema.campus.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _GreetingsFactory {

	@Test
	public void testCreateGreeting() {
		GreetingsFactory greetingsFac = new GreetingsFactory();
		String greeting = greetingsFac.createGreeting("Mathema");
		assertEquals("Hallo Mathema", greeting);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCreateGreeting_null() {
		GreetingsFactory greetingsFac = new GreetingsFactory();
		greetingsFac.createGreeting(null);
	}
}
