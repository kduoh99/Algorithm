class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // target에서 nums[i]를 뺀 값이 map에 있으면 리턴
            if (map.containsKey(target - nums[i])) {
                return new int[] {
                    map.get(target - nums[i]), i
                };
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
}