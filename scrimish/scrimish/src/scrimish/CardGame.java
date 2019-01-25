package scrimish;

import java.util.Scanner;

public class CardGame {
	
	public static int turn = 0; 
	public static Player ai ; 
	public static Player human ;
	public static int pilenum;
	public static int oppilenum;
	public static int winner = 0;
	public static int action;
	public static String topcard; 
	public static String optopcard; 
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Scrimish, a strategy card game.\nYou will be facing an AI.\n\nWould you like to read the rules? \nInput 0 for No and 1 for Yes. "); 
		if(input.nextInt()==1){
		System.out.printf("Both players have a set of cards composed of the following cards and numbers: \n" + 
		"#1 Dagger Cards (x5 per player)\n"+
		"#2 Sword Cards (x5 per player)\n"+
		"#3 Morning Star Cards (x3 per player)\n"+
		"#4 War Axe Cards (x3 per player)\n"+
		"#5 Halberd Cards (x2 per player)\n"+
		"#6 Longsword Cards (x2 per player)\n"+
		"'A' Archer Cards (x2 per player)\n"+
		"'S' Shield Cards (x2 per player)\n"+
		"'C' Crown Card (x1 per player)\n\n" +
		"Setup: The user player places 5 Piles of 5 Cards each face down in front of him.\n"
		+ "The Crown Card should be hidden on the bottom of one of the 5 Piles. The\n"
		+ "rest of the Cards may be arranged however you like. The computer does the\n"
		+ "same thing: the crown card is placed on the bottom of a random pile, while\n"
		+ "the rest of the card are distributed into 5 piles (such that we have 5 cards\n"
		+ "in each pile).\n\n" +
		"Game Play: The players take turns attacking (starting with the user first) by selecting\n"
		+ "the top card from one of their piles and laying that card face up in front of one of their\n"
		+ "opponent's piles. The defending player must then reveal the top card of the pile that was\n"
		+ "attacked. The card with the lowest number value loses and is discarded. The winning card must\n"
		+ "be returned face down to the top of the original pile it was drawn from. If the two cards have\n"
		+ "the same number value, both cards are discarded. The play continues until one of the players\n"
		+ "attacks their opponent's Crown Card, winning the game.\n" +
		"\nArcher Card: If you attack with an Archer Card, it always wins. If your Archer Card is attacked, it always loses.\n" +
		"Shield Card: Shield Cards cannot be used to attack. If your Shield Card is attacked, both your Shield Card and your\n" + 
		"opponent's attacking Card are discarded (except for Archer Cards: If a Shield Card is attacked by an Archer Card, \n"
		+ "neither Card is discarded, and both are returned face down to their original Piles).\n" + 
		"Crown Card: You can attack with your Crown Card. If you attack your opponent's Crown Card, you win. Otherwise, you lose the game.\n" +
		"Instead of attacking, you may intentionally discard one Card on your turn. You do not have to reveal that Card to your opponent.\n" + 
		"You cannot intentionally discard your Crown Card.\n");
		}
		
		System.out.print("\nTurn on God mode? 0 for No, 1 for Yes\n");
		int godMode = input.nextInt(); 
		
		ai = new ComputerPlayer(); 
		human = new HumanPlayer();
		
