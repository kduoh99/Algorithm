import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static int[] discover;
	private static boolean[] isCutV;
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
		isCutV = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			if (discover[i] == 0) {
				dfs(i, true);
			}
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			if (isCutV[i]) {
				cnt++;
				sb.append(i).append(' ');
			}
		}

		System.out.println(cnt + "\n" + sb);
		br.close();
	}

	private static int dfs(int node, boolean isRoot) {
		discover[node] = order++;
		int lowest = discover[node];
		int children = 0;

		for (int next : graph[node]) {
			if (discover[next] == 0) {
				children++;
				int low = dfs(next, false);

				if (!isRoot && low >= discover[node]) {
					isCutV[node] = true;
				}
				lowest = Math.min(lowest, low);
			} else {
				lowest = Math.min(lowest, discover[next]);
			}
		}

		if (isRoot && children >= 2) {
			isCutV[node] = true;
		}

		return lowest;
	}
}
