import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			flag = false;
			dfs(i, 0);

			if (flag) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
		br.close();
	}

	private static void dfs(int node, int depth) {
		visited[node] = true;

		if (depth == 4) {
			flag = true;
			return;
		}

		for (int n : graph[node]) {
			if (!visited[n])
				dfs(n, depth + 1);
		}

		visited[node] = false;
	}
}
