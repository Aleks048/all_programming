maxmin([X],X,X).
maxmin([H|T],Max,Min):- maxmin(T,Max,Min),H > Max,Max is H.

maxmin([H|T],Max,Min):- maxmin(T,Max,Min),H < Min,Min is H.