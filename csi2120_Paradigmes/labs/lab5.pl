bunkbeds(L):- L=[[N1,C1],[N2,C2],[kayla,C3],[N4,C4],[N5,C5],[N6,C6]],
    ((N1=reeva,N2=haley);(N2=reeva,N1=haley)),

    ((N1,black),(kayla,black),()),
    ((C1=blue,C2=red);(C3=blue,C3=red);()),
    ((N1=liza);(N3=liza);(N5=liza)),
    (N4 =!= zoe),
    ((C5=brown);(C6=brown)),
    (((C1=black),(C2=yellow));((C3=black),(C4=yellow));((C5=black),(C6=yellow)))