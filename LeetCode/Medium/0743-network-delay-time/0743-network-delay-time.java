class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) 
            graph[i] = new ArrayList<>();
        
        for (int[] time : times) 
            graph[time[0]].add(new int[] { time[1], time[2] });
        
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[] { k ,0 });
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[1] > dist[curr[0]]) continue;

            for (int[] next : graph[curr[0]]) {
                if (dist[next[0]] > dist[curr[0]] + next[1]) {
					dist[next[0]] = dist[curr[0]] + next[1];
					pq.offer(new int[] { next[0], dist[next[0]] });
				}
            }
        }

        int d = 0;
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            d = Math.max(d, dist[i]);
        }

        return d;
    }
}