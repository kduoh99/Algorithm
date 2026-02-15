class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = Array(n) { mutableListOf<IntArray>() }
        for (f in flights) {
            graph[f[0]].add(intArrayOf(f[1], f[2]))
        }

        val stops = IntArray(n) { Int.MAX_VALUE }
        val pq = PriorityQueue<IntArray> { o1, o2 -> o1[1] - o2[1] }
        pq.offer(intArrayOf(src, 0, 0))

        while (pq.isNotEmpty()) {
            val curr = pq.poll()

            if (curr[0] == dst) return curr[1]

            if (curr[2] > k || curr[2] >= stops[curr[0]]) continue
            stops[curr[0]] = curr[2]

            for (next in graph[curr[0]]) {
                pq.offer(intArrayOf(next[0], curr[1] + next[1], curr[2] + 1))
            }
        }

        return -1
    }
}