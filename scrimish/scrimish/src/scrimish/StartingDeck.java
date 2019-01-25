package scrimish;
import java.util.ArrayList;


public class StartingDeck {
	
	private ArrayList<Card> cards;
	
	StartingDeck(){
		cards = new ArrayList<Card>(25);
		
		
		int[] numcardsperrank = { 5,5,3,3,2,2,2,2,1 };
		for(int j = 0; j<9; j++){
			for(int i = numcardsperrank[j]; i>0;i--){
				cards.add(new Card(j+1)); //add five daggers
			}	
		}
		
	}
	
	public Card allocateToPiles(int thecard){
		return cards.remove(thecard);
	}
	
	public int getTotalCards(){
		return cards.size();
	}
	
	public String toString(){
		return cards.toString();
	}
	
		

	public static void main(String[] args){
		StartingDeck testdeck = new StartingDeck();
		System.out.print(testdeck.toString());
		testdeck.add(new Card('1')); 
		System.out.print(testdeck.toString());
	}

	private void add(Card card) {
		cards.add(card);
		
	}

	public Card get(int i){
		return cards.get(i);
	}
	public void remove(int card) {
		// TODO Auto-generated method stub
		cards.remove(cards.indexOf(card));
	}
	
	public int indexOf(Card card){
		return cards.indexOf(card);
	}
	
	}

		
		
	
