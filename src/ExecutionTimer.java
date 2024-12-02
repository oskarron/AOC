import java.util.function.Supplier;

public class ExecutionTimer {
    public static <T> T measureExecutionTime(String description, Supplier<T> function) {
        long startTime = System.nanoTime();
        T result = function.get();
        long endTime = System.nanoTime();

        System.out.println(description + " executed in: " + (endTime - startTime)/1000000 + " ms");
        return result;
    }
}
