class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int v = gas[i] - cost[i];
            total += v;
            curr += v;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}