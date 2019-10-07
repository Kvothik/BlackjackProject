package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

	BlackjackHand bjHand;
	List<Card> splitHand;
	

	public Player() {
		bjHand = new BlackjackHand();
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

	public void clearHand() {
		bjHand.clearHand();
	}

	public List<Card> splitAdd(Card c) {
		splitHand = new ArrayList<>();
		return splitHand;
	}
	
	public void addSplitCard(Card c) {
		splitHand.add(c);
	}

}
