#include "Dices.h"
#include <iostream>
#include <cstdlib>
#include <vector>

using namespace std;
//Dice 

//constructors
Dice::Dice(const Dice& from):
colour(from.colour),
value(from.value)
{}

Dice::Dice(Colour colourIn):
colour(colourIn)
{
    this->roll();
}

//rest
void Dice::roll(){
    int r = rand()%6+1;
    this->value= r;
}

int Dice::getValue()const{
    return value;
};

ostream& operator<<(ostream& stream,const Dice& dice){//want dice to be const!!
    dice.getValue();
    stream<<4;
    return stream;
};


int main (){
    Dice d{Colour:RED};
    Dice b{d};
   cout<< d.getValue();
    cout<<"hi";
    return 0;
}


//Roll Of Dices

//constructors
    RollOfDice::RollOfDice(const RollOfDice& from){
        for(auto t:from.rollOfDice){
            rollOfDice.push_back(t);
        }
    }

    RollOfDice::RollOfDice(int numOfDices,vector<Colour> colours){
        for (int i=0;i<numOfDices;i++){
            this->add(Dice{colours.back()});
            colours.pop_back();
        }
    }
    
    RollOfDice::RollOfDice(int i){
        int accumulator;
        for (auto d:*this){
           accumulator+= d.getValue();
        }
    }
//rest
void RollOfDice::roll(){
    for (auto d:*this){
        d.roll();
    }
}
void RollOfDice::add(Dice dice){
    this->rollOfDice.push_back(dice);
}
std::vector<Dice> RollOfDice::getDicesRolled(){
    return this->rollOfDice;
}



ostream& operator<<(ostream& stream,const RollOfDice& rOd){
    RollOfDice temp {rOd};
    for (auto &d:temp){
        stream<<d;
    }
};


