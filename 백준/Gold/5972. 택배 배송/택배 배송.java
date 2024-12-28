import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static ArrayList<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}

		System.out.println(dijkstra(1));
		br.close();
	}

	private static int dijkstra(int start) {
		int[] dist = new int[N + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int curIdx = pq.poll()[0];

			for (int[] next : graph[curIdx]) {
				if (dist[next[0]] > dist[curIdx] + next[1]) {
					dist[next[0]] = dist[curIdx] + next[1];
					pq.offer(new int[] {next[0], dist[next[0]]});
				}
			}
		}
		return dist[N];
	}
}
