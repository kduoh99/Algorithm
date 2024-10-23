import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final long INF = 300_000L * 1_000_000L + 1;
    private static List<List<int[]>> graph;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int P = Integer.parseInt(br.readLine());
        int[] Y = new int[P];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < P; i++)
            Y[i] = Integer.parseInt(st.nextToken());

        long answer = search(X, Z, Y);
        System.out.println(answer == INF ? -1 : answer);
        br.close();
    }

    private static long search(int start, int end, int[] Y) {
        long[] distX = dijkstra(start);
        long[] distZ = dijkstra(end);

        long answer = INF;
        for (int y : Y) {
            if (distX[y] != INF && distZ[y] != INF)
                answer = Math.min(answer, distX[y] + distZ[y]);
        }

        return answer;
    }

    private static long[] dijkstra(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.add(new long[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            if (cur[1] > dist[(int) cur[0]])
                continue;

            for (int[] next : graph.get((int) cur[0])) {
                if (dist[next[0]] > dist[(int) cur[0]] + next[1]) {
                    dist[next[0]] = dist[(int) cur[0]] + next[1];
                    pq.add(new long[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }
}