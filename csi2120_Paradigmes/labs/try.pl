
pow( X, Y, Z ) :- Y>1,
	Y1 is Y - 1,
	pow( X, Y1, Z1 ), 
	Z is X * Z1.

pow( X, 1, X ).

gcd(U,0,U).
gcd(U,V,W) :- V>0, 
	R is U mod V,
	gcd(V,R,W).


gcdAlt(A,A,A).
gcdAlt(A,B,GCD):- A<B, NB is B-A, gcdAlt(A,NB,GCD).
gcdAlt(A,B,GCD):- A>B, NA is A-B, gcdAlt(NA,B,GCD).


%even(0).
odd(N) :- N>0, 
	M is N-1, 
	even(M).
even(N):- N>0,
	M is N-1, 
	odd(M).