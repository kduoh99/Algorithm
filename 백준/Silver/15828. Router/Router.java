import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());

		while (true) {
			int v = Integer.parseInt(br.readLine());

			if (v == -1)
				break;

			if (v == 0) {
				q.pollFirst();
				continue;
			}

			if (q.size() < N) {
				q.offer(v);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			sb.append(q.pollFirst()).append(' ');
		}

		System.out.println(sb.length() == 0 ? "empty" : sb);
		br.close();
	}
}
