import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day4 {
    static ArrayList<String> stringList;
    static HashMap<Integer, Character> xmasMap = new HashMap<>();

    public static boolean isLegalIndex(int row, int col) {
        return row >= 0 && row < stringList.size() && col >= 0 && col < stringList.get(row).length();
    }

    public static int part1() {
        int xmasAppearances = 0;
        int row = 0;
        listOfLines();
        xmasMap.put(1, 'M');
        xmasMap.put(2, 'A');
        xmasMap.put(3, 'S');
        for (String line : stringList) {
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == 'X') {
                    xmasAppearances+=checkDirections(row, col);
                }
            }
            row++;
        }
        return xmasAppearances;
    }
    public static void listOfLines() {
        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File("inputs/day4");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                list.add(input.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        stringList = list;
    }

    public static int checkDirections(int row, int col) {
        int[][] directionalOffsets = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        int xmasAppearances = 0;

        for (int[] offset : directionalOffsets) {
            boolean isXmas = true;
            for (int i = 1; i < 4; i++) {
                int newRow = row + (offset[0]*i);
                int newCol = col + (offset[1]*i);
                // kræsjer i kanten
                if (!isLegalIndex(newRow, newCol)) {
                    isXmas = false;
                    break;
                //feil bokstav
                } else if (xmasMap.get(i) != stringList.get(newRow).charAt(newCol)) {
                    isXmas = false;
                    break;
                }
            }
            if (isXmas) {
                xmasAppearances++;
            }
        }
        return xmasAppearances;
    }
}
