import java.io.File;
import java.util.*;

public class day1 {
    public static void main(String[] args) {
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
            System.out.println(difference);

            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
