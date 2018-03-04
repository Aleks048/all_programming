maxmin([X],X,X).
maxmin([H|T],Max,Min):- maxmin(T,Max,Min),H > Max,Max is H.

maxmin([H|T],Max,Min):- maxmin(T,Max,Min),H < Min,Min is H.


%ODD AND EVEN
%base case
oddEven([],[]).

%recursive
oddEven([H|T],[even|L]):- 0 is mod(H,2),!,oddEven(T,L).
oddEven([H|T],[odd|L]):- 1 is mod(H,2),!,oddEven(T,L).

%REVERSE AND REMOVE SECOND ELEMENT

reverseDrop(L,R):- reverseDrop(L,1,[],R),!.

reverseDrop([],_,R,R):-!.

reverseDrop([HL|TL],N,I,R):-
            N=1,
            reverseDrop(TL,0,[HL|I],R).

reverseDrop([_|TL],N,I,R):-
            N=0,
            reverseDrop(TL,1,I,R).