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
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int X;

			switch (op) {
				case 1:
					X = Integer.parseInt(st.nextToken());
					dq.addFirst(X);
					break;
				case 2:
					X = Integer.parseInt(st.nextToken());
					dq.addLast(X);
					break;
				case 3:
					sb.append(dq.isEmpty() ? -1 : dq.removeFirst()).append('\n');
					break;
				case 4:
					sb.append(dq.isEmpty() ? -1 : dq.removeLast()).append('\n');
					break;
				case 5:
					sb.append(dq.size()).append('\n');
					break;
				case 6:
					sb.append(dq.isEmpty() ? 1 : 0).append('\n');
					break;
				case 7:
					sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
					break;
				case 8:
					sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
					break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}