package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> hand;

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Hand() {
		hand = new ArrayList<>();
	}

	public void addCard(Card c) {
		hand.add(c);
	}

	public void clearHand() {
		hand.removeAll(hand);
	}

	public abstract int getHandValue();
		

}
