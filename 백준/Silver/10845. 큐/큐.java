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
		Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int last = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					q.offer(num);
					last = num;
					break;
				case "pop":
					sb.append((q.isEmpty()) ? -1 : q.poll()).append('\n');
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					sb.append((q.isEmpty()) ? 1 : 0).append('\n');
					break;
				case "front":
					sb.append((q.isEmpty()) ? -1 : q.peek()).append('\n');
					break;
				case "back":
					sb.append((q.isEmpty()) ? -1 : last).append('\n');
					break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
