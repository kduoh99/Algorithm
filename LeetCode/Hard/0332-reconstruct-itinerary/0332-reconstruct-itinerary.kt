class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val result = mutableListOf<String>()
        val map = mutableMapOf<String, PriorityQueue<String>>()

        for (ticket in tickets) {
            map.getOrPut(ticket[0]) { PriorityQueue() }.add(ticket[1])
        }

        fun dfs(from: String) {
            while (map.containsKey(from) && map[from]!!.isNotEmpty()) {
                dfs(map[from]!!.poll())
            }

            result.add(from)
        }

        dfs("JFK")
        return result.reversed()
    }
}