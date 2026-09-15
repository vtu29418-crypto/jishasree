class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // Try every possible substring length that evenly divides n
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue; // length must evenly divide the string length
            }
            
            String candidate = s.substring(0, len);
            
            if (isRepeated(s, candidate, len)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isRepeated(String s, String candidate, int len) {
        int n = s.length();
        
        for (int i = len; i < n; i += len) {
            if (!s.substring(i, i + len).equals(candidate)) {
                return false;
            }
        }
        
        return true;
    }
}