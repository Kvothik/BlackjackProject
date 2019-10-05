package com.skilldistillery.blackjack;

public class Player {

	BlackjackHand bjHand;

	public Player() {
		bjHand = new BlackjackHand();
	}

	public Hand playerGetHand() {
		return bjHand;
	}

	public void dealCardToPlayer(Card c) {
		bjHand.addCard(c);
	}

	public void showHand() {
		for (Card card : bjHand.getHand()) {
			System.out.print(card + "\t");
		}
		System.out.println();
	}

}
