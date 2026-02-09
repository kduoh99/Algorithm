class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, target, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> path, int idx) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(result, candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}