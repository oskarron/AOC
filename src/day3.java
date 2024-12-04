import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static int part1() {
        try {
            File file = new File("inputs/day3");
            Scanner input = new Scanner(file);
            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

            int sum = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                }
            }
            input.close();
            return sum;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int part2() {
        try {
            File file = new File("inputs/day3");
            Scanner input = new Scanner(file);
            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");

            int sum = 0;
            boolean shouldProcess = true;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    if (matcher.group(0).equals("don't()")) {
                        shouldProcess = false;
                    } else if (matcher.group(0).equals("do()")) {
                        shouldProcess = true;
                    } else if (matcher.group(1) != null && matcher.group(2) != null && shouldProcess) {
                        int num1 = Integer.parseInt(matcher.group(1));
                        int num2 = Integer.parseInt(matcher.group(2));
                        sum += num1 * num2;
                    }
                }
            }
            input.close();
            return sum;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
