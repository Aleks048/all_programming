package assignment4;
import assignment4.Graph.Vertex;
import java.util.Vector;

public class Graph{
    Vector<Vertex> vertices;
    Vector<Edge> edges;

    class Edge{
        int time;
        private Vertex start;
        private Vertex finish;
    
        public Edge(Vertex start,Vertex finish,int time){
            this.start=start;
            this.finish=finish;
            this.time = time;
        }
    
        public Vertex getStart(){return this.start;}
        public Vertex getFinish(){return this.finish;}
        
    
    }

    class Vertex{
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

    public Graph(){}
    private void GraphCreation(){
        for (String[] i:inputData.inputStations){
            vertices.add(new Vertex(i[1],i[0]));
        }
        for (String[] j:inputData.inputStations){
            //edges.add(new Edge(new Vertex(),new Vertex(),i[2]));
        }
    }
}