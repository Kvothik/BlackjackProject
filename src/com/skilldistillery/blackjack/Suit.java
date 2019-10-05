package com.skilldistillery.blackjack;

public enum Suit {
	HEARTS("\u2764"), SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u25c6");

	Suit(String s) {
		name = s;
	}

	final private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
