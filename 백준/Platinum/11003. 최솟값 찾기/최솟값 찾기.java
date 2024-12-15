import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Deque<int[]> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int left = i - L + 1;

			if (!q.isEmpty() && q.peekFirst()[1] < left)
				q.removeFirst();

			while (!q.isEmpty() && q.peekLast()[0] > A[i])
				q.removeLast();

			q.offerLast(new int[] { A[i], i });
			sb.append(q.peek()[0]).append(' ');
		}

		System.out.println(sb);
		br.close();
	}
}
