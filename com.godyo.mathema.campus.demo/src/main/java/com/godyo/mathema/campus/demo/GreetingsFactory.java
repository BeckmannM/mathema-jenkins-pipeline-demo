package com.godyo.mathema.campus.demo;

public class GreetingsFactory {
	
	public String createGreeting(String name) {
//		if (name == null) {
//			throw new NullPointerException("name must not be null");
//		}
		return "Hallo "+ name;
	}

}
