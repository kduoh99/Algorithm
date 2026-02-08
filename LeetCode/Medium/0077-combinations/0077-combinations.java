class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, k, 0, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int k, int idx, int s) {
        if (idx == k) {
            result.add(Arrays.stream(nums, 0, k)
                             .boxed()
                             .collect(Collectors.toList()));
            return;
        }

        for (int i = s; i < nums.length; i++) {
            swap(nums, idx, i);
            dfs(result, nums, k, idx + 1, i + 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}