		while(winner == 0){
			while(turn%2==0){
				//human player turn
				if(godMode==1){
					System.out.println("Computer Piles:");
					ai.printPiles();
					System.out.println("Human Piles:");
					human.printPiles();
				}
				System.out.println("--------Player Turn----------");
				System.out.println("\n(1) View top card of pile\n(2) Discard top card of pile\n(3) Attack with top card of pile");
				while(!input.hasNextInt()){
					System.out.println("Invalid action number. \nPlease enter only a number between 1 and 3.\n");
					action = input.nextInt();
				}
				action = input.nextInt();
				if(action==1){
					System.out.println("You have selected to view the top card of a pile. \nPlease input the pile number.");
				
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						input.next();
					}
					
					pilenum = input.nextInt();
				
					while(pilenum <= 0 || pilenum > 5){
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						pilenum = input.nextInt();
					}
					while(human.getPileFromNumber(pilenum).size()==0){ 
						System.out.println("There are no more cards in that pile. \nPlease select another pile.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						
						pilenum = input.nextInt();
					
						while(pilenum <= 0 || pilenum > 5){
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								input.next();
							}
							pilenum = input.nextInt();
						}
					}
					
					topcard = human.getPileFromNumber(pilenum).revealTopCard();
					
					//String topcard = human.pile1.get(human.pile1.size()-1).toString();
					System.out.print("The top card of pile " + pilenum + " is " + topcard);
				}
				
				
				
				
				else if(action==2){
					System.out.println("You have selected to discard the top card of a pile. \nPlease input the pile number:");
					
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						input.next();
					}
					
					pilenum = input.nextInt();
				
					while(pilenum <= 0 || pilenum > 5){
						System.out.println("Invalid pile number.\nPlease enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						pilenum = input.nextInt();
					}
					while(human.getPileFromNumber(pilenum).size()==0){ 
						System.out.println("There are no more cards in that pile. \nPlease select another pile.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						
						pilenum = input.nextInt();
					
						while(pilenum <= 0 || pilenum > 5){
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								input.next();
							}
							pilenum = input.nextInt();
						}
					}
					topcard = human.getPileFromNumber(pilenum).revealTopCard();
					System.out.print("You have discarded " + topcard + " from pile " + pilenum + ".");
					human.getPileFromNumber(pilenum).remove(human.getPileFromNumber(pilenum).size()-1); 
					if(godMode==1){
						System.out.println("Computer Piles:");
						ai.printPiles();
						System.out.println("Human Piles:");
						human.printPiles();
					}
					turn++;
				}
				
				
		
				
				else if(action==3){
					System.out.println("You have selected to attack with the top card of a pile. \nPlease input the pile number.");
					
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						input.next();
					}
					
					pilenum = input.nextInt();
				
					while(pilenum <= 0 || pilenum > 5){
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						pilenum = input.nextInt();
					}
					while(human.getPileFromNumber(pilenum).size()==0){ 
						System.out.println("There are no more cards in that pile. \nPlease select another pile.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						
						pilenum = input.nextInt();
					
						while(pilenum <= 0 || pilenum > 5){
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								input.next();
							}
							pilenum = input.nextInt();
						}
					}
					topcard = human.getPileFromNumber(pilenum).revealTopCard();
					
					while(topcard == "Shield"){
						System.out.println("You cannot attack with shield cards. \nPlease input another pile number.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						
						pilenum = input.nextInt();
					
						while(pilenum <= 0 || pilenum > 5){
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								input.next();
							}
							pilenum = input.nextInt();
						}
						while(human.getPileFromNumber(pilenum).size()==0){ 
							System.out.println("There are no more cards in that pile. \nPlease select another pile.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number.\nPlease enter only a number between 1 and 5.");
								input.next();
							}
							
							pilenum = input.nextInt();
						
							while(pilenum <= 0 || pilenum > 5){
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								while(!input.hasNextInt()){
									
									System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
									input.next();
								}
								pilenum = input.nextInt();
							}
						}
						topcard = human.getPileFromNumber(pilenum).revealTopCard();
					}
					
