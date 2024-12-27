import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i)
			graph[i] = new ArrayList<>();

		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);

		visited = new boolean[N + 1];
		bfs(V);

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int start) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (visited[cur]) continue;
			visited[cur] = true;
			sb.append(cur).append(' ');

			for (int i = graph[cur].size() - 1; i >= 0; i--) {
				int child = graph[cur].get(i);
				if (!visited[child])
					stack.push(child);
			}
		}
		sb.append('\n');
	}

	private static void bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur]) continue;
			visited[cur] = true;
			sb.append(cur).append(' ');

			for (int child : graph[cur]) {
				if (!visited[child])
					q.offer(child);
			}
		}
		sb.append('\n');
	}
}
