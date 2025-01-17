import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            char op = st.nextToken().charAt(0);
            
            if (op == 'I') {
                int v = Integer.parseInt(st.nextToken());
                
                minHeap.offer(v);
                maxHeap.offer(v);
            } else {
                int v = Integer.parseInt(st.nextToken());
                
                if (v == 1 && !maxHeap.isEmpty()) {
                    minHeap.remove(maxHeap.poll());
                } else if (v == -1 && !minHeap.isEmpty()) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        int max = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        int min = minHeap.isEmpty() ? 0 : minHeap.poll();
        
        return new int[] {max, min};
    }
}