class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int SIZE = nums.length;
        int[] result = new int[SIZE];
        
        int left = 1;
        for (int i = 0; i < SIZE; i++) {
            result[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        for (int i = SIZE - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }
}