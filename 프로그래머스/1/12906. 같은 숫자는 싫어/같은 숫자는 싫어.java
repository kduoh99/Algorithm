import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int a : arr) {
            if (!q.isEmpty()) {
                if (q.peekLast() != a) {
                    q.offer(a);
                }
            } else {
                q.offer(a);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (!q.isEmpty()) {
            list.add(q.pollFirst());
        }
        
        return list.stream()
			.mapToInt(Integer::intValue)
            .toArray();
    }
}