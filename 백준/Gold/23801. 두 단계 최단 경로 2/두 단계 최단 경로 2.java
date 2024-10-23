import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final long INF = 300_000L * 1_000_000L + 1;
    private static List<List<Node>> graph;
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

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int P = Integer.parseInt(br.readLine());
        int[] Y = new int[P];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < P; i++)
            Y[i] = Integer.parseInt(st.nextToken());

        System.out.println(search(X, Z, Y));
        br.close();
    }

    private static long search(int X, int Z, int[] Y) {
        long[] distX = dijkstra(X);
        long[] distZ = dijkstra(Z);

        long answer = INF;
        for (int y : Y) {
            if (distX[y] != INF && distZ[y] != INF)
                answer = Math.min(answer, distX[y] + distZ[y]);
        }
        return answer == INF ? -1 : answer;
    }

    private static long[] dijkstra(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.w));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}

class Node {
    int v;
    long w;

    public Node(int v, long w) {
        this.v = v;
        this.w = w;
    }
}
