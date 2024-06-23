class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] {i, nums[i]});
            
            // 인덱스 범위를 벗어나면 제거
            while (pq.peek()[0] <= i - k) {
                pq.poll();
            }
            
            // 사이즈가 k 미만인 경우, 결과에 저장되면 안됨
            if (pq.size() < k) {
                continue;
            }
            
            result.add(pq.peek()[1]);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}