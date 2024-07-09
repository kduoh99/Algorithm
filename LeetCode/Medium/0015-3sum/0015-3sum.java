class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 중복을 피하기 위해 Set 사용
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        
        // Set을 리스트로 변환하여 반환
        return new ArrayList<>(results);
    }
}