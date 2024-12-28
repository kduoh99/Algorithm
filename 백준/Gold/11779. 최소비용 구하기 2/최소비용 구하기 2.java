import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 100_000_000;
	private static final StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
	
		System.out.println(dijkstra(start, end));
		System.out.println(sb);
		br.close();
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
		int[] dist = new int[N + 1];
		int[] prev = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer> path = new ArrayList<>();

		for (int i = 1; i <= N; i++)
			dist[i] = INF;

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			if (cur.v == end) break;

			for (Node next : graph[cur.v]) {
				if (dist[next.v] >= dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
					prev[next.v] = cur.v;
				}
			}
		}

		int cur = end;
		while (cur != start) {
			path.add(cur);
			cur = prev[cur];
		}
		
		path.add(start);
		int size = path.size();
		sb.append(size).append('\n');
		for (int i = size - 1; i >= 0; i--)
			sb.append(path.get(i)).append(' ');

		return dist[end];
	}
}

class Node {
	int v, w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
