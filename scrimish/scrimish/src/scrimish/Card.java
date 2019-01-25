package scrimish;

public class Card {//Card class
	
	//public final static String[] names = { "Dagger", "Sword", "Morning Star", "War Axe", "Halberd", "Longsword","Archer","Shield","Crown"};
	public final static int DAGGER = 1;
	public final static int SWORD = 2;
	public final static int MS = 3;
	public final static int WA = 4;
	public final static int HALBERD = 5;
	public final static int LONGSWORD = 6;
	public final static int ARCHER = 7;
	public final static int SHIELD = 8;
	public final static int CROWN = 9;
	
	private int name; 
	
	public Card(int cardName){
		name = cardName;
	}
	
	public int getName(){
		return name;
	}
	
	
	

	
	public String getNameAsString(){
		switch(name){
		case DAGGER: return "Dagger";
		case SWORD: return "Sword";
		case MS : return "Morning Star";
		case WA: return "War Axe";
		case HALBERD : return "Halberd";
		case LONGSWORD: return "Longsword";
		case ARCHER: return "Archer";
		case SHIELD: return "Shield";
		default: return "Crown";
		}
	}
	public String toString(){
		return getNameAsString();
	}
	
}
