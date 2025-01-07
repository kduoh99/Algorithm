import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (t == 1 && (graph[k].isEmpty() || graph[k].size() == 1)) {
				sb.append("no\n");
			} else {
				sb.append("yes\n");
			}
		}

		System.out.println(sb);
		br.close();
	}
}
