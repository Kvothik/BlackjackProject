package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Casino {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Casino kinkyKelly = new Casino();
		kinkyKelly.launch(kb, dealer);
	}

	public void launch(Scanner kb, Dealer dealer) {
		System.out.println("Welcome to KinkyKelly Casino");
		int gameChoice;
		do {
		System.out.println("Please select your game: \n1. Blackjack \n2. Texas Hold'em\n3. Mississippi Stud\n4. Exit");
		gameChoice = kb.nextInt();
		switch (gameChoice) {
		case 1:
			BlackjackTable table1 = new BlackjackTable();
			table1.launch(kb, dealer);
			break;
		case 2:
//			Holdem table2 = new Holdem();
			System.out.println("Table currently under maintenance.");
			break;
		case 3:
//			MissStud table3 = new MissStud();
			System.out.println("Table currently under maintenance.");
			break;
		case 4:
			System.out.println("Exiting...");
			System.exit(0);

		}
		}while((gameChoice != 4));
	}
}
