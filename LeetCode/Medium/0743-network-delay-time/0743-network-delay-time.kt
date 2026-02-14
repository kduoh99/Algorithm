class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array(n + 1) { mutableListOf<IntArray>() }
        
        for (time in times) {
            graph[time[0]].add(intArrayOf(time[1], time[2]))
        }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<IntArray> { o1, o2 -> o1[1] - o2[1] }

        pq.offer(intArrayOf(k, 0))
        dist[k] = 0

        while (pq.isNotEmpty()) {
            val curr = pq.poll()
            if (curr[1] > dist[curr[0]]) continue

            for (next in graph[curr[0]]) {
                if (dist[next[0]] > dist[curr[0]] + next[1]) {
                    dist[next[0]] = dist[curr[0]] + next[1]
                    pq.offer(intArrayOf(next[0], dist[next[0]]))
                }
            }
        }

        val d = (1..n).maxOf { dist[it] }
        return if (d == Int.MAX_VALUE) -1 else d
    }
}