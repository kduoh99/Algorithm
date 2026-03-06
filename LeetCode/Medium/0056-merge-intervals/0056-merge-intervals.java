class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] i : intervals) {
            if (!merged.isEmpty() && i[0] <= merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], i[1]);
            } else {
                merged.add(i);
            }
        }

        return merged.stream().toArray(int[][]::new);
    }
}