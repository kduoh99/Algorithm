class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()

        for (p in prerequisites) {
            map.getOrPut(p[0]) { mutableListOf() }.add(p[1])
        }

        val status = IntArray(numCourses)

        fun dfs(finish: Int): Boolean {
            if (status[finish] == 1) return false
            if (status[finish] == 2) return true

            if (map.containsKey(finish)) {
                status[finish] = 1

                for (next in map[finish]!!) {
                    if (!dfs(next)) return false
                }
            }

            status[finish] = 2
            return true
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return false
        }

        return true
    }
}