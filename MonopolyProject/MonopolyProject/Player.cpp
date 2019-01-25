
#include "Player.h"
#include<iostream>
#include<string>
#include<vector>
using namespace std;


// Constructor
Player::Player(){
   name="unknown";
   playerId=0;
   money=10000;
   cityX=0;
   cityY=0;
   cityId=0;
}
Player::Player(string n, double m, int nplayerId){
	name=n;
	money=m;
	playerId=nplayerId;

}

// Accessors
string Player::getName(){
	return name;
}
int Player::getPlayerId(){
	return playerId;
}
double Player::getMoney(){
	return money;
}
vector<int> Player::getCityOwned(){

	return cityOwned;
}
int Player::getCityX(){
	return cityX;
}
int Player::getCityY(){
	return cityY;
}
int Player::getCityId(){
	return cityId;
}

// Mutators
void Player::setName(string n){
	name=n;
}
void Player::setPlayerId(int id){
	playerId=id;
}
void Player::setMoney(double m){
	money=m;
}
/*void Player::setCityOwned(int co){
	cityOwned=co;
}*/
void Player::setCityX(int x){
	cityX=x;
}
void Player::setCityY(int y){
	cityY=y;
}
void Player::setCityId(int id){
	cityId=id;
}
// Method
	void Player::loseMoney(double m){
		money-=m;
	}
	void Player::gainMoney(double m){
	money+=m;
	}
	void Player::addCity(int cId){

		cityOwned.push_back(cId);

	}
/*	City* Player::move(int step, vector<City>cityset){



	}*/
	void Player::printPlayer(){
		cout<<"Name:"<<name<<endl;
	    cout<<"player ID:"<<playerId<<endl;
		cout<<"Money:"<<money<<endl;
		cout<<"City owned:";
	/*	for(int i=0;i<cityOwned.size();i++){
			cout<<cityOwned[i]<<" ";
		}*/
		cout<<endl;
		cout<<"Position=("<<cityX<<","<<cityY<<")"<<endl;
		cout<<"City id:"<<cityId<<endl;

	}
