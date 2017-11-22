package assignment4;

import java.util.Vector;

public class Vertex{
    String id;
    String name;
    private Vector<Edge> comingIn;
    private Vector<Edge> goingOut;

    public Vertex(String name, String id){
        this.name = name;
        this.id = id;
    }

    public void addEdgeIn(Edge in){
        comingIn.add(in);
    }
    public void addEdgeOut(Edge out){
        goingOut.add(out);
    }
}