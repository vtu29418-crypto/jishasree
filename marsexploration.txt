import java.util.*;
import java.io.*;

public class Solution {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int changes = 0;
        String pattern = "SOS";
        
        for (int i = 0; i < s.length(); i++) {
            char expected = pattern.charAt(i % 3);
            char actual = s.charAt(i);
            
            if (actual != expected) {
                changes++;
            }
        }
        
        return changes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}