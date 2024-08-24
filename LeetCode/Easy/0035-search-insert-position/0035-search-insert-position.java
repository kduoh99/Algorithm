class Solution {
    public int searchInsert(int[] nums, int target) {
        final int SIZE = nums.length;
        int prev = -10001;
        
        for (int i = 0; i < SIZE; i++) {
            if (target == nums[i] || (target > prev && target < nums[i])) {
                return i;
            }
        }
        
        return nums[SIZE - 1] < target ? SIZE : prev;
    }
}