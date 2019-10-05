package com.skilldistillery.blackjack;

public class Dealer {
	BlackjackHand bjHand;
	Deck deck;
	Pot pot;

	public Dealer() {
		bjHand = new BlackjackHand();
		deck = new Deck();
		deck.shuffleDeck();
		pot = new Pot(0, 0, 100, 1000);
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

}