package scrimish;
import java.util.Scanner;

public class HumanPlayer extends Player{
	
	Scanner input = new Scanner(System.in); 

	HumanPlayer(){
		Card thiscard;
		char cardname;
		int cardnum;
		int pilenum = 0;
		
		System.out.println("\n\nPlease enter the pile number to place the Crown: (1-5)");
	
		
			while(!input.hasNextInt()){
				
				System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
				input.next();
			}
			pilenum = input.nextInt();
		
			while(pilenum <= 0 || pilenum > 5){
				System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
				while(!input.hasNextInt()){
					
					System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
					input.next();
				}
				pilenum = input.nextInt();
			}
			
		numcardsperrank[8]--;
		getPileFromNumber(pilenum).add(new Card(9));
			
	
		while(pile1.size()<5||pile2.size()<5||pile3.size()<5||pile4.size()<5||pile5.size()<5){ //while all the piles have less than 5 cards
			
			printPiles();
			printCurrentCards();
			
			System.out.println("Please choose a card to place into a pile: ");
			cardname = input.next().charAt(0); //player inputs 1-7 or A or S
			while (cardname!='1'&&cardname!='2'&&cardname!='3'&&cardname!='4'&&cardname!='5'&&cardname!='6'&&cardname!='A'&&cardname!='S'&&cardname!='C'){
				System.out.println("Invalid card type. Please choose a valid card from 1-6, A, or S");
				cardname = input.next().charAt(0); //player inputs 1-6 or A or S
				
			}
			cardnum = getCardNum(cardname); //converts the character of the card name to the card number 
			
			while(numcardsperrank[cardnum-1]==0){
				
				System.out.println("You have no more of those cards. \nPlease choose a different card to place into a pile: ");
				cardname = input.next().charAt(0); //player inputs 1-6 or A or S
				
				while (cardname!='1'&&cardname!='2'&&cardname!='3'&&cardname!='4'&&cardname!='5'&&cardname!='6'&&cardname!='A'&&cardname!='S'&&cardname!='C'){
					System.out.println("Invalid card type. Please choose a valid card from 1-6, A, or S");
					cardname = input.next().charAt(0); //player inputs 1-6 or A or S
					
				}
				cardnum = getCardNum(cardname); //converts the character of the card name to the card number 	
				//System.out.print(cardnum);
			}
			
			thiscard = new Card(cardnum); //makes a new card of the card number
			numcardsperrank[cardnum-1]--; //subtracts 1 from the card pile, of the right type
			
			System.out.println("Please enter the pile number to place the " + thiscard.getNameAsString()); //asks user to input the pile number to place the newly made card in 
			pilenum = input.nextInt(); //takes the inputed integer and stores it as the pile number
			
			while(getPileFromNumber(pilenum).getTotalCards()>=5){//check number of cards in pile
					//if the number of cards in the pile is 5, then output an error message and ask for a new pile number. 
				System.out.println("That pile is already filled. \nPlease enter a different pile number to place the " + thiscard.getNameAsString()); //asks user to input the pile number to place the newly made card in 
				pilenum = input.nextInt(); //takes the inputed integer and stores it as the pile number
			}
			
			
			getPileFromNumber(pilenum).add(thiscard); //adds the card to the pile since the pile is getPileFromNumber(pilenum) and adds the card we just created. 
			
		}
			
			
				
			
		}
	
	
		
	}

