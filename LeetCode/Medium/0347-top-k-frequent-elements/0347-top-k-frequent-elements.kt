class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val pq = PriorityQueue<IntArray> { o1, o2 -> o2[1] - o1[1] }

        for (e in map.keys) {
            pq.offer(intArrayOf(e, map[e]!!))
        }

        val answer = IntArray(k)

        for (i in 0 until k) {
            answer[i] = pq.poll()[0]
        }

        return answer
    }
}