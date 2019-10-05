package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackTable {

	BlackjackTable table1;
	Player p1;
	Dealer dealer;

	public void launch(Scanner kb) {
		int dealerValue = dealer.getHandValue();
		int playerValue = p1.getHandValue();
		table1 = new BlackjackTable();
		table1.newGame();
		table1.playerTurn(kb);
		table1.dealerTurn();
		if (playerValue < dealerValue) {
			System.out.println("Dealer wins!");
		} else if (playerValue > dealerValue) {
			System.out.println("Player wins!");
		} else {
			System.out.println("Push!");
		}
	}

	public void newGame() {
		System.out.println(
				"Dealer: \"Welcome to the Blackjack table! Please have a seat.\"" + "\n *Pot is right, Dealing*\n");
		p1 = new Player();
		dealer = new Dealer();
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		System.out.println("*Player Hand*");
		if (p1.isBlackjack()) {
			System.out.println("Player Blackjack!\n");
		}
		p1.showHand();
		System.out.println("Current hand value: " + p1.getHandValue());
		System.out.println();
		System.out.println("*Dealers Top Card*");
		if (dealer.isBlackjack()) {
			System.out.println("Dealer Blackjack!\n");
			dealer.showHand();
		}
		dealer.showTop();

	}

	public void playerTurn(Scanner kb) {
		boolean win = false;
		int yourTurn;
		do {
			System.out.println("\nAction: \n1. Hit\t2. Stay");
			yourTurn = kb.nextInt();
			switch (yourTurn) {
			case 1:
				System.out.println("*Player Hand*");
				p1.dealCardToPlayer(dealer.sendCard());// hit
				p1.showHand();
				System.out.println("Current hand value: " + p1.getHandValue());
				if (p1.isBust()) {
					System.out.println("Busted.\nYou Lose.");
					win = true;
				}
				break;
			case 2:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + yourTurn);
			}
		} while (yourTurn != 2);
	}

	public void dealerTurn() {
		dealer.showHand();
		System.out.println("Dealer current hand value: " + dealer.getHandValue());
		while (dealer.getHandValue() < 17) {
			dealer.dealCardToDealer(dealer.sendCard());
			dealer.showHand();
			System.out.println("Dealer current hand value: " + dealer.getHandValue());
		}
		if (dealer.isBust()) {
			System.out.println("Dealer bust.");
		}
	}
}
