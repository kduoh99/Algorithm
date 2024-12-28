import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<int[]>[] graph;
	private static boolean[] visited;
	private static int maxD, farthestN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[from].add(new int[] { to, w });
			graph[to].add(new int[] { from, w });
		}

		visited = new boolean[N + 1];
		maxD = 0;
		dfs(1, 0);
		
		visited = new boolean[N + 1];
		maxD = 0;
		dfs(farthestN, 0);

		System.out.println(maxD);
		br.close();
	}

	private static void dfs(int start, int w) {
		visited[start] = true;
		if (maxD < w) {
			maxD = w;
			farthestN = start;
		}

		if (graph[start] != null) {
			for (int[] next : graph[start]) {
				if (!visited[next[0]])
					dfs(next[0], w + next[1]);
			}
		}
	}
}