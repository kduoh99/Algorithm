import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Deque<int[]> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});

			int cnt = 0;
			while (true) {
				int[] front = q.poll();
				boolean flag = true;

				for (int[] tmp : q) {
					if (tmp[1] > front[1]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					cnt++;
					if (front[0] == M) {
						sb.append(cnt).append('\n');
						break;
					}
				} else {
					q.offer(front);
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}