import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] graph;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count = 1;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[M];
            for (int i = 0; i < M; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                graph[x].add(new Node(y, z));
                graph[y].add(new Node(x, z));
            }

            int[] answer = dijkstra();
            sb.append("Case #").append(count++).append(": ");

            if (answer == null) {
                sb.append("-1");
            } else {
                for (int ans : answer)
                    sb.append(ans).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int[] dijkstra() {
        int[] dist = new int[M];
        int[] prev = new int[M];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.offer(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    prev[next.v] = cur.v;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        if (dist[M - 1] == INF) {
            return null;
        } else {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = M - 1; i != -1; i = prev[i])
                stack.push(i);

            int[] result = new int[stack.size()];
            int idx = 0;

            while (!stack.isEmpty())
                result[idx++] = stack.pop();

            return result;
        }
    }
}

class Node {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
