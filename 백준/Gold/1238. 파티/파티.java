import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = Integer.MAX_VALUE;
	private static int N;
	private static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[M + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, t));
		}

		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++)
			result[i] = dijkstra(i, X) + dijkstra(X, i);

		int max = Arrays.stream(result).max().orElse(0);
		System.out.println(max);
		br.close();
	}

	private static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[N + 1];
		int[] T = new int[N + 1];
		Arrays.fill(T, INF);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		T[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v]) continue;
			visited[cur.v] = true;

			for (Node next : graph[cur.v]) {
				if (T[next.v] > T[cur.v] + next.w) {
					T[next.v] = T[cur.v] + next.w;
					pq.offer(new Node(next.v, T[next.v]));
				}
			}
		}

		return T[end];
	}
}

class Node implements Comparable<Node> {
	int v, w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}
