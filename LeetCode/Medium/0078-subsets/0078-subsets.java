class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, nums, visited, 0);

        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, boolean[] visited, int depth) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    list.add(nums[i]);
            }

            result.add(list);
            return;
        }

        visited[depth] = true;
        dfs(result, nums, visited, depth + 1);
        visited[depth] = false;
        dfs(result, nums, visited, depth + 1);
    }
}