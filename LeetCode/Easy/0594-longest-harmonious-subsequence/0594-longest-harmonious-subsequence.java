class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int result = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1)
                left++;

            if (nums[right] - nums[left] == 1)
                result = Math.max(result, right - left + 1);
        }

        return result;
    }
}