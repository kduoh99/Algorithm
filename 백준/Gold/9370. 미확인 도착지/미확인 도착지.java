import java.io.*;
import java.util.*;

public class Main {
	private static final int INF = 1_000_000_000;
	private static ArrayList<Node>[] graph;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));
			}

			ArrayList<Integer> dest = new ArrayList<>();
			while (t-- > 0) {
				int x = Integer.parseInt(br.readLine());
				dest.add(x);
			}

			Collections.sort(dest);
			int[] distS = dijkstra(s);
			int[] distG = dijkstra(g);
			int[] distH = dijkstra(h);

			for (int d : dest) {
				if (distS[d] == distS[g] + distG[h] + distH[d] || distS[d] == distS[h] + distH[g] + distG[d]) {
					sb.append(d).append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static int[] dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.v] < cur.w) continue;

			for (Node next : graph[cur.v]) {
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
