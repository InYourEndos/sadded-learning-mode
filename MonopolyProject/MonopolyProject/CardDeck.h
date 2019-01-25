#ifndef CARDDECK_H
#define CARDDECK_H
#include"Card.h"
#include <vector>
#include<iostream>
using namespace std;

class CardDeck {

// Constructors
public:
	CardDeck();
	void shuffleDeck();
	Card draw();
private:
	vector<Card>theDeck;
};

#endif

