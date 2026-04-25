class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, count = 0, alter = 1;

        for (int i = 0; i < n + k - 2; i++) {
            if (colors[i % n] != colors[(i + 1) % n])
                alter++;
            else
                alter = 1;

            if (alter >= k)
                count++;
        }

        return count;
    }
}