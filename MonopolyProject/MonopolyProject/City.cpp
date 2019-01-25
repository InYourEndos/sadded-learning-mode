
#include "City.h"
#include<iostream>
#include<string>
using namespace std;


	City::City(){
		    ownerId=0;
			owner=" ";

	}
	City::City(int idN, string ncityName, double nValue, int x, int y){
		id=idN;
		cityName=ncityName;
		value=nValue;
		xCoord=x;
		yCoord=y;

	}

    int City::getId(){
    	return id;
    }
    int City::getOwnerId(){
    	return ownerId;
    }
    double City::getValue(){
    	return value;
    }
    double City::getCharge(){
    	return charge;
    }
    int City::getXcoord(){
    	return xCoord;
    }
    int City::getYcoord(){
    	return yCoord;
    }
    string City::getCityName(){
    	return cityName;
    }
    string City::getOwner(){
    	return owner;
    }

   /* string City::getNextCity(){
    	return nextCity;
    }*/
    void City::setId(int i){
    	id=i;
    }
    void City::setOwnerId(int oi){
    	ownerId=oi;
    }
    void City::setValue(int v){
    	value=v;
    }
    void City::setCharge(int c){
    	charge=c;
    }
    void City::setXcoord(double x){
    	xCoord=x;
    }
    void City::setYcoord(double y){
    	yCoord=y;
    }
    void City::setCityName(string cn){
    	cityName=cn;
    }
    void City::setOwner(string o){
    	owner=o;
    }
  /*  void City::setCity(City* c){
    	city=c;
    }
    */


    void City::printCity(){
    	cout<<"City ID:"<<id<<endl;
    	cout<<"owner name:"<<cityName<<endl;
    	cout<<"owner:"<<owner<<endl;
    	cout<<"owner ID:"<<ownerId<<endl;
    	cout<<"value:"<<value<<endl;
    	cout<<"Position=("<<xCoord<<","<<yCoord<<")"<<endl;

    }
