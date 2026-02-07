class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int depth) {
        if (depth == nums.length) {
            result.add(Arrays.stream(nums)
                             .boxed()
                             .collect(Collectors.toList()));
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            swap(nums, depth, i);
            dfs(result, nums, depth + 1);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int depth, int i) {
        int tmp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = tmp;
    }
}