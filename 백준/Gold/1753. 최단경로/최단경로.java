import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		List<Node>[] graph = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}

		int[] dist = new int[V + 1];
		for (int i = 1; i <= V; i++)
			dist[i] = INF;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.v] < cur.w) continue;

			for (int i = 0; i < graph[cur.v].size(); i++) {
				Node next = graph[cur.v].get(i);

				if (dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dist[i]).append('\n');
		}
		System.out.println(sb);
		br.close();
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
