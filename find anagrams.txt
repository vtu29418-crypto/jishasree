class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        
        if (sLen < pLen) {
            return result;
        }
        
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        
        // Build frequency count for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        // Initialize the first window of size pLen
        for (int i = 0; i < pLen; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }
        
        // Slide the window across the rest of s
        for (int i = pLen; i < sLen; i++) {
            // Add the new character entering the window
            windowCount[s.charAt(i) - 'a']++;
            
            // Remove the character leaving the window
            windowCount[s.charAt(i - pLen) - 'a']--;
            
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}