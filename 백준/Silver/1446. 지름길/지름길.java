import java.io.*;
import java.util.*;

public class Main {
	private static final int INF = Integer.MAX_VALUE;
	private static ArrayList<Node>[] graph;
	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		graph = new ArrayList[D + 1];
		dist = new int[D + 1];

		for (int i = 0; i <= D; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
			
			if (i < D) {
				graph[i].add(new Node(i + 1, 1));
			}
		}

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (b <= D) {
				graph[a].add(new Node(b, c));
			}
		}

		dijkstra();
		System.out.println(dist[D]);
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
		pq.offer(new Node(0, 0));
		dist[0] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.v] < cur.w) continue;

			for (Node next : graph[cur.v]) {
				if (dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
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
