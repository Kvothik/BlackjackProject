package com.skilldistillery.blackjack;

public class Player {

	Hand bjHand;

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

	public int getHandValue() {
		return bjHand.getHandValue();
	}
	
	public boolean isBlackjack() {
		boolean isBlackjack = false;
		if (bjHand.getHandValue() == 21) {
			isBlackjack = true;
		}
		return isBlackjack;
	}
	
	public boolean isBust() {
		boolean isBust = false;
		if (bjHand.getHandValue() > 21) {
			isBust = true;
		}
		return isBust;
	}
}
