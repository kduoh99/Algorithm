import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(graph[i]);

		bfs(N, R);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++)
			sb.append(order[i]).append('\n');

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int N, int R) {
		int val = 1;
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(R);
		visited[R] = true;
		order[R] = val++;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					order[next] = val++;
				}
			}
		}
	}
}
