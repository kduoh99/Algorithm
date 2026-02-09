class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun dfs(nTarget: Int, idx: Int) {
            if (nTarget < 0) return
            if (nTarget == 0) {
                result.add(path.toList())
                return
            }

            for (i in idx until candidates.size) {
                path.add(candidates[i])
                dfs(nTarget - candidates[i], i)
                path.removeAt(path.size - 1)
            }
        }

        dfs(target, 0)
        return result
    }
}