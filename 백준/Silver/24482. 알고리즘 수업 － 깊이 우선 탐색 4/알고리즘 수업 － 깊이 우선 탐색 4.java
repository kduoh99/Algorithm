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

		for (int i = 1; i <= N; i++)
			Collections.sort(graph[i]);

		dfs(R);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				sb.append(-1).append('\n');
			else
				sb.append(depth[i]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int R) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { R, 0 });

		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			int node = cur[0];
			int nDepth = cur[1];

			if (!visited[node]) {
				visited[node] = true;
				depth[node] = nDepth;

				for (int next : graph[node])
					stack.push(new int[] { next, nDepth + 1 });
			}
		}
	}
}