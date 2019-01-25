#ifndef CITY_H
#define CITY_H

#include<string>
#include<iostream>
using namespace std;

class City {

private:
	int id, ownerId;
	double value, charge;
	int xCoord, yCoord;
	string cityName, owner;
	//vector<City>city;

// Constructors
public:
	City();
	City(int idN, string ncityName, double nValue, int x, int y);
    int getId();
    int getOwnerId();
    double getValue();
    double getCharge();
    int getXcoord();
    int getYcoord();
    string getCityName();
    string getOwner();
    string* getCity();
    string getNextCity();
    void setId(int);
    void setOwnerId(int);
    void setValue(int);
    void setCharge(int);
    void setXcoord(double);
    void setYcoord(double);
    void setCityName(string);
    void setOwner(string);
    //void setCity(City*);


    void printCity();

};

#endif

