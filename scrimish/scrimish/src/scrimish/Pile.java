package scrimish;

import java.util.ArrayList;

public class Pile {

	private ArrayList<Card> cards;
	
	Pile(){
		cards = new ArrayList<Card>();
		
	}
	
	public Card remove(int thecard){
		return cards.remove(thecard);
	}
	
	public int getTotalCards(){
		return cards.size();
	}
	
	public String printDeck(){
		
		return cards.toString();
	}
		
	public void add(Card card) {
		cards.add(card);
	}
	
	public String toString(){	
			return cards.toString();
		}

	
	public Card get(int i){
		return cards.get(i);
	}
	public String revealTopCard(){
		return cards.get(cards.size()-1).toString();
			//	 human.pile1.get(human.pile1.size()-1).toString();
	}
	public Card topCard(){
		return cards.get(cards.size()-1);
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return cards.size();
	}
}
