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

	public int getHandValue() {
		return bjHand.getHandValue();
	}

//	public boolean isBlackjack() {
//		bjHand.isBlackjack();
////		boolean isBlackjack = false;
////		if (bjHand.getHandValue() == 21) {
////			isBlackjack = true;
////		}
//		return bjHand.isBlackjack();
//	}
//	
	public boolean isBust() {
		bjHand.isBust();
//		boolean isBust = false;
//		if (bjHand.getHandValue() > 21) {
//			isBust = true;
//		}
		return bjHand.isBust();
	}
	
	public void playerBet(int bet) {
		
		pot.setPlayerMoney(getPlayerMoney() - bet);
		pot.setPot(getPot() + bet);
	}

	public void win() {
		pot.win();
	}

	public void lose() {
		pot.lose();
	}
	
	public void push() {
		pot.push();
	}
	
	public int getPlayerMoney() {
		return pot.getPlayerMoney();
	}
	
	public int getDealerMoney() {
		return pot.getDealerMoney();
	}
	
	public int getPot() {
		return pot.getPot();
	}
}