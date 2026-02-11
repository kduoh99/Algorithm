class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs(result, map, "JFK");
        return result;
    }

    private void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(result, map, map.get(from).poll());
        }

        result.addFirst(from);
    }
}