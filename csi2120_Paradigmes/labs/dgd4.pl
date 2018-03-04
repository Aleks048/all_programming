sup_k(X,[X|Xs],1,Xs).

sup_k(X,[H|T],K,[H|R]):- K>1,K1 is K-1,sup_k(X,T,K1,R).



deleteDup([H|T],R):-member(H,T),deleteDup(T,R).
deleteDup([H|T],[H|R]):-not(member(H,T)),deleteDup(T,R).
deleteDup([],[]).

equalList(L,L2):- equalList(L,L2,L).

equalList([],L,O):- equalList(L,O,L).
equalList(_,[],_).
equalList([H|T],[H2|T2],O):-member(H,[H2|T2]),equalList(T,[H2|T2],O).
