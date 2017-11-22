package assignment4;

import java.lang.String;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class inputData{
    protected static Vector<String[]> inputStations = new Vector <String[]>();
    protected static Vector<String[]> inputDistances = new Vector <String[]>();

    public static void input() throws FileNotFoundException{
        
     Scanner inputSc = new Scanner (new FileReader("C:/Users/Aleks048/Downloads/studies_programming/git/all_programming/CSI2110_Algorithms/assignment4/assignment4/src/main/java/assignment4/parisSubway.txt")); 
     String numOfVertEdg = inputSc.nextLine();
     System.out.println(numOfVertEdg);

    

     while (inputSc.hasNextLine()){
         String temp = inputSc.nextLine();
         String [] tempArr = new String[2];
         tempArr = temp.split(" ");
         if (temp.equals("$")){break;}
         inputStations.add(tempArr);
     }
    

     while(inputSc.hasNextLine()){
        String temp = inputSc.nextLine();

        String [] tempArr =new String[3];
        tempArr =  temp.split(" ");

        inputDistances.add(tempArr);
     }
     System.out.println(inputDistances);
    }
    

    public static void main (String args[]){
        try{
        inputData.input();
        }
        catch (FileNotFoundException e){
            System.out.println("It's not the file you're looking for.");
        }
        
    } 
}