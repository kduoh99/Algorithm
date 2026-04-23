class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length, count = 0;

        for (int i = 0; i < n; i++) {
            int l = colors[i];
            int m = colors[(i + 1) % n];
            int r = colors[(i + 2) % n];

            if (l == r && l != m) count++;
        }

        return count;
    }
}