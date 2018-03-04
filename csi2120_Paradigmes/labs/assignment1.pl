%question1

city(ottawa,ontario).
city(toronto,ontario).
city(kingston,ontario).
city(gatineau,quebec).
city(montreal,quebec).
company(shopify,ottawa).
company(rossvideo,ottawa).
company(dium,gatineau).
company(uber,toronto).
company(deepmind,montreal).
company(google,toronto).
person(annie,gatineau).
person(paul,gatineau).
person(suzy,gatineau).
person(robert,gatineau).
person(tom,ottawa).
person(tim,kingston).
person(joe,montreal).
person(jane,ottawa).
person(marie,ottawa).
person(jack,toronto).
person(simon,toronto).
employee(annie,dium).
employee(tom,shopify).
employee(jane,shopify).
employee(marie,shopify).
employee(joe,deepmind).
employee(jack,google).
employee(simon,google).
employee(suzy,shopify).
employee(paul,rossvideo).
employee(marie,rossvideo).
employee(simon,uber).


busy(X):- employee(X,C1),employee(X,C2),compare(<,C1,C2).
busy(X):- employee(X,C),company(C,toronto). 

%question3

distance(Lat1,Lon1,Lat2,Lon2,D):-angle(Lat1,Lat1R),
                                angle(Lon1,Lon1R),
                                angle(Lat2,Lat2R),
                                angle(Lon2,Lon2R),
                                dradians(Lat1R,Lon1R,Lat2R,Lon2R,Dr),
                                D is 6371.0*Dr.
%calculate the distance in radians
dradians(Lat1,Lon1,Lat2,Lon2,D):- D = 2*asin(sqrt((sin((Lat1-Lat2)/2)**2+cos(Lat1)*cos(Lat2)*((sin((Lon1-Lon2)/2)**2))))).
% convert the angle
angle(X,Y):- Y is pi*(X/180).

%question4

absDiffA([],[],[]).
absDiffA([],L,L).
absDiffA(L,[],L).
absDiffA([H1|T1],[H2|T2],L):- 
                !,
                In is abs(H1-H2),
                absDiffA(T1,T2,Lr),
                L = [In|Lr]
                .

absDiffB([],[],[]). 
absDiffB([],_,[]).
absDiffB(_,[],[]).               
absDiffB([H1|T1],[H2|T2],L):- 
                !,
                In is abs(H1-H2),
                absDiffB(T1,T2,Lr),
                L = [In|Lr]
                .

%qustion5

flower(rose,red).
flower(marigold,yellow).
flower(tulip,red).
flower(daffodil,yellow).
flower(rose,yellow).
flower(maigold,red).%probably a mistake in the database
flower(rose,white).
flower(cornflower,purple). 


bouquet(N,L):- bouquet2(N,L,_),!.%call the 2 red and other bouquet
bouquet(N,L):- bouquet(N,L,_).% if 2 red and other fails try 3 different

% find 3 different color 3 different name flower bouquet
%base
bouquet(0,[],[]).
%recursive
bouquet(N,L,L2):-             
                N1 is N-1,%counter
                bouquet(N1,Ln,Lc),%recursive call
                flower(Name,Colour),%pick a flower
                validate(flower(Name,Colour),Lc,Ln),%check if flower can be put into the bouquet
                L2 = [Colour|Lc],%store the colour used
                L = [Name|Ln],!.%store the name used and stop searching

validate(flower(N,C),Lc,Ln):-
                not(member(N,Ln)),
                not(member(C,Lc)),!.
                
%find the bouquet of 2 red flowers and the other

%base
bouquet2(0,[],[]).
%recursion
bouquet2(N,L,_):-             
                N1 is N-1,%counter
                bouquet2(N1,Ln,_),%recursive call
                flower(Name,Colour),%pick a flower
                validate2(N1,Name,Colour,Ln),%check if can put in
                append(Ln,[Name],L),!.%put into the bouquet.stop searching
%check if can put flower into bouquet
%case flower 1 or 2
validate2(N,Name,C,Ln):-
                (N=1;N=0),
                C = red,
                not(member(Name,Ln)),!.
%case flower 3
validate2(N,Name,_,Ln):-
                N=2,
                not(member(Name,Ln)),!.  

