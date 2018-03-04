%quiz4 Aleksandr Shumarov 8953643

%storeTheTree
tree(X):-X=t(73, t(31, t(5, nil, nil), nil), t(101, t(83, nil, t(97, nil, nil)), nil)).
tree(X):-X=t(73, t(31, t(5, nil, nil), nil), t(101, t(83, t(97, nil, nil), nil), nil)).
%starting
leftNodes(T,L) :- leftNodes(T,[],L).


%reachedTheLeaf
leftNodes(nil,LA,LA) :- !.

%ifFoundLeft
leftNodes(t(Root,Left,nil),LA,L) :- 
    Left \= nil,
    LAT = [Root],
    leftNodes(Left,LA,LL),
    append(LL,LAT,L),!.

%ifLeftAndRightOrOnlyRight
leftNodes(t(_,Left,Right),LA,L) :-
    leftNodes(Left,LA,LL),
    leftNodes(Right,LA,LR),
    append(LL,LR,L).