					System.out.println("You are attacking with " + topcard + " from pile " + pilenum + ".");
					
					
					
					
					System.out.println("Please input the pile you are attacking.");
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number.\nPlease enter only a number between 1 and 5.");
						input.next();
					}
					
					oppilenum = input.nextInt();
				
					while(oppilenum <= 0 || oppilenum > 5){
						System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						oppilenum = input.nextInt();
					}
					while(ai.getPileFromNumber(oppilenum).size()==0){ 
						System.out.println("There are no more cards in that pile. \nPlease select another pile.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							input.next();
						}
						
						oppilenum = input.nextInt();
					
						while(oppilenum <= 0 || oppilenum > 5){
							System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. \nPlease enter only a number between 1 and 5.");
								input.next();
							}
							oppilenum = input.nextInt();
						}
					}
					optopcard = ai.getPileFromNumber(oppilenum).revealTopCard();
					System.out.println("You have attacked " + optopcard + " from pile " + oppilenum + " with your " + topcard + " from pile "+ pilenum +".");
					
					Card tc = human.getPileFromNumber(pilenum).topCard();
					Card oc = ai.getPileFromNumber(oppilenum).topCard();
					compareCards(tc,oc);
					
					turn++;
				}
				else{
				}
				
			}
			while(turn%2!=0){
				System.out.println("--------Computer Turn----------");
				//AI player turn 
				//human player turn
				if(godMode==1){
					System.out.println("Computer Piles:");
					ai.printPiles();
					System.out.println("Human Piles:");
					human.printPiles();
				}
				
					action =  1; 
			
				
				
		
				
				if(action==0){
					//System.out.println("You have selected to discard the top card of a pile. Please input the pile number:");
					
					//while(!input.hasNextInt()){
						
						//System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						//input.next();
					//}
					
					pilenum = 1 + (int)(Math.random()*5); 
					while(ai.getPileFromNumber(pilenum).size()==0){ 
						pilenum = 1 + (int)(Math.random()*5); 
					}
				
					/*while(pilenum <= 0 || pilenum > 5){
						System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
							input.next();
						}
						pilenum = input.nextInt();
					}*/
					
					topcard = ai.getPileFromNumber(pilenum).revealTopCard();
					System.out.print("Your opponent has discarded a card REMOVE NAME" + topcard + " from their pile " + pilenum + ".");
					ai.getPileFromNumber(pilenum).remove(ai.getPileFromNumber(pilenum).size()-1); 
					if(godMode==1){
						System.out.println("Computer Piles:");
						ai.printPiles();
						System.out.println("Human Piles:");
						human.printPiles();
					}
					turn++;
				}
				
				
		
		
				else if(action==1){
					/*System.out.println("You have selected to attack with the top card of a pile. Please input the pile number.");
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						input.next();
					}*/
					
					pilenum = 1 + (int)(Math.random()*5); 
					while(ai.getPileFromNumber(pilenum).size()==0){ 
						pilenum = 1 + (int)(Math.random()*5); 
					}
				
				
					/*while(pilenum <= 0 || pilenum > 5){
						System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
							input.next();
						}
						pilenum = input.nextInt();
					}*/
					topcard = ai.getPileFromNumber(pilenum).revealTopCard();
					
					while(topcard == "Shield"){
						/*System.out.println("You cannot attack with shield cards. Please input another pile number.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
							input.next();
						}*/
						
						pilenum = 1 + (int)(Math.random()*5); 
						while(ai.getPileFromNumber(pilenum).size()==0){ 
							pilenum = 1 + (int)(Math.random()*5); 
						}
					
					
						/*while(pilenum <= 0 || pilenum > 5){
							System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
							while(!input.hasNextInt()){
								
								System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
								input.next();
							}
							pilenum = input.nextInt();
						}*/
						topcard = ai.getPileFromNumber(pilenum).revealTopCard();
					}
					
					
					
					
					
					
					/*System.out.println("Please input the pile you are attacking.");
					while(!input.hasNextInt()){
						
						System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						input.next();
					}
					*/
					oppilenum = 1 + (int)(Math.random()*5); 
					while(ai.getPileFromNumber(oppilenum).size()==0){ 
						pilenum = 1 + (int)(Math.random()*5); 
					}
				
				
					/*while(oppilenum <= 0 || oppilenum > 5){
						System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
						while(!input.hasNextInt()){
							
							System.out.println("Invalid pile number. Please enter only a number between 1 and 5.");
							input.next();
						}
						oppilenum = input.nextInt();
					}*/
					
					optopcard = human.getPileFromNumber(oppilenum).revealTopCard();
					System.out.println("\nYour opponent has attacked your " + optopcard + " from pile " + oppilenum + " with their " + topcard + " from pile "+ pilenum +".");
					
					Card tc = ai.getPileFromNumber(pilenum).topCard();
					Card oc = human.getPileFromNumber(oppilenum).topCard();
					compareCards(tc,oc);
					turn++;
				}
				else{
				}
				
			
			}
		
		
		 
	
	
		
		
 
		}
		input.close();
	}
	
	public static void compareCards(Card attack, Card defend){
		if(attack.getName()==7&&defend.getName()!=8){//if the attacking card is an archer and the defending card is not a shield
			//discard defending card
			System.out.println("The defender's " + optopcard + " has been discarded.\n");
			if(turn%2==0){
				ai.getPileFromNumber(oppilenum).remove(ai.getPileFromNumber(oppilenum).size()-1);//discard defending card
			}
			else{
				human.getPileFromNumber(oppilenum).remove(human.getPileFromNumber(oppilenum).size()-1); //discard defending card
			}
		}
		else if(defend.getName()==7){
			System.out.println("The defender's " + optopcard + " has been discarded.\n");
			ai.getPileFromNumber(oppilenum).remove(ai.getPileFromNumber(oppilenum).size()-1);//discard defender
		}
		else if(attack.getName()==7&&defend.getName()==8){//if the attacking card is an archer and the defending card is a shield
			//nothing happens.
			System.out.print("Tie!");
		}
		else if(defend.getName()==9){ //if the defending card is a crown 
			if(turn%2==0){
				System.out.println("You have won the game.\n");
			}
			else{
				System.out.println("AI wins the game.\n");
			}
			winner = 1; //attacker wins the game
		}
		else if(attack.getName()==9&&defend.getName()!=9){ //if the attacking card is a crown and the defending card is not a crown
			if(turn%2==0){
				System.out.println("AI wins the game.\n");
			}
			else{
				System.out.println("You have won the game.\n");
			}
			winner = 1; //defender wins the game 
		}
		else if(defend.getName()==8&&attack.getName()!=7){ //if the defending card is a shield and the attacking card is not an archer
			System.out.println("The defender's " + optopcard + " has been discarded.");
			System.out.println("The attacker's " + topcard + " has been discarded.\n");
			human.getPileFromNumber(pilenum).remove(human.getPileFromNumber(pilenum).size()-1); //discard attacking card
			ai.getPileFromNumber(oppilenum).remove(ai.getPileFromNumber(oppilenum).size()-1);//discard defending card                  discard both cards
		}
		else if(attack.getName()>defend.getName()&&attack.getName()!=9&&attack.getName()!=7&&defend.getName()!=9&&defend.getName()!=8&&defend.getName()!=7){ 
			//if the attacking card is greater than the defending card AND the attacking card is not C,A AND the defending card is not C,S,A
			//discard defending card 
			System.out.println("The defender's " + optopcard + " has been discarded.\n");
			if(turn%2==0){
				ai.getPileFromNumber(oppilenum).remove(ai.getPileFromNumber(oppilenum).size()-1);//discard defending card
			}
			else{
				human.getPileFromNumber(oppilenum).remove(human.getPileFromNumber(oppilenum).size()-1); //discard defending card
			}
		}
		else if(defend.getName()>attack.getName()&&attack.getName()!=9&&attack.getName()!=7&&defend.getName()!=9&&defend.getName()!=8&&defend.getName()!=7){ 
			//if the defending card is greater than the attacking card && the attacking card is not C,A && the defending card is not C,S,A
				System.out.println("The attacker's " + topcard + " has been discarded.\n");
			if(turn%2==0){
				
				human.getPileFromNumber(pilenum).remove(human.getPileFromNumber(pilenum).size()-1); //discard attacking card
			}
			else{
				
				ai.getPileFromNumber(pilenum).remove(ai.getPileFromNumber(pilenum).size()-1);//discard attacking card
			}
		}
		else if(attack.getName()==defend.getName()){ 
			//if the attacking card and defending card are the same cards AND the attacking card is not an archer AND the attacking card is not a crown 
			System.out.println("The defender's " + optopcard + " has been discarded.");
			System.out.println("The attacker's " + topcard + " has been discarded.\n");
			if(turn%2==0){
				human.getPileFromNumber(pilenum).remove(human.getPileFromNumber(pilenum).size()-1); //discard attacking card
				ai.getPileFromNumber(oppilenum).remove(ai.getPileFromNumber(oppilenum).size()-1);//discard defending card                  discard both cards
			}
			else{
				ai.getPileFromNumber(pilenum).remove(ai.getPileFromNumber(pilenum).size()-1); //discard attacking card
				human.getPileFromNumber(oppilenum).remove(human.getPileFromNumber(oppilenum).size()-1);//discard defending card 
			}
			
			
		}
	}
	
	
}
		
	
	

