import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        dfs(result, map, "ICN");
        Collections.reverse(result);
        
        return result.toArray(String[]::new);
    }
    
    private void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(result, map, map.get(from).poll());
        }
        
        result.add(from);
    }
}