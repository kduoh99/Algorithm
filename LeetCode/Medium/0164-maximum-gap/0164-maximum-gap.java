class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int result = 0, prev = -1;
        
        for (int num : nums) {
            if (prev >= 0) {
                result = Math.max(result, num - prev);
            }
            prev = num;
        }
        
        return result;
    }
}