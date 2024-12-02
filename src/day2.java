import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day2 {
    public static int part1(){

        try {
            File file = new File("inputs/day2");
            Scanner input = new Scanner(file);
            int safeReports = 0;
            int line = 0;
            while (input.hasNextLine()) {

                boolean safe = true;
                String[] splitInput = input.nextLine().split(" ");
                int a = Integer.parseInt(splitInput[0]);
                int b = Integer.parseInt(splitInput[1]);
                boolean ascending = a - b <= 0;

                for (int i = 0; i < splitInput.length-1; i++) {
                    int firstNumber = Integer.parseInt(splitInput[i]);
                    int secondNumber = Integer.parseInt(splitInput[i+1]);
                    int absoluteDifference = Math.abs(firstNumber - secondNumber);

                    //sjekk om ascending / descending
                    boolean checkAscending = firstNumber - secondNumber <= 0;
                    if(checkAscending != ascending){
                        safe = false;
                        break;
                    }
                    //sjekke differanse
                    if((absoluteDifference == 0 || absoluteDifference > 3)) {
                        safe = false;
                        break;
                    }

                }
                line+=1;
                if (safe) {
                    safeReports += 1;
                }
            }
            input.close();
            System.out.println(safeReports);
            return safeReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
