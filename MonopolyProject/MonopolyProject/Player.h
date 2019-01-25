#ifndef PLAYER_H;
#define PLAYER_H
#include<iostream>
#include<vector>
using namespace std;

class Player {

private:
	string name;
	int playerId;
	double money;
    vector<int>cityOwned;
	int cityX, cityY, cityId;
public:
// Constructor
	Player();
	Player(string n, double m, int nplayerID);

// Accessors
string getName();
int getPlayerId();
double getMoney();
vector<int> getCityOwned();
int getCityX();
int getCityY();
int getCityId();

// Mutators
void setName(string);
void setPlayerId(int);
void setMoney(double);
void setCityOwned(int);
void setCityX(int);
void setCityY(int);
void setCityId(int);
// Method
	void loseMoney(double m);
	void gainMoney(double m);
	void addCity(int cId);
	//City* move(int step, vector<City>cityset);
	void printPlayer();
};
#endif
