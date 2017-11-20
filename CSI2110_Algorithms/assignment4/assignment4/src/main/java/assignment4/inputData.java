package assignment4;

import java.lang.String;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class inputData{

    public static void input() throws FileNotFoundException{
        System.out.println("HI there");
     Scanner inputSc = new Scanner (new FileReader("parisSubway.txt")); 
     String input;
     while (inputSc.hasNextLine()){
         input = inputSc.nextLine();
         System.out.println(input);
     }
    }

    public static void main (String args[]){
        try{
        inputData.input();
        }
        catch (FileNotFoundException e){}
        
    } 
}