class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            switch (log) {
                case "../":
                    if (depth > 0) depth--;
                    break;
                case "./":
                    break;
                default:
                    depth++;
            }
        }

        return depth;
    }
}