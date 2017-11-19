#include <iostream>
#include <vector>
#include <iterator>

using namespace std;
enum Colour {
    RED,
    YELLOW,
    GREEN,
    WHITE
};

class Dice{
  const Colour colour;
  int value;

public:
    //constructors
    Dice(const Dice& from);
    Dice(Colour colour);

    //rest
    void roll();
    int getValue() const;

    friend ostream& operator<<(ostream& stream, const Dice& dice);

};




class RollOfDice{
    std::vector<Dice> rollOfDice;

public:
    //constructor
    RollOfDice(const RollOfDice& from);
    RollOfDice(int numOfDices, vector<Colour> colours);
    RollOfDice(int i);//convert to int???

    //rest
    void roll();
    void add(Dice dice);
    std::vector<Dice> getDicesRolled();
    //RollOfDice pair();
    
    std::vector<Dice>::iterator begin();
    std::vector<Dice>::iterator end();
   
    friend ostream& operator<<(ostream& stream,const RollOfDice& rOd);
};

inline std::vector<Dice>::iterator RollOfDice::begin(){return rollOfDice.begin();};
inline std::vector<Dice>::iterator RollOfDice::end(){return rollOfDice.end();}