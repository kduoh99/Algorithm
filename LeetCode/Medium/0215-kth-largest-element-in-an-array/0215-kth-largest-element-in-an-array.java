class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int SIZE = nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
        }
        
        for (int i = 0; i < SIZE - k; i++) {
            pq.poll();
        }
        
        return pq.poll();
    }
}