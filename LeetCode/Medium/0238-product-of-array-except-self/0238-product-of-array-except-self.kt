class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)

        var k = 1
        for (i in nums.indices) {
            answer[i] = k
            k *= nums[i]
        }

        k = 1
        for (i in nums.indices.reversed()) {
            answer[i] *= k
            k *= nums[i]
        }

        return answer
    }
}