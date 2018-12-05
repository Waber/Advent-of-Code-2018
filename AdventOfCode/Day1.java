package AdventOfCode;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws IOException {


        Scanner bufferedReader = null;

        int currentFrequency = 0;
        List<Integer> valuesFrom = new LinkedList<>();


        try {
            bufferedReader = new Scanner(new FileReader("C:\\Users\\Standard\\IdeaProjects\\DatabaseTraining\\src\\AdventOfCode\\inputs\\day1.txt"));
            while (bufferedReader.hasNext()) {

                valuesFrom.add(bufferedReader.nextInt());
                currentFrequency += ((LinkedList<Integer>) valuesFrom).getLast();

            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        System.out.println(currentFrequency);

        //part 2

        List<Integer> checkList = new ArrayList<>();
        Boolean p2 = false;
        currentFrequency = 0;

        while(!p2) {
            for (int i = 0; i < valuesFrom.size() && !p2; i++) {
                checkList.add(currentFrequency);
                currentFrequency += valuesFrom.get(i);
                if (checkList.contains(currentFrequency)) {
                    System.out.println(currentFrequency);
                    p2 = true;
                }
            }
        }


    }
}
