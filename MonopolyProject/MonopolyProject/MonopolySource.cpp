#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include "Card.h"
#include "CardDeck.h"
#include "City.h"
#include "Player.h"
#include <time.h> //needed for srand

const int r=5;
const int c=5;
void printBoard(int dice1,int dice2,int dice3,int dice4){ //print board 
	int n[5][5];
	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
		    if(i==0&&j==0)
							n[i][j]=1;
			else if(i==0 &&j==1)
							n[i][j]=2;
			else if(i==0&&j==2)
							n[i][j]=3;
			else if(i==0&&j==3)
							n[i][j]=4;
			else if(i==0&&j==4)
							n[i][j]=5;
			else if(i==1&&j==4)
						n[i][j]=6;
			else if(i==2&&j==4)
							n[i][j]=7;
			else if(i==3&&j==4)
							n[i][j]=8;
			else if(i==4&&j==4)
							n[i][j]=9;
			else if(i==4&&j==3)
							n[i][j]=10;
			else if(i==4&&j==2)
							n[i][j]=11;
			else if(i==4&&j==1)
							n[i][j]=12;
			else if(i==4&&j==0)
							n[i][j]=13;
			else if(i==3&&j==0)
							n[i][j]=14;
			else if(i==2&&j==0)
							n[i][j]=15;
			else if(i==1&&j==0)
							n[i][j]=16;
			else
				n[i][j]=0;

		}
	}
	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){

			if(dice1%16==n[i][j]-1) //user (player 1)
				cout<<"r ";
			else if(dice2%16==n[i][j]-1) //computer 1 (player 2)
				cout<<"2 ";
			else if(dice3%16==n[i][j]-1) //computer 2 (player 3)
				cout<<"3 ";
			else if(dice4%16==n[i][j]-1) //computer 3 (player 4)
				cout<<"4 ";
			else if(n[i][j]!=0)
								cout<<"*"<<" "; //non-occupied spaces
			else
				cout<<"  ";
           if(j==4)
        	   cout<<endl;
		}
	}
}
bool checkGoodCity(int a){ //If city id is 2,6,10,14, then it is a good city
	if(a==2||a==6||a==10||a==14)
		return true;
	else 
		return false;
}
bool checkBadCity(int a){ //If city id is 3,7,11,15 then it is a bad city
	if(a==3||a==7||a==11||a==15)
		return true;
	else
		return false;
}
bool checkOwnedBySelf(Player p,int cId){ //Checks if city is owned by self
	for(int i=0;i<p.getCityOwned().size();i++){
		if(p.getCityOwned()[i]==cId) //If any of the player's city ids = cID then
			return false;//the city is already owned by self
	}
	return true;
}

void result(vector<Player> player){ //Result function

	 for(int i=0;i<4;i++){ // Outputs all players IDs, Names, Positions, Money at the end of the game
            cout<<"Player ID "<<player[i].getPlayerId();
			cout<<endl;
	        cout<<"Player name "<<player[i].getName();
		    cout<<endl;
		    cout<<"Player position=("<<player[i].getCityX()<<","<<player[i].getCityY()<<")";
			cout<<endl;
			cout<<"Player "<<i+1<<" balance :"<<player[i].getMoney();
					cout<<endl;

	 }
	 //Outputs winner.
	 if(player[0].getMoney()>=player[1].getMoney()&&player[0].getMoney()>=player[2].getMoney()
	    		 &&player[0].getMoney()>=player[3].getMoney()){
         cout<<" Player 1 wins"<<endl;
	 }
	 if(player[1].getMoney()>=player[0].getMoney()&&player[1].getMoney()>=player[2].getMoney()
	         		 &&player[1].getMoney()>=player[3].getMoney()){
	    cout<<" Player 2 wins"<<endl;
	 }
	 if(player[2].getMoney()>=player[0].getMoney()&&player[2].getMoney()>=player[1].getMoney()
	         		 &&player[2].getMoney()>=player[3].getMoney()){
	    cout<<" Player 3 wins"<<endl;
	 }
	 if(player[3].getMoney()>=player[0].getMoney()&&player[3].getMoney()>=player[1].getMoney()
	         		 &&player[3].getMoney()>=player[2].getMoney()){
	    cout<<" Player 4 wins"<<endl;
     }
}

