import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> dq = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}

		st = new StringTokenizer(br.readLine());
		int[] orders = new int[M];
		int count = 0;

		for (int j = 0; j < M; j++) {
			orders[j] = Integer.parseInt(st.nextToken());
			int idx = 0;

			for (Integer e: dq) {
				if (e == orders[j]) break;
				idx++;
			}

			while (true) {
				if (dq.getFirst() == orders[j]) {
					dq.pollFirst();
					break;
				}

				if (idx <= (dq.size() / 2)) {
					int tmp = dq.pollFirst();
					dq.offerLast(tmp);
				} else {
					int tmp = dq.pollLast();
					dq.offerFirst(tmp);
				}
				count++;
			}
		}

		System.out.println(count);
		br.close();
	}
}
