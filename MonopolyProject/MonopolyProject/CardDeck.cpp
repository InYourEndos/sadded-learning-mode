#include "CardDeck.h"
#include"Card.h"
#include<ctime>
#include<algorithm>
using namespace std;

CardDeck::CardDeck(){
	for(int i = 2; i < 15; ++i){
		theDeck.push_back(Card('S' , i));
		theDeck.push_back(Card('H' , i));
		theDeck.push_back(Card('D' , i));
		theDeck.push_back(Card('C' , i));
	}
	srand(time(NULL));
}

Card CardDeck::draw(){
	if(theDeck.empty()){
		exit(1);
	}
	Card aCard = theDeck.back();
	return(aCard);
}

void CardDeck::shuffleDeck(){

	random_shuffle(theDeck.begin(), theDeck.end());
}
