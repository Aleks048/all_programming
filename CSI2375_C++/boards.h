#include <string>

class ScoreSheet {
    Std::String name;
    int numOfFailedAttempts;
    int overallScore;
protected:
    virtual bool validate()=0;//called by score
    virtual void calcTotal(int)=0; //called by setTotal
public:
    //constructors


    //rest
    virtual bool score(RollOfDice rOd,Colour colour,int position=-1);//call protected virtual function????
    virtual int setTotal();
    virtual bool operator!(ScoreSheet& scoreSheet);
    //
    friend virtual ostream& operator<<(ostream& stream,const ScoreSheet& scoreSheet);
}
/*
class QuintoScoreSheet:public ScoreSheet{
    calcTotal(int);
    //three QuintoRows of the desired colour
    friend ostream& operator<<(QuintoScoreSheet&);
}

class QwixxScoreSheet:public ScoreSheet{
    calcTotal(int);
    //three QuintoRows of the desired colour
    // Construct the red and yellow row with a std::vector and the blue and green row with a std::list
    friend ostream& operator<<(QwixxScoreSheet&);
}

*/
/*
template QuintoRow<Colour>{
    //old style array
    //overload indexing or subscript operator
    //boolean errorCheck (RollOfDice);
    friend ostream& operator<<(QuintoRow&);
}


template QuixxRow<Class,Colour>{
    //different containers for the row
    //+= for the rollOfDice throwing an error!
    //
    //friend ostream& operator<<(QuixxRow&);
    //

}
*/