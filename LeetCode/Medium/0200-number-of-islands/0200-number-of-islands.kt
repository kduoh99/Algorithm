class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(x: Int, y: Int) {
            when {
                (x < 0) ||
                (x >= grid.size) ||
                (y < 0) ||
                (y >= grid[0].size) ||
                (grid[x][y] == '0') -> return
            }

            grid[x][y] = '0'
            dfs(x, y + 1)
            dfs(x, y - 1)
            dfs(x - 1, y)
            dfs(x + 1, y)
        }
        
        var count = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    count++
                }
            }
        }

        return count
    }
}