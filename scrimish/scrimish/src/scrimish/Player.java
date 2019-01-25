package scrimish;




public abstract class Player {
	
	
	StartingDeck startdeck = new StartingDeck();
	
	int[] numcardsperrank = { 5,5,3,3,2,2,2,2,1 };
	
	Pile pile1 = new Pile();
	Pile pile2 = new Pile();
	Pile pile3 = new Pile();
	Pile pile4 = new Pile();
	Pile pile5 = new Pile();

	
	public Pile getPileFromNumber(int pilenum){
		switch(pilenum){
		case 1: return pile1;
		case 2: return pile2;
		case 3: return pile3;
		case 4: return pile4;
		default:return pile5; 
		}
	}
	
	public int getCardNum(char c){
		switch(c){
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4; 
		case '5': return 5;
		case '6': return 6;
		case 'A': return 7;
		case 'S': return 8;
		case 'C': return 9; 
		default: return 10;
		}
	}
	
	public void printCurrentCards(){ //Prints the current cards available from array
		Card thiscard;
		for(int i=0;i<9;i++){
			thiscard = new Card(i+1);
			System.out.print("You have " + numcardsperrank[i] + " " + thiscard.getNameAsString() + " Cards.\n");
		}
	}
	public void printPiles(){		//Prints the cards in the piles
		System.out.println("\nPile1: " + pile1.toString()+ "\nPile2: " + pile2.toString()+ "\nPile3: " + pile3.toString()+ "\nPile4: " + pile4.toString()+ "\nPile5: " + pile5.toString()+ "\n"); 
	}
	
	
	
}

