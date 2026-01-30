class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int[] p : points) {
            int d = p[0] * p[0] + p[1] * p[1];
            pq.offer(new int[] {d, p[0], p[1]});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] arr = new int[k][];

        while (k > 0) {
            int[] v = pq.poll();
            arr[--k] = new int[] {v[1], v[2]};
        }
        
        return arr;
    }
}