class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun swap(depth: Int, i: Int) {
            val tmp = nums[depth]
            nums[depth] = nums[i]
            nums[i] = tmp
        }

        fun dfs(depth: Int) {
            if (depth == nums.size) {
                result.add(nums.toList())
                return
            }

            for (i in depth until nums.size) {
                swap(depth, i)
                dfs(depth + 1)
                swap(depth, i)
            }
        }

        dfs(0)
        return result
    }
}