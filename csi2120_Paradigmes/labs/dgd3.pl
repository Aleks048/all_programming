lastElement([Y],Y).
lastElement([_|X],Y):-   lastElement(X,Y,N1).

countElem([],0).
countElem([_|R],N):- countElem(R,N1),N is N1+1.

occurence([],_,0).
occurence([F|T],F,N):-occurence(T,F,N1),
                      N is N1+1.

occurence([F|T],X,N):-X=\=F,occurence(T,X,N).

insertion([],_).
insertion([E1|[E2|T1]],L):- E1<E2,insertion(T1,L1).

insertion([E1|T1],[E2|T2]):- E1>E2,insertion([E1|T1],T2).