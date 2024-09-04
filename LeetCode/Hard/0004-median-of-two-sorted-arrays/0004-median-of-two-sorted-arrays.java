class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int SIZE = nums1.length + nums2.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums1) {
            pq.offer(num);
        }
        
        for (int num : nums2) {
            pq.offer(num);
        }

        int midean = SIZE / 2;
        double result = 0;
        
        if (SIZE % 2 == 0) {
            for (int i = 0; i < midean; i++) {
                result = pq.poll();
            }
            result += pq.peek();
            result /= 2;
        } else {
            for (int i = 0; i <= midean; i++) {
                result = pq.poll();
            }
        }
        
        return result;
    }
}