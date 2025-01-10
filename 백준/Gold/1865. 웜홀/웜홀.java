import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = Integer.MAX_VALUE;

	private static List<int[]>[] graph;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph[S].add(new int[] {E, T});
				graph[E].add(new int[] {S, T});
			}

			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken()) * -1;
				graph[S].add(new int[] {E, T});
			}

			sb.append(bellmanFord() ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean bellmanFord() {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		for (int start = 1; start <= N; start++) {
			dist[start] = 0;

			for (int i = 1; i < N; i++) {
				boolean flag = false;

				for (int j = 1; j <= N; j++) {
					if (dist[j] == INF) continue;

					for (int[] edge : graph[j]) {
						if (dist[edge[0]] > dist[j] + edge[1]) {
							dist[edge[0]] = dist[j] + edge[1];
							flag = true;
						}
					}
				}

				if (!flag) break;
			}

			for (int j = 1; j <= N; j++) {
				if (dist[j] == INF) continue;

				for (int[] edge : graph[j]) {
					if (dist[edge[0]] > dist[j] + edge[1]) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
