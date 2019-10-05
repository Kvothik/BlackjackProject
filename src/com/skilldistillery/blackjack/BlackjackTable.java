package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackTable {

	BlackjackTable table1;
	Player p1;
	Dealer dealer;

	public void launch(Scanner kb) {
		table1 = new BlackjackTable();
		if (table1.newGame() == false) {
			if (table1.playerTurn(kb) == false) {
				if (table1.dealerTurn() == false) {
					table1.winCon();
				}
			}
		}
	}

	public boolean newGame() {
		System.out.println("Dealer: \"Welcome to the Blackjack table! Please have a seat.");
		p1 = new Player();
		dealer = new Dealer();
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		System.out.println("*Player Hand*");
		if (p1.isBlackjack()) {
			System.out.println("Player Blackjack!\t You Win!\n");
			return true;
		}
		p1.showHand();
		System.out.println("Current hand value: " + p1.getHandValue());
		System.out.println();
		System.out.println("*Dealers Top Card*");
		dealer.showTop();
		if (dealer.isBlackjack()) {
			System.out.println("Dealer Blackjack!\tSorry for your luck!\n");
			dealer.showHand();
			return true;
		}
		return false;
	}

	public boolean playerTurn(Scanner kb) {
		int yourTurn = 0;
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
					return true;
				}
				continue;
			case 2:
				return false;
			default:
				System.out.println("Invalid selection, please try again.");
				break;
			}
		} while (yourTurn != 2);
		return false;
	}

	public boolean dealerTurn() {
		System.out.println("\n*Dealer Hand*");
		dealer.showHand();
		System.out.println("Dealer current hand value: " + dealer.getHandValue());
		while (dealer.getHandValue() < 17) {
			System.out.println("Dealer hits.");
			dealer.dealCardToDealer(dealer.sendCard());
			dealer.showHand();
			System.out.println("Dealer current hand value: " + dealer.getHandValue());
		}
		if (dealer.isBust()) {
			System.out.println("Dealer bust.\n You win!");
			return true;
		}
		return false;
	}

	public boolean winCon() {
		if (p1.getHandValue() < dealer.getHandValue()) {
			System.out.println("Dealer wins!");
			return true;
		} else if (p1.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player wins!");
			return true;
		} else if (p1.getHandValue() == dealer.getHandValue()) {
			System.out.println("Push!");
			return true;
		}
		return false;
	}
}
