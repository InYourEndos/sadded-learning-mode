#ifndef CARD_H
#define CARD_H

#include<iostream>
using namespace std;

class Card {

// Constructors
public:
	Card();
	char suit;
	int rank;
	Card(char suit, int rank);

// Accessor Methods
	int getRank() const;
	char getSuit() const;

void displayCard(ostream & outStream) const;

};

#endif

