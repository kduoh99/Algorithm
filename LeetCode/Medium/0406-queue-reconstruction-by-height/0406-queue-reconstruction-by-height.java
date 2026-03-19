class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] p : people)
            pq.offer(p);
        
        List<int[]> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][2]);
    }
}