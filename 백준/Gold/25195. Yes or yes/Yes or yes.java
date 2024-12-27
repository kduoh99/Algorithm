import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] isFan;
	private static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		isFan = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
		}

		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < S; i++) {
			int s = Integer.parseInt(st.nextToken());
			isFan[s] = true;
		}

		dfs(1);
		System.out.println(!flag ? "Yes" : "yes");
		br.close();
	}

	private static void dfs(int node) {
		if (flag || isFan[node]) {
			return;
		}

		if (graph[node].isEmpty()) {
			flag = true;
			return;
		}

		for (int next : graph[node]) {
			dfs(next);
		}
	}
}
