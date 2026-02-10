class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val visited = BooleanArray(nums.size)

        fun dfs(depth: Int) {
            if (depth == nums.size) {
                val list = mutableListOf<Int>()

                for (i in 0 until nums.size) {
                    if (visited[i])
                        list.add(nums[i])
                }

                result.add(list)
                return
            }

            visited[depth] = true
            dfs(depth + 1)
            visited[depth] = false
            dfs(depth + 1)
        }

        dfs(0)
        return result
    }
}