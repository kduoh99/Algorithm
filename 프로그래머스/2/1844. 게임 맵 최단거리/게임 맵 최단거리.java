import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        int n = maps.length, m = maps[0].length;
        int[][] dist = new int[n][m];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[] {0, 0, 1});
        dist[0][0] = 1;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if (curr[2] > dist[curr[0]][curr[1]]) continue;
            if (curr[0] == n - 1 && curr[1] == m - 1) return curr[2];
            
            for (int[] d : dirs) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    if (dist[nx][ny] > curr[2] + 1) {
                        dist[nx][ny] = curr[2] + 1;
                        pq.offer(new int[] {nx, ny, dist[nx][ny]});
                    }
                }
            }
        }
        
        return -1;
    }
}