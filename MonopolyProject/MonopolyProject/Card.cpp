#include "Card.h"
#include<cctype>
#include<string>
#include<iostream>
using namespace std;

// Constructors
Card::Card():rank(2), suit('S'){
}
Card::Card(char ch, int i): rank(i){
	suit = toupper(ch);
}

// Accessor Methods
int Card::getRank() const {
	return rank;
}

char Card::getSuit() const {
	return suit;
}

void Card::displayCard(ostream& out) const {
	string suitString;
	switch(suit){
	case 'S':
		suitString = "Spades";
		break;
	case 'H':
		suitString = "Hearts";
		break;
	case 'D':
		suitString = "Diamonds";
		break;
	case 'C':
		suitString = "Clubs";
		break;
	default:
		suitString = "Invalid Suit";
	}

	if(rank >= 2 && rank < 11){
		out << rank << " of " << suitString;
	}

	else {
		switch(rank){
			case 11:
				out << "JACK of " << suitString;
				break;
			case 12:
				out << "QUEEN of " << suitString;
				break;
			case 13:
				out << "KING of " << suitString;
				break;
			case 14:
				out << "ACE of " << suitString;
				break;
		}
	}
	return;
}



