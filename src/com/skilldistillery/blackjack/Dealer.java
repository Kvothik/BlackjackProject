package com.skilldistillery.blackjack;

public class Dealer {
	BlackjackHand bjHand;
	Deck deck;

	public Dealer() {
		bjHand = new BlackjackHand();
		deck = new Deck();
		deck.shuffleDeck();
	}

	public Hand dealerGetHand() {
		return bjHand;
	}

	public void dealCardToDealer(Card c) {
		bjHand.addCard(c);
	}

	public Card sendCard() {
		return deck.dealCard();
	}

	public void showTop() {
		for (Card card : bjHand.getHand()) {
			System.out.println(card);
			break;
		}
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