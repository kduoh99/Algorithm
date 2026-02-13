class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        // 0: 미방문, 1: 처리 중, 2: 처리 완료
        int[] status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, i, status)) return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int finish, int[] status) {
        if (status[finish] == 1) return false;  // 사이클
        if (status[finish] == 2) return true;   // 처리 완료

        if (map.containsKey(finish)) {
            status[finish] = 1;

            for (Integer next : map.get(finish)) {
                if (!dfs(map, next, status)) return false;
            }
        }
        
        status[finish] = 2;
        return true;
    }
}