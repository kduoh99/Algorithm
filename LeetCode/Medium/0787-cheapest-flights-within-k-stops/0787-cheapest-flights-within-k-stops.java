class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] f : flights)
            graph[f[0]].add(new int[] { f[1], f[2] });

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] { src, 0, 0 });
    
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[0] == dst) return curr[1];

            if (curr[2] > k || curr[2] >= stops[curr[0]]) continue;
            stops[curr[0]] = curr[2];

            for (int[] next : graph[curr[0]]) {
                pq.offer(new int[] { next[0], curr[1] + next[1], curr[2] + 1 });
            }
        }

        return -1;
    }
}