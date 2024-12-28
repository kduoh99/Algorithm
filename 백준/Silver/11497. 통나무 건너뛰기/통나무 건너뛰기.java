import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] L = new int[N];

			for (int j = 0; j < N; j++)
				L[j] = Integer.parseInt(st.nextToken());

			Arrays.sort(L);
			Deque<Integer> q = new ArrayDeque<>();

			for (int k = 0; k < N; k++) {
				if (k % 2 == 0)
					q.offerFirst(L[k]);
				else
					q.offerLast(L[k]);
			}

			int c = q.peek();
			int max = 0;

			while (q.size() > 1) {
				int a = q.poll();
				int b = q.peek();
				int tmp = Math.abs(a - b);

				if (max < tmp)
					max = tmp;
			}

			int d = q.poll();
			int tmp = Math.abs(c - d);
			sb.append(Math.max(max, tmp)).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
