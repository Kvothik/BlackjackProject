package com.skilldistillery.blackjack;

public class Pot {
	private int amountInPot;
	private int bet;
	private int playerMoney;
	private int dealerMoney;

	public Pot(int pot, int bet, int playerMoney, int dealerMoney) {
		super();
		this.amountInPot = pot;
		this.bet = bet;
		this.playerMoney = playerMoney;
		this.dealerMoney = dealerMoney;
	}

	public void playerBet(int bet) {
		this.bet = bet;
		setPlayerMoney(getPlayerMoney() - bet);
		setPot(getPot() + bet);
	}

	public int win() {
		setPlayerMoney(getPlayerMoney() + amountInPot * 2);
		setDealerMoney(getDealerMoney());
		return getPlayerMoney();
	}

	public int lose() {
		setDealerMoney(getDealerMoney() + amountInPot);
		return getDealerMoney();
	}
	
	public int push() {
		setPlayerMoney(getPlayerMoney() + bet);
		return getPlayerMoney();
	}

	public int getPot() {
		return amountInPot;
	}

	public void setPot(int pot) {
		this.amountInPot = pot;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}

	public int getDealerMoney() {
		return dealerMoney;
	}

	public void setDealerMoney(int dealerMoney) {
		this.dealerMoney = dealerMoney;
	}
}
