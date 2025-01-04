import java.util.*;

public class Solution {
    public Deque<Integer> solution(int []arr) {
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
        
        return q;
    }
}