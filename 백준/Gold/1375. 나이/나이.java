import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		Map<String, Integer> map = new HashMap<>();
		int num = 0;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			if (!map.containsKey(a)) map.put(a, num++);
			if (!map.containsKey(b)) map.put(b, num++);
			graph[map.get(a)].add(map.get(b));
		}

		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			if (!map.containsKey(a) || !map.containsKey(b)) {
				sb.append("gg ");
				continue;
			}

			int aId = map.get(a);
			int bId = map.get(b);

			if (dfs(aId, bId)) {
				sb.append(a).append(' ');
				continue;
			}

			if (dfs(bId, aId)) {
				sb.append(b).append(' ');
				continue;
			}

			sb.append("gg ");
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean dfs(int a, int b) {
		boolean[] visited = new boolean[N];
		Deque<Integer> stack = new ArrayDeque<>();
		visited[a] = true;
		stack.push(a);

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int next : graph[cur]) {
				if (next == b) return true;
				if (!visited[next]) {
					visited[next] = true;
					stack.push(next);
				}
			}
		}

		return false;
	}
}
