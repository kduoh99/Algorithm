class Solution {
    public int missingNumber(int[] nums) {
        final int N = nums.length;
        int sum = 0;
        
        for (int num : nums)
            sum += num;
        
        return N * (N + 1) / 2 - sum;
    }
}