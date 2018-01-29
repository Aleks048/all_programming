

a(0,N,X):- X is N+1.
a(M,0,X):- M>0,M1 is M-1,a(M1,1,X).
a(M,N,X):- M>0,N>0,M1 is M-1,N1 is N-1,a(M,N1,X1),a(M1,X1,X).