package assignment4;
//import assignment4.Graph.Vertex;
import java.util.Vector;

public class Graph{
    static Vector<Vertex> vertices = new Vector<Vertex>();
    static Vector<Edge> edges = new Vector<Edge>();
    static Vertex[] verticesArr;

    private Graph(){
    }

    static public String sameLine(int VertexId){
        String out ="";

        Vertex root = verticesArr[VertexId];
        

        for (Edge e:root.getEdgesOut()){
            if (e.getTime()!=-1){
            
            out+=Graph.sameLine(e.getFinish(),root);
            out+="!"+root.getName()+"!";

            }
        }

        return out;
    }
    static private String sameLine(Vertex currentVertex,Vertex previousVertex){
        String out ="";

        if (currentVertex.getEdgesOut().size()==1){return currentVertex.getName();}//bottom condition
        else{
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getFinish()!=previousVertex)&&(e.getTime()!=-1)){
                    out = currentVertex.getName()+" <- "+sameLine(e.getFinish(),currentVertex);

                }
            }
        }
        return out;
    }
}