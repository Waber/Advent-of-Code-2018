package Day_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = null;
        int twoTimes = 0, threeTimes = 0, countChar = 0;
        boolean doublTwo = false, doublThree = false; // if there are more pairs and triples in the line, this will prevent from incrementing
        int checksum;
        String index;
        char letter;

        List<String> indexes = new ArrayList<>();

        try{
            read = new Scanner(new FileReader("C:\\Users\\Standard\\IdeaProjects\\DatabaseTraining\\src\\Day_2\\input.txt"));
            while (read.hasNext()){
                index = read.nextLine();
                indexes.add(index);

                for(int i = 0; i < index.length(); i++){
                    letter = index.charAt(i);
                    for(int j = 0; j < index.length(); j++){
                        if(index.charAt(j) == letter){
                            countChar++;
                        }
                    }
                    if(countChar == 2 && !doublTwo){
                        twoTimes++;
                        doublTwo = true;
                    }
                    else if(countChar == 3 && !doublThree){
                        threeTimes++;
                        doublThree = true;
                    }
                    countChar = 0;
                    if(i == index.length()-1){
                        doublThree = false;
                        doublTwo = false;
                    }
                }
            }
        } finally {
            if(read != null){
                read.close();
            }
        }

        System.out.println("Two letters "+twoTimes);
        System.out.println("Three letters "+threeTimes);

        checksum = threeTimes * twoTimes;
        System.out.println("Checksum = "+checksum);

        //part 2
        String common="";

        for(int i = 0; i < indexes.size(); i++){
            index = indexes.get(i);
            for(int j = i+1; j < indexes.size(); j++){
                for(int x = 0; x <index.length(); x++) {
                    if ((int) indexes.get(j).charAt(x) == (int) index.charAt(x)) {
                        countChar++;
                    }
                }
                if(countChar == index.length() - 1){
                    for(int z = 0; z < index.length(); z++){
                        if(index.charAt(z) == indexes.get(j).charAt(z)){
                            common += index.charAt(z);
                        }
                    }
                    System.out.println("common letters between boxes "+common);
                    System.exit(1);
                }
                countChar = 0;
            }
        }
    }
}
