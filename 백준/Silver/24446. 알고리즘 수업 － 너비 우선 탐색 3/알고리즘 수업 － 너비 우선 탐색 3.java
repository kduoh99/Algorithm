import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		depth = new int[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		bfs(R);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (depth[i] == 0 && i != R) {
				sb.append(-1).append('\n');
				continue;
			}
			sb.append(depth[i]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void bfs(int R) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(R);
		visited[R] = true;
		depth[R] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					depth[next] = depth[cur] + 1;
				}
			}
		}
	}
}