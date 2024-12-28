import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int n;
	private static ArrayList<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		dijkstra(s, t);
		br.close();
	}

	private static void dijkstra(int s, int t) {
		int[] dist = new int[n + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[s] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{s, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curV = cur[0];
			int curC = cur[1];

			if (curC > dist[curV]) continue;

			if (curV == t) {
				System.out.println(curC);
				return;
			}

			for (int[] next : graph[curV]) {
				int nextV = next[0];
				int nextC = curC + next[1];

				if (dist[nextV] > nextC) {
					dist[nextV] = nextC;
					pq.offer(new int[]{nextV, nextC});
				}
			}
		}
	}
}
