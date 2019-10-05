package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackTable {

	Player p1;
	Dealer dealer;

	public void launch(Scanner kb) {
		if (newGame(kb) == false) {
			if (playerTurn(kb) == false) {
				if (dealerTurn() == false) {
					winCon();
				}
			}
		}
	}

	public boolean newGame(Scanner kb) {
		p1 = new Player();
		dealer = new Dealer();

		System.out.println("Dealer: \"Welcome to the Blackjack table! Please have a seat.");
		System.out.println("Wallet: $" + dealer.getPlayerMoney() + "\nSelect amount to bet: ");
		System.out.println("1. $15\t\t2. $20\t\t3. $50\t\t4. $100");
		int bet = kb.nextInt();
		playerBet(bet);

		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		System.out.println("*Player Hand*");
		if (p1.isBlackjack()) {
			System.out.println("Player Blackjack!\t You Win!\n");
			dealer.win();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
			return true;
		}
		p1.showHand();
		System.out.println("Current hand value: " + p1.getHandValue());
		System.out.println();
		System.out.println("*Dealers Top Card*");
		dealer.showTop();
		if (dealer.bjHand.isBlackjack()) {
			System.out.println("Dealer Blackjack!\tSorry for your luck!\n");
			dealer.lose();
			dealer.showHand();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
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
					dealer.lose();
					System.out.println(
							"Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
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
			dealer.win();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
			return true;
		}
		return false;
	}

	public boolean winCon() {
		if (p1.getHandValue() < dealer.getHandValue()) {
			System.out.println("Dealer wins!");
			dealer.lose();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
			return true;
		} else if (p1.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player wins!");
			dealer.win();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
			return true;
		} else if (p1.getHandValue() == dealer.getHandValue()) {
			System.out.println("Push!");
			dealer.push();
			System.out.println("Wallet: " + dealer.getPlayerMoney() + "\t\tDealer Money: " + dealer.getDealerMoney());
			return true;
		}
		return false;
	}

	public void playerBet(int bet) {
		switch (bet) {
		case 1:
			dealer.playerBet(15);
			System.out.println("Pot: $" + dealer.getPot());
			break;
		case 2:
			dealer.playerBet(20);
			System.out.println("Pot: $" + dealer.getPot());
			break;
		case 3:
			dealer.playerBet(50);
			System.out.println("Pot: $" + dealer.getPot());
			break;
		case 4:
			dealer.playerBet(100);
			System.out.println("Pot: $" + dealer.getPot());
			break;
		default:
			System.out.println("Invalid selection, please try again.");
			break;
		}
	}
}
