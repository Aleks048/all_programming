countDown(N):- N<0,!.
countDown(N):- repeat,writeln(N),N1 is N-1,countDown(N1).


element(chlorine,'Cl').
element(helium,'He').
element(hydrogen,'H').
element(nitrogen,'N').
element(oxygen,'O').

start:-writeln("Elements in the Periodic table "),
       repeat,
       write("what to look"),
       read(Elem),
       not(lookUp(Elem)),
       writeln("Exit"),!,fail.

lookUp(X):-element(E,X),
           write(X),
           write("is for :"),
           writeln(E),!.

lookUp(X):- write("Not found "),writeln(X),!,fail.


canalOpen( saturday ).
canalOpen( monday ).
canalOpen( tuesday ).

raining( saturday ).


melting( saturday ).
melting( sunday ).
melting( monday ).

nRaining(X):-raining(X),!,fail.
nRaining(_).
nMelting(X):-melting(X),!,fail.
nMelting(_).
winterlude(X):-canalOpen(X),nRaining(X),nMelting(X).


secondLast(H,[H|[_|[]]]):-!. 
secondLast(X,[_|T]):- secondLast(X,T).

