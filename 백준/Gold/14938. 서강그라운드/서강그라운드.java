import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 1_000_000;
	private static ArrayList<ArrayList<Node>> graph;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] t = new int[n + 1];
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			t[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, l));
			graph.get(b).add(new Node(a, l));
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			int[] dist = dijkstra(i);
			int sumT = 0;

			for (int j = 1; j <= n; j++) {
				if (dist[j] <= m)
					sumT += t[j];
			}
			max = Math.max(max, sumT);
		}

		System.out.println(max);
		br.close();
	}

	private static int[] dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.w > dist[cur.v]) continue;

			for (Node next : graph.get(cur.v)) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		return dist;
	}
}

class Node {
	int v, w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
