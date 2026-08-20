class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Store height and corresponding name
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by height in descending order
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        // Build the result
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}
