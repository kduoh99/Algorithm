import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}

		visited = new boolean[n + 1];
		dist = new int[n + 1];
		bfs(a, b);

		System.out.println(!visited[b] ? -1 : dist[b]);
		br.close();
	}

	private static void bfs(int start, int end) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		dist[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end) break;

			for (int next : graph[cur]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					dist[next] = dist[cur] + 1;
				}
			}
		}
	}
}
