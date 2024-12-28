import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);

		int ans = 0;
		for (int i = 2; i <= n; i++)
			if (visited[i])
				ans++;

		System.out.println(ans);
		br.close();
	}

	private static void dfs(int point, int depth) {
		if (depth == 2) return;

		for (int next : graph[point]) {
			visited[next] = true;
			dfs(next, depth + 1);
		}
	}
}