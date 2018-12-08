package Day_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = null;
        String inputLine;
        int left, top, width, height;
        int squareInch = 0;
        int tab[][] = new int[1000][1000];
        int fields = 0, claimID;

        try{
            read = new Scanner(new FileReader("C:\\Users\\Standard\\IdeaProjects\\DatabaseTraining\\src\\Day_3\\input.txt"));
            while (read.hasNext()){
                inputLine = read.nextLine();

                left = Integer.parseInt(inputLine.substring(inputLine.indexOf("@")+2, inputLine.indexOf(",")));
                top = Integer.parseInt(inputLine.substring(inputLine.indexOf(",")+1,inputLine.indexOf(":")));
                width = Integer.parseInt(inputLine.substring(inputLine.indexOf(":")+2, inputLine.indexOf("x")));
                height = Integer.parseInt(inputLine.substring(inputLine.indexOf("x")+1));


                for(int i = left; i < left + width; i++){
                    for(int j = top; j < top + height; j++){
                        tab[i][j] += 1;
                    }
                }
            }
        }finally {
            if(read != null){
                read.close();
            }
        }

        for(int i = 0; i < tab.length; i++){
            for (int j = 0; j < tab[i].length; j++){
                if(tab[i][j] > 1){
                    squareInch++;
                }
            }
        }
        System.out.println("The amount of square inches of fabric within two or more claims is "+squareInch);

        read = new Scanner(new FileReader("C:\\Users\\Standard\\IdeaProjects\\DatabaseTraining\\src\\Day_3\\input.txt"));
        while (read.hasNext()){
            inputLine = read.nextLine();

            claimID = Integer.parseInt(inputLine.substring(inputLine.indexOf("#")+1,inputLine.indexOf(" ")));
            left = Integer.parseInt(inputLine.substring(inputLine.indexOf("@")+2, inputLine.indexOf(",")));
            top = Integer.parseInt(inputLine.substring(inputLine.indexOf(",")+1,inputLine.indexOf(":")));
            width = Integer.parseInt(inputLine.substring(inputLine.indexOf(":")+2, inputLine.indexOf("x")));
            height = Integer.parseInt(inputLine.substring(inputLine.indexOf("x")+1));


            for(int i = left; i < left + width; i++){
                for(int j = top; j < top + height; j++){
                    if(tab[i][j] == 1){
                        fields++;
                    }
                    //System.out.println("fields "+fields);
                }

            }
            if(fields == (width * height)){
                System.out.println("ID with claim that does not overlap "+claimID);
                System.exit(1);
            }
            fields = 0;
        }

    }
}
