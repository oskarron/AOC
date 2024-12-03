public class Main {
    public static void main(String[] args) {
        ExecutionTimer.measureExecutionTime("part 1: ", day1::part1);
        ExecutionTimer.measureExecutionTime("part 2: ", day1::part2);
        ExecutionTimer.measureExecutionTime("day 2 part1: ", day2::part1);
    }
}