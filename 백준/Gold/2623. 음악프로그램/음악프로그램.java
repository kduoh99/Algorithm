import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int[] in = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());

			for (int j = 1; j < K; j++) {
				int cur = Integer.parseInt(st.nextToken());
				graph[prev].add(cur);
				in[cur]++;
				prev = cur;
			}
		}

		List<Integer> orders = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (in[i] == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int current = pq.poll();
			orders.add(current);

			for (int next : graph[current]) {
				in[next]--;
				if (in[next] == 0)
					pq.add(next);
			}
		}

		if (orders.size() != N) {
			System.out.println(0);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int order : orders) {
			sb.append(order).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}
