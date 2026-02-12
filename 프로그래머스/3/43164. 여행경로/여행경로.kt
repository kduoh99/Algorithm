import java.util.*;

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
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
        
        dfs("ICN")
        return result.reversed().toTypedArray()
    }
}