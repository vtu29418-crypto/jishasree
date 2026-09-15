import java.util.*;
import java.io.*;

public class Solution {

    // Manacher's Algorithm: returns the length of the longest palindromic
    // substring in s, in O(n) time.
    static int longestPalindromicSubstringLength(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        // Transform s into a new string with separators to handle
        // both even and odd length palindromes uniformly.
        // e.g. "aba" -> "^#a#b#a#$"
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append('#').append('$');
        
        String t = sb.toString();
        int n = t.length();
        int[] p = new int[n]; // p[i] = radius of palindrome centered at i in t
        int center = 0, right = 0;
        int maxLen = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            // Attempt to expand palindrome centered at i
            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            
            // If palindrome centered at i expands past right, adjust center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            
            maxLen = Math.max(maxLen, p[i]);
        }
        
        // p[i] directly gives the length of the palindrome in the original string
        // (due to how the transform with separators works)
        return maxLen;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());
        String s = scanner.nextLine().trim();

        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String rotation = s.substring(i) + s.substring(0, i);
            int result = longestPalindromicSubstringLength(rotation);
            output.append(result).append('\n');
        }

        bufferedWriter.write(output.toString());

        bufferedWriter.close();

        scanner.close();
    }
}