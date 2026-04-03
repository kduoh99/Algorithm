class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int n : nums) {
            if (n % 2 == 0)
                dq.offerFirst(n);
            else
                dq.offerLast(n);
        }

        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}