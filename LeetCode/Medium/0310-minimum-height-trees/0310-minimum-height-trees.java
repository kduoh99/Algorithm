class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Integer) leaf);

                if (graph.get(neighbor).size() == 1)
                    nextLeaves.add(neighbor);
            }

            leaves = nextLeaves;
        }

        return leaves;
    }
}