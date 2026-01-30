class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>(compareByDescending { it[0]} )

        for (p in points) {
            val d = p[0] * p[0] + p[1] * p[1]
            pq.offer(intArrayOf(d, p[0], p[1]))

            if (pq.size > k) {
                pq.poll()
            }
        }

        val arr = Array(k) { IntArray(2) }
        
        for (i in 0 until k) {
            val v = pq.poll()
            arr[i] = intArrayOf(v[1], v[2])
        }

        return arr
    }
}