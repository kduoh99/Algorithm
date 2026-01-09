class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()

        for ((i, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(map[target - num]!!, i)
            }

            map[num] = i
        }

        return intArrayOf(0, 0)        
    }
}