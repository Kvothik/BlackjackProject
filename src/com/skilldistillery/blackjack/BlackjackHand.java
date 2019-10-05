package com.skilldistillery.blackjack;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	

	public BlackjackHand(){
		hand = new ArrayList<>();
	}
	
	
	public boolean isBlackjack() {
		boolean isBlackjack = false;
		if (getHandValue() == 21) {
			isBlackjack = true;
		}
		return isBlackjack;
	}
	
	public boolean isBust() {
		boolean isBust = false;
		if (getHandValue() > 21) {
			isBust = true;
		}
		return isBust;
	}
	
//	public boolean isHard() {
//		
//	}
//	
//	public boolean isSoft() {
//		
//	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}
}
