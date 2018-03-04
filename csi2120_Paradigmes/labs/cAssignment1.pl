%find the distance
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

%dummy data
pool(name,coordinates(45,73)).
pool(name2,coordinates(47,71)).
pool(name3,coordinates(47,75)).
pool(name4,coordinates(47,78)).


%to find The most west pool
findTheWestest(R):- pool(_,coordinates(_,Lon)),
                    findTheWestest(_,Lon,R),!
                    .
findTheWestest(_,Curr,R):- pool(N,coordinates(_,Lon)),
                           Lon<Curr,!,
                           findTheWestest(N,Lon,R),R = N
                           .
%base case
findTheWestest(X,_,X).



%find the nearest //questionable needs testing
findTheClosest(N,R):- pool(N,coordinates(Lat,Lon)),
                      findTheClosest(_,1000,Lat,Lon,R).
findTheClosest(N,CurrD,CurrLat,CurrLon,R):- pool(N,coordinates(Lat,Lon)),
                                        distance(Lat,Lon,CurrLat,CurrLon,D),
                                        D<CurrD,D =\= 0,!,
                                        findTheClosest(N,D,Lat,Lon,R),
                                        R=N
                                        .
findTheClosest(X,_,_,_,X).
%graph():-.