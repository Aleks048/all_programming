#include <random>

#ifndef DICE
#define DICE

#include "ScoreSheet.h"

//to get a random dice
struct RandomDice
{
    //methods
    static int getRandomFace();
};

//to represent divces
struct Dice
{
    //data
    const ScoreSheet::Color c; 
    int face;
 
    //constructors
    Dice(ScoreSheet::Color);

    //methods
    void roll();
};


//collection of dices
struct RollOfDice
{
    //data
    vector<Dice> dices;

    //constructors
    RollOfDice(); //!!WARNING!!might use two diffrent construct if needed to work with both games
    
    //methods
    void roll();
    RollOfDice pair(int, int);
    operator int();
};

string colToStr(ScoreSheet::Color);
ostream &operator<<(ostream &, const RollOfDice &);
ostream &operator<<(ostream &, const Dice &);

#endif //DICE