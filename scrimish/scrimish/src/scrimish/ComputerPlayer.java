package scrimish;

public class ComputerPlayer extends Player{

	ComputerPlayer(){
		Card thiscard;
		
		int cardnum;
		//System.out.println("\n\nPlease enter the pile number to place the Crown: (1-5)");
		int pilenum = 1 + (int)(Math.random()*5);
		/*while(pilenum < 0 || pilenum > 5){
			System.out.println("Please enter the pile number to place the Crown: (1-5)");
			pilenum = input.nextInt();
		}*/
		numcardsperrank[8]--;
		getPileFromNumber(pilenum).add(new Card(9));
			
	
		while(pile1.size()<5||pile2.size()<5||pile3.size()<5||pile4.size()<5||pile5.size()<5){ //while all the piles have less than 5 cards
			
			//printPiles();
			//printCurrentCards();
			
			//System.out.println("Please choose a card to place into a pile: ");
			
			cardnum = 1 + (int)(Math.random()*9);//converts the character of the card name to the card number 
			
			while(numcardsperrank[cardnum-1]==0){
				//printCurrentCards();
				//System.out.println("You have no more of those cards. \nPlease choose a different card to place into a pile: ");	
				cardnum = 1 + (int)(Math.random()*9); //converts the character of the card name to the card number 	
			}
			
			thiscard = new Card(cardnum); //makes a new card of the card number
			numcardsperrank[cardnum-1]--; //subtracts 1 from the card pile, of the right type
			
			//System.out.println("Please enter the pile number to place the " + thiscard.getNameAsString()); //asks user to input the pile number to place the newly made card in 
			pilenum =  1 + (int)(Math.random()*5); //takes the inputed integer and stores it as the pile number
			
			while(getPileFromNumber(pilenum).getTotalCards()>=5){//check number of cards in pile
					//if the number of cards in the pile is 5, then output an error message and ask for a new pile number. 
				//System.out.println("That pile is already filled. \nPlease enter a different pile number to place the " + thiscard.getNameAsString()); //asks user to input the pile number to place the newly made card in 
				pilenum = 1 + (int)(Math.random()*5); //takes the inputed integer and stores it as the pile number
			}
			
			
			getPileFromNumber(pilenum).add(thiscard); //adds the card to the pile since the pile is getPileFromNumber(pilenum) and adds the card we just created. 
			
		}
			
		//System.out.print("Computer Piles");	
		//printPiles();			
			
		}
	}

