import java.io.File;
import java.util.*;

public class day1 {
    public static int part1(){
        try {

            File file = new File("inputs/day1");

            Scanner input = new Scanner(file);

            ArrayList<Integer> firstNumber = new ArrayList<>();
            ArrayList<Integer> secondNumber = new ArrayList<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(" ");

                firstNumber.add(Integer.parseInt(splitLine[0]));
                secondNumber.add(Integer.parseInt(splitLine[3]));

            }

            Collections.sort(firstNumber);
            Collections.sort(secondNumber);
            int difference = 0;

            for (int i = 0; i < firstNumber.size(); i++) {
                int dif = firstNumber.get(i) - secondNumber.get(i);
                difference += Math.abs(dif);
            }

            input.close();
            return difference;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int part2(){
        try {

            File file = new File("inputs/day1");

            Scanner input = new Scanner(file);

            Set<Integer> firstNumber = new HashSet<>();
            HashMap<Integer, Integer> secondNumber = new HashMap<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(" ");

                firstNumber.add(Integer.parseInt(splitLine[0]));

                if(secondNumber.containsKey(Integer.parseInt(splitLine[3]))){
                    int antall = secondNumber.get(Integer.parseInt(splitLine[3]));
                    antall +=1;
                    secondNumber.put(Integer.parseInt(splitLine[3]), antall);

                } else{
                    secondNumber.put(Integer.parseInt(splitLine[3]), 1);
                }

            }
            int similarityScore = 0;

            for (int number: firstNumber){
                if(secondNumber.containsKey(number)){
                    similarityScore += number * secondNumber.get(number);
                }
            }


            input.close();
            return similarityScore;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
