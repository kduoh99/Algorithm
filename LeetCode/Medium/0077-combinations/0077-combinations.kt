class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val nums = IntArray(n) { it + 1 }
        val result = mutableListOf<List<Int>>()

        fun swap(i: Int, j: Int) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }

        fun dfs(idx: Int, s: Int) {
            if (idx == k) {
                result.add(nums.slice(0 until k))
                return
            }

            for (i in s until nums.size) {
                swap(idx, i)
                dfs(idx + 1, i + 1)
                swap(idx, i)
            }
        }

        dfs(0, 0)
        return result
    }
}