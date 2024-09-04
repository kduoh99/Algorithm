class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums1) {
            pq.offer(num);
        }
        
        for (int num : nums2) {
            pq.offer(num);
        }
        
        final int SIZE = nums1.length + nums2.length;
        int tmp = 0;
        double result = 0;
        
        if (SIZE % 2 == 0) {
            tmp = SIZE / 2 - 1;
            
            for (int i = 0; i < tmp; i++) {
                pq.poll();
            }
            
            double a = pq.poll();
            double b = pq.poll();
            
            result = (a + b) / 2;
        } else {
            tmp = SIZE / 2;
            
            for (int i = 0; i < tmp; i++) {
                pq.poll();
            }
            
            result = pq.poll();
        }
        
        return result;
    }
}