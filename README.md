##### Week 4 Homework Project for Skill Distillery

#### Overview

Blackjack is a text based blackjack game. To explain how it was built, I will give a short rundown of each class and how they play a part.

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



### Player

### Card

### Deck

### BlackjackHand

## BlackjackTable
