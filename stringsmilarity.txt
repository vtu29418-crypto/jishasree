import java.util.*;
import java.io.*;

public class Solution {

       static int[] computeZArray(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n; // by convention, similarity of the string with itself is its full length
        
        int left = 0, right = 0;
        
        for (int i = 1; i < n; i++) {
            if (i < right) {
                z[i] = Math.min(right - i, z[i - left]);
            }
            
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            
            if (i + z[i] > right) {
                left = i;
                right = i + z[i];
            }
        }
        
        return z;
    }

    static long stringSimilarity(String s) {
        int[] z = computeZArray(s);
        long sum = 0;
        
        for (int value : z) {
            sum += value;
        }
        
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine().trim();

            long result = stringSimilarity(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}