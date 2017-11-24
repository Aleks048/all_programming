package assignment4;

import java.lang.String;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class inputData{

    public static void input() throws FileNotFoundException{
        
     Scanner inputSc = new Scanner (new FileReader("C:/Users/Aleks048/Downloads/studies_programming/git/all_programming/CSI2110_Algorithms/assignment4/assignment4/src/main/java/assignment4/parisSubway.txt")); 
     String numOfVertEdg = inputSc.nextLine();

     String [] arr= numOfVertEdg.split(" ");

     Graph.verticesArr = new Vertex[Integer.parseInt(arr[0])];//create an array to hold the vertices

     while (inputSc.hasNextLine()){
         
         String temp = inputSc.nextLine();

         if (temp.equals("$")){break;}

         String [] tempArr = temp.split(" ");//create array of components of the vertex

         Vertex tempV = new Vertex (tempArr[0],tempArr[1]);//(id, name)
         Graph.verticesArr[Integer.parseInt(tempV.getId())]= tempV;//put into array of vertices

         Graph.vertices.add(tempV);//add vertex to the graph
         
     }
    

     while(inputSc.hasNextLine()){
        String temp = inputSc.nextLine();

        String [] tempArr = temp.split(" ");//create array of components of the edge
        Edge tempEdge  = new Edge (Graph.verticesArr[Integer.parseInt(tempArr[0])],Graph.verticesArr[Integer.parseInt(tempArr[1])],Integer.parseInt(tempArr[2]));//create a new edge
       
        Graph.edges.add(tempEdge); //add edge to the graph
        
        Graph.verticesArr[Integer.parseInt(tempArr[0])].addEdgeOut(tempEdge);//add edge to the outgoing of a vertex
        Graph.verticesArr[Integer.parseInt(tempArr[1])].addEdgeIn(tempEdge);//add edge incoming of the vertex
     }
   
     //System.out.println(Graph.vertices.firstElement().goingOut.firstElement().finish.id);//change vertex and edge privacy if testing
    }
    

    public static void main (String args[]){
        try{
        inputData.input();
        }
        catch (FileNotFoundException e){
            System.out.println("It's not the file you're looking for.");
        }

        System.out.println(Graph.sameLine(12));
        
    } 
}