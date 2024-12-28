import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> q = new ArrayDeque<>(n);
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			while (st.hasMoreTokens())
				q.offer(Integer.parseInt(st.nextToken()));

			boolean rev = false, err = false;

			for (char op : p.toCharArray()) {
				if (op == 'R') {
					rev = !rev;
				} else if (op == 'D') {
					if (q.isEmpty()) {
						err = true;
						break;
					}
					if (rev) {
						q.pollLast();
					} else {
						q.poll();
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			if (err) {
				sb.append("error");
			} else {
				sb.append("[");

				if (!q.isEmpty()) {
					if (rev) {
						sb.append(q.pollLast());

						while (!q.isEmpty())
							sb.append(",").append(q.pollLast());
					} else {
						sb.append(q.poll());

						while (!q.isEmpty())
							sb.append(",").append(q.poll());
					}
				}
				sb.append("]");
			}
			System.out.println(sb);
		}
	}
}