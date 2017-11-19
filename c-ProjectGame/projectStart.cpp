#include <iostream>

int main(){
    std::cout<<"Hi there";
    return 0;
}


/*

class Player{
    bool isActive;
    virtual void inputBeforeRoll(RollOfDice&)=0;
    virtual void inputAfterRoll(RollOfDice&)=0;
}

class QuintoPlayer: private Player{
    void inputBeforeRoll(RollOfDice&);
    void inputAfterRoll(RollOfDice&);
}

class QuinxxPlayer: private Player{
    void inputBeforeRoll(RollOfDice&);
    void inputAfterRoll(RollOfDice&);
}


ostream& operator<<(ScoreSheet&);
ostream& operator<<(QuintoScoreSheet&);
ostream& operator<<(QwixxScoreSheet&);
//ostream& operator<<(QuintoRow&);
//ostream& operator<<(QuixxRow&);
*/