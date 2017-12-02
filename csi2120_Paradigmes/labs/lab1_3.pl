
% room lighting
lit( roomA, lightA ).
lit( roomB, lightB ).
lit( roomA, lightC ).



% light switches
control( lightA, switch1 ).
control( lightB, switch2 ).
control( lightB, switch1 ).
control( lightC, switch3 ).

% wiring of lights
hardwire(lightA).
hardwire(lightB).
plug( lightC, socketA ).

% fuses
fuse( lightA, fuse1 ).
fuse( lightB, fuse2 ).
fuse( socketA, fuse2 ).

% fuse ok
ok( fuse1 ).
ok( fuse2 ).

% switches on
isOn( switch2 ).
isOn( switch3 ).

% hard-wired lights
connected(L) :- fuse(L, F),
		ok(F).

% plugged in lights
connected(L) :- plug(L,S),
                fuse(S,F),
                ok(F).

bright(X) :- lit(X, L),
             control(L, S),
             isOn(S),
             connected(L).