void inputData(vector<Player> &p,vector<City> &c){ //inputs the two files player.txt and city.txt
	string name;
	int id,id2,id3;
	double money;
	ifstream fin1("player.txt"); //opens player.txt
	ifstream fin2("city.txt"); //opens city.txt
	Player a; //a initialized to class Player
	City b; //b initialized to class City
	int i=0;
	if(fin1.fail()){
			cerr << "Error opening input file player.txt\n";
			exit(1);
	}
	if(fin2.fail()){ //if it fails to open then output following 
			cerr << "Error opening input file city.txt\n";
			exit(1);
	}
	fin1>>name>>name>>name; //fin reads in id name money from player.txt
	fin2>>name>>name>>name>>name>>name>>name>>name; //fin reads in number city value position x position y from city.txt
	i=0;
	while(i<4){ //sets id name money for each player
		fin1>>id;
		fin1>>name;
		fin1>>money;
		a.setName(name);
		a.setMoney(money);
		a.setPlayerId(id);
		p[i]=a;
		i++;
	}
	fin1.close(); //closes player.txt
	i=0;
	while(i<16){ //sets number,city,value,positionx and y for each city
		fin2>>id;
		fin2>>name;
		fin2>>money;
		fin2>>id2;
		fin2>>id3;
		b.setId(id);
		b.setCityName(name);
		b.setValue(money);
		b.setXcoord(id2);
		b.setYcoord(id3);
		c[i]=b;
		i++;
	}
	fin2.close(); //closes city.txt
}
int main(){
	int turns;
	vector<Player> player(4);
	vector<City> city(16);
    inputData(player,city); //inputs the player and city txt file
	// Prompt User for the Number of Turns
		cout << "Please enter the number of turns: ";
				cin >> turns;  
     int d1,d2,dice,cId=0,pId,turn=1;
     char y;//for asking if the player want to buy the city
     int dice1=0,dice2=0,dice3=0,dice4=0;
     srand( time(NULL) );
	 cout<< "This is our starting game board." << endl;
     printBoard(dice1,dice2,dice3,dice4);//print the board
     cout<<"Press Enter to Continue."<<endl;
	 getchar();
     for(int i=0;i<turns*4;i++){//turns
    	 getchar();
		 if(i%4==0){//next turns
    		 cout<<"Turn "<<turn<<endl;
    	     turn++;
    	     cout<<"Player's turn:"<<endl;
    	 }
		 if(i%4==1)//computer turns
    		cout<<"Computers' turns:"<<endl;
		d1=rand()%6+1; //rolls dice 1
		d2=rand()%6+1; //rolls dice 2
		dice=d1+d2; //sum of dice
		pId=i%4;//player[0] represents the user
		cout<<"Player "<<pId+1<<endl;
		if(pId==0){
			dice1+=dice; 
			cId=dice1%16;
		}
		if(pId==1){
			dice2+=dice;
			cId=dice2%16;
        }
		if(pId==2){
			dice3+=dice;
			cId=dice3%16;
		}
		if(pId==3){
			dice4+=dice;
			cId=dice4%16; //City ID
		}
		cout <<"Dice result:"<<dice<<endl;
		printBoard(dice1,dice2,dice3,dice4);
		//If landed on a bad city, you lose 500$ :(
		if(checkBadCity(cId+1)){
			player[pId].loseMoney(500);//lose 500 because of bad city
			cout<<"Player "<<pId+1<<" landed on a bad city. They lose $500."<<endl;
			cout<<"Player "<<pId+1<<" balance:"<<player[pId].getMoney();
			cout<<endl;
		}
		//If landed on a good city, you get to play mini card game!
		if(checkGoodCity(cId+1)){
			cout<<"Player landed on a good city: "<<endl;
			cout<<"Player gets to play Mini card game:"<<endl;
			CardDeck theDeck;
			Card card1,card2;
			srand(time(0));
			theDeck.shuffleDeck();
			card1=theDeck.draw();
			theDeck.shuffleDeck();
			card2=theDeck.draw();
			cout<<"The Player draws two cards. The cards are a ";
			card1.displayCard(cout);
			cout<<" and a ";
			card2.displayCard(cout);
			cout<<endl;
			if(card1.getSuit()!=card2.getSuit()){
                double m=100*(card1.getRank()+card2.getRank());
                player[pId].gainMoney(m);
                cout<<"The cards are different colors, player"<<pId+1<<" gain "<<m<<endl;
                cout<<"Player "<<pId+1<<" now has a balance of "<<player[pId].getMoney();
                cout<<endl;
            }
			else{
				cout<<"The cards are the same color. No money is gained."<<endl;
			}
		}
			//city not owned
			if(city[cId].getOwnerId()==0 ){//city not owned
    			if(pId==0&&player[pId].getMoney()>city[cId].getValue()){//aske the user if he/she wants to buy the
    			//city,and they have enough money to buy the city
    			cout<<"The city does not have an owner."<<endl;
    			cout<<"Do you want to buy the city? Press y for yes, and any other key for no."<<endl;
				cin>>y;
					if(y=='y'){//want to buy the city
            			player[pId].setMoney(player[pId].getMoney()-city[cId].getValue());
            			player[pId].addCity(cId);
            			player[pId].setCityX(cId);
            			player[pId].setCityY(cId);
            			city[cId].setOwner(player[pId].getName());
            			city[cId].setOwnerId(player[pId].getPlayerId());

            			// cout<<"Player ID "<<player[pId].getPlayerId();
            			//cout<<endl;
            			//cout<<"Player name "<<player[pId].getName();
            			//cout<<endl;
            			//cout<<"Player position=("<<city[cId].getXcoord()<<","<<city[cId].getYcoord()<<")";
            			//cout<<endl;
            			//cout<<"City ID:"<<cId+1<<endl; 
						
            			cout<<"Player "<<pId+1<<" pays "<<city[cId].getValue()<<" to buy city"<<cId+1;
            			cout<<endl;
            			cout<<"Player "<<pId+1<<" balance "<<player[pId].getMoney();
            			cout<<endl;
						getchar();
						cout<<"Press Enter to Continue."<<endl;
					}
    			}
    		else{
			//If computer player has enough money to buy the city, 
			//then there is 50% chance that they will buy.
    			if(player[pId].getMoney()>city[cId].getValue()){
    				srand( time(0) );
    				int x=rand()%2;
    				if(x==1){//The computer buys the city
    					player[pId].setMoney(player[pId].getMoney()-city[cId].getValue());
    		            player[pId].addCity(cId);
    		            player[pId].setCityX(cId);
    		            player[pId].setCityY(cId);
    		            city[cId].setOwner(player[pId].getName());
    		            city[cId].setOwnerId(player[pId].getPlayerId());
    		            //cout<<"Player ID "<<player[pId].getPlayerId();
    		            //cout<<endl;
    		            //cout<<"Player name "<<player[pId].getName();
    		            //cout<<endl;
    		            //cout<<"Player position=("<<city[cId].getXcoord()<<","<<city[cId].getYcoord()<<")";
    		            //cout<<endl;
    		            //cout<<"City ID: "<<cId+1<<endl;
    		            cout<<"Player"<<pId+1<<" pays "<<city[cId].getValue()<<" to buy city"<<cId+1;
    		            cout<<endl;
    		            cout<<"Player"<<pId+1<<" balance "<<player[pId].getMoney();
    		            cout<<endl;
    				}
    				else{ //Computer does not buy city
    					cout<<"Player "<<pId+1<<" decides not to buy city"<<cId+1<<endl;
    					//cout<<"Player ID "<<player[pId].getPlayerId();
    		    		//cout<<endl;
    		    		//cout<<"Player name "<<player[pId].getName();
    		    		//cout<<endl;
    		    		//cout<<"Player position=("<<city[cId].getXcoord()<<","<<city[cId].getYcoord()<<")";
    		    		//cout<<endl;
    		    		//cout<<"City ID: "<<cId<<endl;
    		    		cout<<"Player"<<pId+1<<" balance "<<player[pId].getMoney();
    		    		cout<<endl;
    				}
				}
    		}
		}
		else{//city already owned
			if(checkOwnedBySelf(player[pId],cId)){//not owned by the player self
    		// player[pId].addCity(cId);
    	     	player[pId].setCityX(cId);
    	     	player[pId].setCityY(cId);
    	     	player[pId].loseMoney(city[cId].getValue()/5);
    	     	player[city[cId].getOwnerId()].gainMoney(city[cId].getValue()/5);

    	     	//city[cId].setOwner(player[pId].getName());
    	     	//city[cId].setOwnerId(player[pId].getPlayerId());
    	     	cout<<"Player"<<pId+1<<" land on city"<<cId+1;
    	     	cout<<" which is owned by "<<city[cId].getOwner();
    	     	cout<<endl;
    	     	cout<<"Player "<<city[cId].getOwnerId()<<" gains "<<city[cId].getValue()/5;
    	     		    	     	cout<<endl;
    	     	cout<<"Player "<<pId+1<<" loses "<<city[cId].getValue()/5;
    	     	cout<<endl;
    	     	cout<<"Player "<<pId+1<<" balance "<<player[pId].getMoney();
    	     	cout<<endl;
			}
			
		}
		if(pId!=0){
		cout<<"Press Enter to Continue."<<endl; //Prompts user to press enter to continue
		}
		if(pId==3){
			getchar();
		}
	}
	result(player); //Displays results
	return 0;
}