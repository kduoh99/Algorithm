import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static int[] discover;
	private static List<int[]> bridges;
	private static int order = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}

		discover = new int[V + 1];
		bridges = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			if (discover[i] == 0) {
				dfs(i, -1);
			}
		}

		bridges.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		StringBuilder sb = new StringBuilder();

		for (int[] b : bridges) {
			sb.append(b[0]).append(' ').append(b[1]).append('\n');
		}

		System.out.println(bridges.size() + "\n" + sb);
		br.close();
	}

	private static int dfs(int u, int parent) {
		discover[u] = order++;
		int lowest = discover[u];

		for (int v : graph[u]) {
			if (v == parent) continue;

			if (discover[v] == 0) {
				int low = dfs(v, u);

				if (low > discover[u]) {
					bridges.add(new int[] {Math.min(u, v), Math.max(u, v)});
				}
				lowest = Math.min(lowest, low);
			} else {
				lowest = Math.min(lowest, discover[v]);
			}
		}

		return lowest;
	}
}
