package Day_5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = null;
        StringBuilder inputLine, improvedPolymer;
        int asciiVal = 65;


        try{
            read = new Scanner(new FileReader("C:\\Users\\Standard\\IdeaProjects\\DatabaseTraining\\src\\Day_5\\input.txt"));

                inputLine = new StringBuilder(read.nextLine());
            int shortestPolymer = inputLine.length();

            //Part 2
            while (asciiVal != 90) {
                improvedPolymer = new StringBuilder(inputLine);
                for (int j = 0; j < improvedPolymer.length(); j++) {
                    if (improvedPolymer.charAt(j) == asciiVal || improvedPolymer.charAt(j) == asciiVal + 32) {
                        improvedPolymer.deleteCharAt(j);
                        j--;
                    }
                }
                for (int i = 0; i < improvedPolymer.length()-1; i++){
                    if(improvedPolymer.charAt(i) == improvedPolymer.charAt(i+1)  + 32 || improvedPolymer.charAt(i)  == improvedPolymer.charAt(i+1) - 32){
                        improvedPolymer.delete(i,i+2);
                        i=-1;
                    }
                }
                if(improvedPolymer.length() < shortestPolymer){
                    shortestPolymer = improvedPolymer.length();
                }

                asciiVal++;
            }



            System.out.println("Length of the shortest polymer is "+shortestPolymer);
//Part 1
            for (int i = 0; i < inputLine.length()-1; i++){
                    if(inputLine.charAt(i) == inputLine.charAt(i+1)  + 32 || inputLine.charAt(i)  == inputLine.charAt(i+1) - 32){
                        inputLine.delete(i,i+2);
                        i=-1;
                    }
                }

        }finally {
            if(read != null){
                read.close();
            }
        }

        System.out.println("The amount of reamaining units is "+inputLine.length());



    }
}
