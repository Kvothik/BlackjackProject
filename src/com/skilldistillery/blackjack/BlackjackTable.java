package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackTable {

	Player p1;

	public void launch(Scanner kb, Dealer dealer) {
		dealer.pot.clearPot();
		System.out.println("Dealer: \"Welcome to the Blackjack table! Please have a seat.");
		System.out.println("Wallet: $" + dealer.pot.getPlayerMoney() + "\nSelect amount to bet: ");
		System.out.println("1. $15\t\t2. $20\t\t3. $50\t\t4. $100");
		int bet = kb.nextInt();
		playerBet(bet, dealer);

		if (newGame(kb, dealer) == false) {
			if (playerTurn(kb, dealer, bet) == false) {
				if (dealerTurn(dealer) == false) {
					winCon(dealer);
				}
			}
		}
	}

	public boolean newGame(Scanner kb, Dealer dealer) {
		p1 = new Player();
		dealer.bjHand.clearHand();
		dealer.deck.shuffleDeck();
		System.out.println("Cards in current deck" + dealer.deck.checkDeckSize());

		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		p1.dealCardToPlayer(dealer.sendCard());
		dealer.dealCardToDealer(dealer.sendCard());
		System.out.println("*Player Hand*");
		if (p1.bjHand.isBlackjack()) {
			System.out.println("Player Blackjack!\t You Win!\n");
			dealer.pot.win();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		}
		p1.showHand();
		System.out.println("Current hand value: " + p1.bjHand.getHandValue());
		System.out.println();
		System.out.println("*Dealers Top Card*");
		dealer.showTop();
		if (dealer.bjHand.isBlackjack()) {
			System.out.println("Dealer Blackjack!\tSorry for your luck!\n");
			dealer.pot.lose();
			dealer.showHand();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		}
		return false;
	}

	public boolean playerTurn(Scanner kb, Dealer dealer, int bet) {
		int yourTurn = 0;
//			int firstCard = 0;
//			int secondCard = 0;
//			for (Card card : p1.bjHand.hand) {
//				firstCard = card.getValue();
//				break;
//			}
//			for (Card card : p1.bjHand.hand) {
//				secondCard = card.getValue();
//			}
			do {
//			if (firstCard == secondCard) {
//				System.out.println("\nAction: \n1. Hit\t2. Stay\t3. Double Down\t4. Split");
//			} else {
				System.out.println("\nAction: \n1. Hit\t2. Stay\t3. Double Down");
				yourTurn = kb.nextInt();

				switch (yourTurn) {
				case 1:// hit
					System.out.println("*Player Hand*");
					p1.dealCardToPlayer(dealer.sendCard());
					p1.showHand();
					System.out.println("Current hand value: " + p1.bjHand.getHandValue());
					if (p1.bjHand.isBust()) {
						System.out.println("Busted.\nYou Lose.");
						dealer.pot.lose();
						System.out.println("Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: "
								+ dealer.pot.getDealerMoney());
						return true;
					}
					continue;
				case 2:// Stay
					return false;
				case 3:// Double down
					System.out.println("*Player Hand*");
					p1.dealCardToPlayer(dealer.sendCard());
					p1.showHand();
					System.out.println("Current hand value: " + p1.bjHand.getHandValue());
					playerBet(bet, dealer);
					if (p1.bjHand.isBust()) {
						System.out.println("Busted.\nYou Lose.");
						dealer.pot.lose();
						System.out.println("Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: "
								+ dealer.pot.getDealerMoney());
						return true;
					}
					return false;
//				case 4:// Split
//					split(kb, dealer, bet);
				default:
					System.out.println("Invalid selection, please try again.");
					break;
				}
//			}
		} while (yourTurn != 2);
		return false;
	}

	public boolean dealerTurn(Dealer dealer) {
		System.out.println("\n*Dealer Hand*");
		dealer.showHand();
		System.out.println("Dealer current hand value: " + dealer.bjHand.getHandValue());
		while (dealer.bjHand.getHandValue() < 17) {
			System.out.println("Dealer hits.");
			dealer.dealCardToDealer(dealer.sendCard());
			dealer.showHand();
			System.out.println("Dealer current hand value: " + dealer.bjHand.getHandValue());
		}
		if (dealer.bjHand.isBust()) {
			System.out.println("Dealer bust.\n You win!");
			dealer.pot.win();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		}
		return false;
	}

	public boolean winCon(Dealer dealer) {
		if (p1.bjHand.getHandValue() < dealer.bjHand.getHandValue()) {
			System.out.println("Dealer wins!");
			dealer.pot.lose();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		} else if (p1.bjHand.getHandValue() > dealer.bjHand.getHandValue()) {
			System.out.println("Player wins!");
			dealer.pot.win();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		} else if (p1.bjHand.getHandValue() == dealer.bjHand.getHandValue()) {
			System.out.println("Push!");
			dealer.pot.push();
			System.out.println(
					"Wallet: " + dealer.pot.getPlayerMoney() + "\t\tDealer Money: " + dealer.pot.getDealerMoney());
			return true;
		}
		return false;
	}

	public void playerBet(int bet, Dealer dealer) {
		switch (bet) {
		case 1:
			dealer.pot.playerBet(15);
			System.out.println("Wallet: $" + dealer.pot.getPlayerMoney() + "\t\t" + "Pot: $" + dealer.pot.getPot());
			break;
		case 2:
			dealer.pot.playerBet(20);
			System.out.println("Wallet: $" + dealer.pot.getPlayerMoney() + "\t\t" + "Pot: $" + dealer.pot.getPot());
			break;
		case 3:
			dealer.pot.playerBet(50);
			System.out.println("Wallet: $" + dealer.pot.getPlayerMoney() + "\t\t" + "Pot: $" + dealer.pot.getPot());
			break;
		case 4:
			dealer.pot.playerBet(100);
			System.out.println("Wallet: $" + dealer.pot.getPlayerMoney() + "\t\t" + "Pot: $" + dealer.pot.getPot());
			break;
		default:
			System.out.println("Invalid selection, please try again.");
			break;
		}
	}

//	public void split(Scanner kb, Dealer dealer, int bet) {
//		Card newHand1 = new Card();
//		Card newHand2 = new Card();
//		for (Card card : p1.bjHand.hand) {
//			newHand1 = card;
//			break;
//		}
//		for (Card card : p1.bjHand.hand) {
//			newHand2 = card;
//		}
//		p1.clearHand();
//		p1.splitAdd(newHand1);
//		p1.addSplitCard(dealer.sendCard());
//		playerTurn(kb, dealer, bet);
//		p1.bjHand.addCard(newHand2);
//		p1.dealCardToPlayer(dealer.sendCard());
//		playerTurn(kb, dealer, bet);
//	}
}
