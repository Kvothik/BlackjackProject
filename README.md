# Week 4 Homework Project for Skill Distillery

## Overview

Blackjack is a text based blackjack game. To explain how it was built, I will give a short rundown of each class and how they play a part.

Note - the Dealer is instantiated in the Casino class in order to prevent creating a new pot each new round.

### Casino

The Casino class is where main is. The user is prompted with a menu to select the game they would like to play.

1.Blackjack
2.Texas Hold'em
3.Mississippi Stud

Currently, the only game I have created is Blackjack. I plan on implementing the others in the future for practice.

Once the user selects the game, their choice is passed to a switch that then calls the launch method in the selected game.

### Suit

The Suit enum defines a cards Suit. It contains HEARTS, SPADES, CLUBS, and DIAMONDS. Instead of assigning the name of each Suit eg. "Hearts", I used the unicode reference to each corresponding emoji.

### Rank

The Rank enum defines a cards value 1-10 and 11 for ACE. Soft and hard ACES is to be implemented soon.

### Hand

Hand is an abstract class which has a protected List<Card>. Hand also has methods to add a card to the list, clear the list of cards, and a constructor.
Hand was designed to be reused for other games when I make Texas Hold'em and Mississippi Stud.

### Pot

The Pot class contains constructors and methods which define what happens with money in the game. This will be an ongoing stretch goal to make everything better, but everything works as of now.

playerBet(int bet) - This method takes the argument (int bed), subtracts the bet from playerMoney and adds that money to the pot.

win() - takes any money out of the pot and adds it to playerMoney * 2. It is multiplied by 2 because the dealer will match the players bet.

lose() - gives money in the pot to dealerMoney.

push() - returns bet to player money as this only happens in a draw with no winners.

clear() - sets pot to 0 for the start of a new round.

### Dealer

The Dealer class has-a BlackjackHand, Deck, and a Pot. I used the Dealer to mimic real life. For example the Dealer will handle the Pot, deal the Cards and shuffle the Deck.

In the dealers constructor, a new Pot instance is created which sets the playerMoney: 100
and
dealerMoney: 1000
###### I feel adding an account feature at a later time would be nice allowing the player to log in and save their available balance and also possibly play with others.

The Dealer has the following notable methods:

dealCardToDealer(Card c) - Adds a card to the dealers hand.

sendCard() - Adds a card to players hand.

showTop() - Shows the top card face up at start of game per blackjack rules.

showHand() - Shows all of the dealers cards at the start of dealer turn to determine if dealer will hit or stay.

Along with all methods for the classes the dealer has-a instance of.

### Player

The Player class has-a BlackjackHand and only a few methods.

dealCardToPlayer(dealer.sendCard) - Adds a card to players BlackjackHand.

showHand() - Uses a foreach loop to display cards in the players hand.

### Card

The Card class defines what a Card is using enums Suit and Rank.

### Deck

The Deck class has-a List<Card>.

createDeck() - uses a foreach with a nested foreach to loop through each of the Suits and Ranks to create a deck of 52 cards with every combination.

checkDeckSize() - This method returns deck.size() to show how many cards are currently still in the deck.

dealCard() - Removes a card from the deck. This method is used by the dealer to add cards to players hands.

shuffleDeck() - Uses Collections.shuffle(deck) to shuffle the cards.

### BlackjackHand

The class BlackjackHand is the blackjack games subclass of abstract Hand.

isBlackJack() - checks with getHandValue() if the current hand value is 21 at the beginning of the turn. If getHandValue() == 21, that hand returns true for isBlackJack and the owner of that hand wins the round.

isBust() - Similar to isBlackJack, but checks if getHandValue() > than 21 after a hit. If isBust returns true the owner of the hand looses the round.

## BlackjackTable

BlackjackTable is the class where all of the blackjack classes come together to create the game.

launch(Scanner kb, Dealer dealer) - Each of the turn methods return a boolean, true if a winner has been found and false to initiate the next turn.

newGame(Scanner kb, Dealer dealer - newGame Begins by clearing the Pot, shuffling the deck, and clearing the dealers hand. The user is then asked how much they would like to bet. The dealer then gives two cards to each player, checks for isBlackJack, and shows the appropriate cards.

playerTurn(Scanner kb, Dealer dealer) - The user is asked for an action, hit or stay. If the user hits, isBust is checked. If user stays, dealer turn is initiated.

dealerTurn(Dealer dealer) - In dealerTurn, dealers getHandValue is checked. If getHandValue is less than 17, the dealer must hit. Otherwise, the dealer stays. isBust is checked each time the dealer hits.

winCon(Dealer dealer) - this method is only called if no player has initiated isBust or isBlackJack. winCon checks who's handValue is greater, then declares the winner.

playerBet(int bet, Dealer dealer) - This method contains a switch after asking the user how much they would like to bet. The switch then calls the appropriate case to call dealer.pot.playerBet(int bet).
