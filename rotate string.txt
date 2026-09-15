class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths differ, no rotation can ever make them equal
        if (s.length() != goal.length()) {
            return false;
        }

        String doubled = s + s;
        
        return doubled.contains(goal);
    }
}