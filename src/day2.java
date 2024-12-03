import java.io.File;
import java.util.Scanner;

public class day2 {
    public static int part1() {

        try {
            File file = new File("inputs/day2");
            Scanner input = new Scanner(file);
            int safeReports = 0;
            while (input.hasNextLine()) {
                String[] splitInput = input.nextLine().split(" ");
                if (safeReport(splitInput)) {
                    safeReports++;
                }
            }
            return safeReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public static int part2() {
        try {
            File file = new File("inputs/day2");
            Scanner input = new Scanner(file);
            int safeReports = 0;

            while (input.hasNextLine()) {
                String[] splitInput = input.nextLine().split(" ");
                if (safeReport(splitInput)) {
                    safeReports++;
                } else {
                    for (int i = 0; i < splitInput.length; i++) {
                        String[] splitInputCopy = new String[splitInput.length - 1];
                        for (int j = 0, k = 0; j < splitInput.length; j++) {
                            if (i != j) {
                                splitInputCopy[k++] = splitInput[j];
                            }
                        }
                        if (safeReport(splitInputCopy)) {
                            safeReports++;
                            break;
                        }
                    }
                }
            }
            return safeReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static boolean safeReport(String[] line) {
        boolean safe = true;
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        boolean ascending = a - b <= 0;

        for (int i = 0; i < line.length - 1; i++) {
            int firstNumber = Integer.parseInt(line[i]);
            int secondNumber = Integer.parseInt(line[i + 1]);
            int absoluteDifference = Math.abs(firstNumber - secondNumber);

            //sjekk om ascending / descending
            boolean checkAscending = firstNumber - secondNumber <= 0;
            if (checkAscending != ascending) {
                safe = false;
                break;
            }
            //sjekke differanse
            if ((absoluteDifference == 0 || absoluteDifference > 3)) {
                safe = false;
                break;
            }

        }
        return safe;
    }
}