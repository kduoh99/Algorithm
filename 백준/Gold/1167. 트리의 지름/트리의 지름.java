import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<int[]>[] graph;
	private static boolean[] visited;
	private static int maxD, farthestN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());

			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				int w = Integer.parseInt(st.nextToken());
				graph[from].add(new int[] {to, w});
			}
		}

		dfs(1);
		visited = new boolean[V + 1];
		maxD = 0;
		dfs(farthestN);

		System.out.println(maxD);
		br.close();
	}

	private static void dfs(int start) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {start, 0});

		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			int N = cur[0];
			int D = cur[1];
			visited[N] = true;

			if (maxD < D) {
				maxD = D;
				farthestN = N;
			}

			for (int[] next : graph[N]) {
				if (!visited[next[0]])
					stack.push(new int[] {next[0], D + next[1]});
			}
		}
	}
}
